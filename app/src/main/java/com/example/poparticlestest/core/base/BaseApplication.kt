package com.example.poparticlestest.core.base

import android.app.Application
import com.example.poparticlestest.KotlinApplication
import com.google.firebase.FirebaseApp

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        PerformanceManager.initPerformance()
        KotlinApplication.onCreate(this, this, KotlinApplication.getModules())
    }


}
