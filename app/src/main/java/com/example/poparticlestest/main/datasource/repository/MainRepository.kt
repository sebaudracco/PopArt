package com.example.poparticlestest.main.datasource.repository

import com.example.poparticlestest.core.base.util.Constants
import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import com.example.poparticlestest.main.datasource.service.IMainService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val iService: IMainService
) : IMainRepository {


    @Throws(Exception::class)
    override suspend fun getArticles(query: Int): ViewedArticle{
        return iService.getArticles(query, Constants.API_PUBLIC_KEY)
    }
}