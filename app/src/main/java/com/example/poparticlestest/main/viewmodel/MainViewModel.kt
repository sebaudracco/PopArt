package com.example.poparticlestest.main.viewmodel

import BaseViewModel
import androidx.lifecycle.viewModelScope
import com.example.poparticlestest.main.datasource.entity.Results
import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import com.example.poparticlestest.main.usecase.MainUseCase
import kotlinx.coroutines.launch
import java.util.ArrayList

class MainViewModel(
    private val mainViewUseCase: MainUseCase,
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

                is BaseResultWrapper.ApiSuccess ->
                    presenterDelegate.showlistOfArticles(response.value)

                else -> presenterDelegate.showUnknownErrorPostValue() // poner otro estado
            }
        }
    }

    fun showProgressPostValue(){
        bindingDelegate.showProgressPostValue()
    }

    fun hideProgressPostValue(){
        bindingDelegate.hideProgressPostValue()
    }



    fun getEmptyList(): List<Results>{
        return emptyList()
    }

}