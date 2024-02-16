package com.example.poparticlestest.main.usecase

import com.example.poparticlestest.core.base.useCase.BaseUseCase
import com.example.poparticlestest.main.datasource.entity.ViewedArticle
import com.example.poparticlestest.main.datasource.repository.IMainRepository

class MainSaveDataUseCase (private val mainViewRepository: IMainRepository) :
    BaseUseCase<ViewedArticle, Unit>() {

    override suspend fun run(params: ViewedArticle)  {
        return mainViewRepository.saveArticles(params)
    }
}