package com.example.poparticlestest.main.usecase

import com.example.poparticlestest.core.base.useCase.BaseUseCase
import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import com.example.poparticlestest.main.datasource.repository.IMainRepository

class MainGetSavedDataUseCase (private val mainViewRepository: IMainRepository) :
    BaseUseCase<Unit, ViewedArticle>() {

    override suspend fun run(params: Unit): ViewedArticle  {
        return mainViewRepository.getSavedArticles()
    }
}