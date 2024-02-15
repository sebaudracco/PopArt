package com.example.poparticlestest.main.viewmodel

import BaseBindingDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.poparticlestest.core.base.viewModel.Event
import com.example.poparticlestest.main.datasource.entity.ViewedArticle

class MainBindingDelegate : BaseBindingDelegate() {
    //region Generic actions
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
    //region Show Network error
    private val _showNetworkError = MutableLiveData<Event<Unit>>()
    val showNetworkError: LiveData<Event<Unit>> get() = _showNetworkError
    fun showNetworkErrorPostValue() {
        _showNetworkError.value = Event(Unit)
    }
    //endregion
    //region Hide Network error
    private val _hideNetworkError = MutableLiveData<Event<Unit>>()
    val hideNetworkError: LiveData<Event<Unit>> get() = _hideNetworkError
    fun hideNetworkErrorPostValue() {
        _hideNetworkError.value = Event(Unit)
    }
    //endregion
    //region Show Unknown error
    private val _showUnknownError = MutableLiveData<Event<Unit>>()
    val showUnknownError: LiveData<Event<Unit>> get() = _showUnknownError
    fun showUnknownErrorPostValue() {
        _showUnknownError.value = Event(Unit)
    }
    //endregion
    //region Hide Unknown error
    private val _hideUnknownError = MutableLiveData<Event<Unit>>()
    val hideUnknownError: LiveData<Event<Unit>> get() = _hideUnknownError
    fun hideUnknownErrorPostValue() {
        _hideUnknownError.value = Event(Unit)
    }

    private val _showArticles = MutableLiveData<Event<List<ViewedArticle>>>()
    val showArticles : LiveData<Event<List<ViewedArticle>>> get() = _showArticles
    fun showlistOfArticles(listCharacters: List<ViewedArticle> ) {
        _showArticles.value = Event(listCharacters)
    }


    //endregion
    //endregion

}