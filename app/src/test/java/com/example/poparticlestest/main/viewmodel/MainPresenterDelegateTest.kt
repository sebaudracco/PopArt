package com.example.poparticlestest.main.viewmodel

import com.example.poparticlestest.main.BaseUnitTest
import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import org.junit.Test
import org.mockito.Mockito

class MainPresenterDelegateTest : BaseUnitTest() {

    private lateinit var presenterDelegate: MainPresenterDelegate
    private lateinit var bindingDelegate: MainBindingDelegate

    override fun setup() {
        super.setup()
        bindingDelegate = Mockito.spy(MainBindingDelegate())
        presenterDelegate = MainPresenterDelegate(bindingDelegate)
    }

    @Test
    fun `We test the method showlistOfArticles when ProfileModel is from data`() {
        //When
        val article = ViewedArticle("copyrigth", "OKA", 20, null)
        presenterDelegate.showlistOfArticles(article)
        bindingDelegate.hideProgressPostValue()
        presenterDelegate.hideProgressView()
        //Then
        Mockito.verify(bindingDelegate).showlistOfArticles(article)
    }

    @Test
    fun `We test the method showUnknownErrorPostValue `() {
        //When
        presenterDelegate.showUnknownErrorPostValue()
        bindingDelegate.hideProgressPostValue()
        presenterDelegate.hideProgressView()
        //Then
        Mockito.verify(bindingDelegate).showUnknownErrorPostValue()
    }

}