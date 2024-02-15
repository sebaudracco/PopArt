package com.example.poparticlestest.main.datasource.service

import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import retrofit2.http.GET
import retrofit2.http.Query

interface IMainService {

    @GET("viewed")
    suspend fun getArticles(@Query("period") period: Int): List<ViewedArticle>
}