package com.example.poparticlestest.main.datasource.repository

import com.example.poparticlestest.main.datasource.entity.ViewedArticle

interface IMainRepository {
    @Throws(Exception::class)
    suspend fun getArticles(query: Int): ViewedArticle

    @Throws(Exception::class)
    fun saveArticles(articles: ViewedArticle)

    @Throws(Exception::class)
    fun getSavedArticles(): ViewedArticle


}