package com.example.poparticlestest

import android.app.Application
import android.content.Context
import com.example.poparticlestest.core.base.apiTestModule
import com.example.poparticlestest.core.koin.module.TestCommonsModule
import com.example.poparticlestest.core.koin.module.testApiArticleModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import org.koin.java.KoinJavaComponent

object KotlinApplication {
    val API_BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2"
    fun onCreate(androidContext: Context, application: Application, list: List<Module>) {
        startKoin {
            androidLogger(Level.INFO)
            androidContext(androidContext)
            koin.loadModules(
                concatenate(
                    list,
                    listOf(
                        apiTestModule,
                        testApiArticleModule
                    )
                )
            )
        }
        KoinJavaComponent.getKoin().setProperty("BASE_URL", API_BASE_URL)
    }

    fun getModules(): List<Module> {
        return KotlinApplication.concatenate(
            TestCommonsModule.getModules(),
        )
    }

    fun <T> concatenate(vararg lists: List<T>): List<T> {
        return listOf(*lists).flatten()
    }
}