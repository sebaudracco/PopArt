package com.example.poparticlestest.core.koin.module

import com.example.poparticlestest.KotlinApplication.concatenate
import com.example.poparticlestest.core.base.apiTestModule
import com.example.poparticlestest.main.module.mainViewModule
import org.koin.core.module.Module


object TestCommonsModule{

    fun getModules(): List<Module>{
        return concatenate(
            getApiModules()
        )
    }

    private fun getApiModules(): List<Module>{
        return listOf(
            apiTestModule,
            testApiArticleModule,
            apiAuthModule,
            mainViewModule
        )
    }
}