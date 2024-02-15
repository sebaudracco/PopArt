package com.example.poparticlestest.main.viewmodel

import BasePresenterDelegate
import com.example.poparticlestest.main.datasource.entity.ViewedArticle

class MainPresenterDelegate (private val bindingDelegate: MainBindingDelegate) :
    BasePresenterDelegate(bindingDelegate) {

    fun showlistOfArticles(value: ViewedArticle) {
        bindingDelegate.hideProgressPostValue()
        value?.let {
            bindingDelegate.showlistOfArticles((it)) }
    }

    fun showUnknownErrorPostValue(){
        bindingDelegate.hideProgressPostValue()
        bindingDelegate.showUnknownErrorPostValue()
    }

}