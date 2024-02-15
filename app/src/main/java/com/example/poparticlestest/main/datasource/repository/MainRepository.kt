package com.example.poparticlestest.main.datasource.repository

import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import com.example.poparticlestest.main.datasource.service.IMainService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val iService: IMainService
) : IMainRepository {


    @Throws(Exception::class)
    override suspend fun getArticles(query: Int): List<ViewedArticle>{
        return iService.getArticles(query)
    }
}