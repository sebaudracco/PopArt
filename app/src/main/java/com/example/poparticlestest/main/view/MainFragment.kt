package com.example.poparticlestest.main.view

import BaseFragment
import BaseViewModel
import IOnItemClickViewHolder
import android.content.Intent
import android.view.View

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poparticlestest.R
import com.example.poparticlestest.core.base.util.NetworkUtils
import com.example.poparticlestest.core.base.viewModel.Event
import com.example.poparticlestest.core.base.viewModel.observe
import com.example.poparticlestest.databinding.MainViewFragmentBinding
import com.example.poparticlestest.main.datasource.entity.Results
import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import com.example.poparticlestest.main.navigation.MainNavigation
import com.example.poparticlestest.main.view.webview.WebViewActivity
import com.example.poparticlestest.main.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.android.ext.android.inject

class MainFragment : BaseFragment<MainViewFragmentBinding>() {

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter
    private val navigator: MainNavigation by inject()
    private var articles: List<Results> = arrayListOf()

    override fun getViewModel(): BaseViewModel = mainViewModel

    override fun bindObserversToLiveData() {
        observe(mainViewModel.bindingDelegate.showProgress, this::showProgress)
        observe(mainViewModel.bindingDelegate.hideProgress, this::hideProgress)
        observe(mainViewModel.bindingDelegate.showUnknownError, this::showUnknownError)
        observe(mainViewModel.bindingDelegate.showArticles, this::viewedArticles)
    }


    override fun viewOnReady() {
        initViews()
    }


    private fun viewedArticles(event: Event<ViewedArticle>) {
        event.getContentIfNotHandled().let { it ->
            it?.apply {
                it.results?.let { results ->
                    if (results.isEmpty()) {
                        getScreenError()
                    } else {
                        articles = results
                        adapter.let {
                            it.dataList = articles
                            it.isDelete = false
                            it.setData(articles)
                            it.notifyDataSetChanged()
                        }
                        mainViewModel.save(it)
                    }
                } ?: run {
                    getScreenError()
                }


            }
        }
    }

    private fun getScreenError() {
        bindingView.genericError.root.toVisible()
        bindingView.genericError.tvActionServiceError.setOnClickListener {
            bindingView.genericError.root.toGone()
        }
    }


    private fun initViews() {
        initViewAdapter()
        setView()
        search()
    }

    private fun search() {
        if (checkBasicConnection()) {
            mainViewModel.getArticlesByTime(query = NEWS_BY_MONTH)
        } else {
            mainViewModel.getSavedArticles()
        }
    }

    private fun setView() {

        initViewAdapter()

        bindingView.btnMonth.setOnClickListener {
            if (checkBasicConnection()) {
                adapter.setData(mainViewModel.getEmptyList())
                it.isEnabled = false
                bindingView.btnWeek.isEnabled = true
                bindingView.btnDay.isEnabled = true
                initViewAdapter()
                mainViewModel.showProgressPostValue()
                mainViewModel.getArticlesByTime(query = NEWS_BY_MONTH)
            } else {
                mainViewModel.getSavedArticles()
            }
        }

        bindingView.btnWeek.setOnClickListener {
            if (checkBasicConnection()) {
                adapter.setData(mainViewModel.getEmptyList())
                it.isEnabled = false
                bindingView.btnMonth.isEnabled = true
                bindingView.btnDay.isEnabled = true
                initViewAdapter()
                mainViewModel.showProgressPostValue()
                mainViewModel.getArticlesByTime(query = NEWS_BY_WEEK)
            } else {
                mainViewModel.getSavedArticles()
            }
        }

        bindingView.btnDay.setOnClickListener {
            if (checkBasicConnection()) {
                it.isEnabled = false
                bindingView.btnWeek.isEnabled = true
                bindingView.btnMonth.isEnabled = true
                initViewAdapter()
                mainViewModel.showProgressPostValue()
                mainViewModel.getArticlesByTime(query = NEWS_BY_DAY)
            } else {
                mainViewModel.getSavedArticles()
            }
        }
    }


    private fun initViewAdapter() {
        adapter = MainAdapter(
            isDelete = false,
            dataList = arrayListOf(),
            onItemClickListener = (object : IOnItemClickViewHolder {

                override fun onItemClick(caller: View?, position: Int, article: Results) {
                    if (isActionEnable()) {
                        onPickArticleScreen(article.url, article.title)
                    }
                }
            })
        )
        bindingView.rvarticles.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        bindingView.rvarticles.adapter = adapter
    }

    private fun onPickArticleScreen(url: String, title: String) {
        val intent = Intent(requireActivity(), WebViewActivity::class.java)
        intent.putExtra("url", url)
        intent.putExtra("title", title)
        requireActivity().startActivity(intent)
    }


    private fun showProgress(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.progress.vProgress.toVisible()
            }
        }
    }

    private fun hideProgress(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.progress.vProgress.toGone()
            }
        }
    }


    private fun showUnknownError(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.genericError.root.toVisible()
                bindingView.genericError.tvActionServiceError.setOnClickListener {
                    bindingView.genericError.root.toGone()
                    mainViewModel.getArticlesByTime(query = NEWS_BY_DAY)
                }
            }
        }
    }



    private fun checkBasicConnection(): Boolean {
        val networkUtils = NetworkUtils(this.requireContext())
        return if (!networkUtils.isNetworkConnected()) {
            Snackbar.make(
                requireView(),
                R.string.no_internet_limited_content,
                Snackbar.LENGTH_LONG
            ).show()
            false
        } else {
            true
        }
    }

    companion object {
        const val NEWS_BY_DAY = 1
        const val NEWS_BY_WEEK = 7
        const val NEWS_BY_MONTH = 30
    }
}