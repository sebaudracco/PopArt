package com.example.poparticlestest.main.viewmodel

import BasePresenterDelegate
import com.example.poparticlestest.main.datasource.entity.ViewedArticle

class MainPresenterDelegate (private val bindingDelegate: MainBindingDelegate) :
    BasePresenterDelegate(bindingDelegate) {

    fun showlistOfArticles(value: ViewedArticle) {
        bindingDelegate.hideProgressPostValue()
        bindingDelegate.showlistOfArticles((value))
    }

    fun showUnknownErrorPostValue(){
        bindingDelegate.hideProgressPostValue()
        bindingDelegate.showUnknownErrorPostValue()
    }

}