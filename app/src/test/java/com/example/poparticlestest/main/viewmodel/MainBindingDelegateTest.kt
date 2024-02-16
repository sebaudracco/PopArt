package com.example.poparticlestest.main.viewmodel

import com.example.poparticlestest.core.base.viewModel.Event
import com.example.poparticlestest.main.BaseUnitTest
import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Assert
import org.junit.Test

class MainBindingDelegateTest : BaseUnitTest() {

    private lateinit var bindingDelegate: MainBindingDelegate

    override fun setup() {
        super.setup()
        bindingDelegate = MainBindingDelegate()
    }

    //region showProgressPostValue
    @Test
    fun `We test that the method showProgressPostValue changes the value of the liveData`() {

        bindingDelegate.showProgressPostValue()
        Assert.assertNotNull(bindingDelegate.showProgress.value)
        MatcherAssert.assertThat(bindingDelegate.showProgress.value, CoreMatchers.instanceOf(Event::class.java))
        Assert.assertEquals(Unit, (bindingDelegate.showProgress.value as Event).peekContent())
    }
    //endregion

    //region hideProgressPostValue
    @Test
    fun `We test that the method hideProgressPostValue changes the value of the liveData`() {

        bindingDelegate.hideProgressPostValue()
        Assert.assertNotNull(bindingDelegate.hideProgress.value)
        MatcherAssert.assertThat(bindingDelegate.hideProgress.value, CoreMatchers.instanceOf(Event::class.java))
        Assert.assertEquals(Unit, (bindingDelegate.hideProgress.value as Event).peekContent())    }
    //endregion

    //region showUnknownErrorPostValue
    @Test
    fun `We test that the method showUnknownErrorPostValue changes the value of the liveData`() {
        bindingDelegate.showUnknownErrorPostValue()
        Assert.assertNotNull(bindingDelegate.showUnknownError.value)
        MatcherAssert.assertThat(bindingDelegate.showUnknownError.value, CoreMatchers.instanceOf(Event::class.java))
        Assert.assertEquals(Unit, (bindingDelegate.showUnknownError.value as Event).peekContent())
    }
    //endregion

    //region hideProgressPostValue
    @Test
    fun `We test that the method showlistOfArticles changes the value of the liveData`() {
        val article = ViewedArticle("copyrigth", "OKA", 20, null)
        bindingDelegate.showlistOfArticles(article)
        Assert.assertNotNull(bindingDelegate.showArticles.value)
        MatcherAssert.assertThat(bindingDelegate.showArticles.value, CoreMatchers.instanceOf(Event::class.java))
        Assert.assertEquals(article, (bindingDelegate.showArticles.value as Event).peekContent())    }
    //endregion
}