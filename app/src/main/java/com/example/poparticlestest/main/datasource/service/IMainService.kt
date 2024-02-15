package com.example.poparticlestest.main.datasource.service

import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMainService {

    @GET("viewed/{period}.json")
    suspend fun getArticles(@Path("period") period: Int,
                            @Query("api-key") apiKey: String
    ) : ViewedArticle
}