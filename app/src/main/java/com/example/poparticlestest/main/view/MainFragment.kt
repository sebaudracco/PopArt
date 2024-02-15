package com.example.poparticlestest.main.view

import BaseFragment
import BaseViewModel
import IOnItemClickViewHolder
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poparticlestest.R
import com.example.poparticlestest.core.base.util.NetworkUtils
import com.example.poparticlestest.core.base.viewModel.Event
import com.example.poparticlestest.core.base.viewModel.observe
import com.example.poparticlestest.databinding.MainViewFragmentBinding
import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import com.example.poparticlestest.main.navigation.MainNavigation
import com.example.poparticlestest.main.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.android.ext.android.inject

class MainFragment : BaseFragment<MainViewFragmentBinding>() {

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter
    private val navigator: MainNavigation by inject()
    private var articles: List<ViewedArticle> = arrayListOf()

    // override methods
    override fun getViewModel(): BaseViewModel = mainViewModel

    override fun bindObserversToLiveData() {
        observe(mainViewModel.bindingDelegate.showProgress, this::showProgress)
        observe(mainViewModel.bindingDelegate.hideProgress, this::hideProgress)
        observe(mainViewModel.bindingDelegate.showNetworkError, this::showNetworkError)
        observe(mainViewModel.bindingDelegate.hideNetworkError, this::hideNetworkError)
        observe(mainViewModel.bindingDelegate.showUnknownError, this::showUnknownError)
        observe(mainViewModel.bindingDelegate.hideUnknownError, this::hideUnknownError)
        observe(mainViewModel.bindingDelegate.showArticles, this::viewedArticles)
    }


    override fun viewOnReady() {
        initViews()
    }


    private fun viewedArticles(event: Event<List<ViewedArticle>>) {
        event.getContentIfNotHandled().let { it ->
            it.apply {
                if (it?.size == 0) {
                    bindingView.genericError.root.toVisible()
                    bindingView.genericError.tvActionServiceError.setOnClickListener {
                        bindingView.genericError.root.toGone()
                        getData()
                    }
                }
                articles = it!!
                adapter?.let {
                    it.dataList = articles
                    it.isDelete = false
                    it.notifyDataSetChanged()
                }
            }
            adapter!!.setData(articles)

        }
    }

    private fun getData() {
        Handler().postDelayed({
         //   mainViewModel.getarticles()
        }, 2000)
    }

    private fun initViews() {
        initViewAdapter()
        getData()
        setView()
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
                mainViewModel.getArticlesByTime(query = 30)
            }
        }

        bindingView.btnWeek.setOnClickListener {
            if(checkBasicConnection()){
                adapter.setData(mainViewModel.getEmptyList())
                it.isEnabled = false
                bindingView.btnMonth.isEnabled = true
                bindingView.btnDay.isEnabled = true
                initViewAdapter()
                mainViewModel.showProgressPostValue()
                mainViewModel.getArticlesByTime(query = 7)
            }
        }

        bindingView.btnDay.setOnClickListener {
            if(checkBasicConnection()){
                it.isEnabled = false
                bindingView.btnWeek.isEnabled = true
                bindingView.btnMonth.isEnabled = true
                initViewAdapter()
                mainViewModel.showProgressPostValue()
                mainViewModel.getArticlesByTime(query = 1)
            }
        }
    }


    private fun initViewAdapter() {
        adapter = MainAdapter(
            isDelete = false,
            dataList = arrayListOf(),
            onItemClickListener = (object : IOnItemClickViewHolder {

                override fun onItemClick(caller: View?, position: Int, id: Int?) {
                    if (isActionEnable()) {
                        navigator.navigateToDetail(requireActivity(), id)  //DESARROLLAR
                    }
                }
            })
        )
        bindingView.rvarticles.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        bindingView.rvarticles.adapter = adapter
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

    private fun showNetworkError(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.notNetwork.root.toVisible()
            }
        }
    }

    private fun hideNetworkError(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.notNetwork.root.toGone()
            }
        }
    }

    private fun showUnknownError(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.genericError.root.toVisible()
                bindingView.genericError.tvActionServiceError.setOnClickListener {
                    bindingView.genericError.root.toGone()
                }
            }
        }
    }

    private fun hideUnknownError(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.genericError.root.toGone()
            }
        }
    }

    private fun checkBasicConnection(): Boolean{
        val networkUtils = NetworkUtils(this.requireContext())
        return if (!networkUtils.isNetworkConnected()) {
            Snackbar.make(
                requireView(),
                R.string.no_internet_limited_content,
                Snackbar.LENGTH_LONG
            ).show()
            false
        }else{
            true
        }
    }
}