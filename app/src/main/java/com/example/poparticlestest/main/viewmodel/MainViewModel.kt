package com.example.poparticlestest.main.viewmodel

import BaseViewModel
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewModelScope
import com.example.poparticlestest.core.base.util.Constants
import com.example.poparticlestest.core.base.util.SharePreferencesManager
import com.example.poparticlestest.data.database.AppDatabase
import com.example.poparticlestest.main.datasource.entity.Results
import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import com.example.poparticlestest.main.usecase.MainGetSavedDataUseCase
import com.example.poparticlestest.main.usecase.MainSaveDataUseCase
import com.example.poparticlestest.main.usecase.MainUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainViewUseCase: MainUseCase,
    private val mainSaveDataViewUseCase: MainSaveDataUseCase,
    private val mainGetSavedDataViewUseCase: MainGetSavedDataUseCase,
    private val sharedPreferences: SharePreferencesManager,
    override val bindingDelegate: MainBindingDelegate,
    private val presenterDelegate: MainPresenterDelegate = MainPresenterDelegate(
        bindingDelegate
    )
) : BaseViewModel(bindingDelegate, presenterDelegate) {

    fun getArticlesByTime(query: Int) {
        viewModelScope.launch {
            bindingDelegate.showProgressPostValue()
            when (val response = mainViewUseCase.invoke(query)) {
                is BaseResultWrapper.ApiError -> presenterDelegate.showUnknownErrorPostValue()

                is BaseResultWrapper.ApiSuccess -> presenterDelegate.showlistOfArticles(response.value)
            }
        }
    }


    fun showProgressPostValue() {
        bindingDelegate.showProgressPostValue()
    }

    fun hideProgressPostValue() {
        bindingDelegate.hideProgressPostValue()
    }


    fun getEmptyList(): List<Results> {
        return emptyList()
    }

    fun save(articles: ViewedArticle) {
        goToSaveArticles(articles)
    }

    private fun goToSaveArticles(articles: ViewedArticle) {
        viewModelScope.launch {
            bindingDelegate.showProgressPostValue()
            when (val response = mainSaveDataViewUseCase.invoke(articles)) {
                is BaseResultWrapper.ApiError -> hideProgressPostValue()

                is BaseResultWrapper.ApiSuccess -> sharedPreferences.setBoolean(
                    Constants.KEY_SAVED_DATABASE,
                    true
                )
            }
        }
    }

    fun getSavedArticles() {
        getSaveArticles()
    }

    private fun getSaveArticles() {
        viewModelScope.launch {
            bindingDelegate.showProgressPostValue()
            when (val response = mainGetSavedDataViewUseCase.invoke(Unit)) {
                is BaseResultWrapper.ApiError -> presenterDelegate.showUnknownErrorPostValue()

                is BaseResultWrapper.ApiSuccess -> {
                    response.value?.let {
                        presenterDelegate.showlistOfArticles(response.value)
                    } ?: run {
                        presenterDelegate.showGenericError()
                    }
                }
            }
        }
    }


}