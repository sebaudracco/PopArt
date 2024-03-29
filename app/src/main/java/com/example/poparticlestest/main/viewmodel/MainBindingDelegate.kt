package com.example.poparticlestest.main.viewmodel

import BaseBindingDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.poparticlestest.core.base.viewModel.Event
import com.example.poparticlestest.main.datasource.entity.ViewedArticle

class MainBindingDelegate : BaseBindingDelegate() {

    //region Show progress view
    private val _showProgress = MutableLiveData<Event<Unit>>()
    val showProgress: LiveData<Event<Unit>> get() = _showProgress
    fun showProgressPostValue() {
        _showProgress.value = Event(Unit)
    }
    //endregion
    //region Hide progress view
    private val _hideProgress = MutableLiveData<Event<Unit>>()
    val hideProgress: LiveData<Event<Unit>> get() = _hideProgress
    fun hideProgressPostValue() {
        _hideProgress.value = Event(Unit)
    }
    //endregion

    //region Show Unknown error
    private val _showUnknownError = MutableLiveData<Event<Unit>>()
    val showUnknownError: LiveData<Event<Unit>> get() = _showUnknownError
    fun showUnknownErrorPostValue() {
        _showUnknownError.value = Event(Unit)
    }
    //endregion


    private val _showArticles = MutableLiveData<Event<ViewedArticle>>()
    val showArticles : LiveData<Event<ViewedArticle>> get() = _showArticles
    fun showlistOfArticles(articles: ViewedArticle ) {
        _showArticles.value = Event(articles)
    }


    //endregion

}