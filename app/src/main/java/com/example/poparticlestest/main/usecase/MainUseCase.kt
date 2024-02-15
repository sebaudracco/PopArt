package com.example.poparticlestest.main.usecase

import com.example.poparticlestest.core.base.useCase.BaseUseCase
import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import com.example.poparticlestest.main.datasource.repository.IMainRepository

class MainUseCase (private val mainViewRepository: IMainRepository) :
    BaseUseCase<Int, List<ViewedArticle>>() {

    override suspend fun run(params: Int) : List<ViewedArticle>{
        return mainViewRepository.getArticles(params)
    }
}