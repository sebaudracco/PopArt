package com.example.poparticlestest.main.module

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.poparticlestest.core.base.util.SharePreferencesManager
import com.example.poparticlestest.core.koin.module.RETROFIT_API_AUTH
import com.example.poparticlestest.data.DAO.ArticlesDao
import com.example.poparticlestest.data.database.AppDatabase
import com.example.poparticlestest.main.datasource.repository.IMainRepository
import com.example.poparticlestest.main.datasource.repository.MainRepository
import com.example.poparticlestest.main.datasource.service.IMainService
import com.example.poparticlestest.main.navigation.MainNavigation
import com.example.poparticlestest.main.usecase.MainGetSavedDataUseCase
import com.example.poparticlestest.main.usecase.MainSaveDataUseCase
import com.example.poparticlestest.main.usecase.MainUseCase
import com.example.poparticlestest.main.viewmodel.MainBindingDelegate
import com.example.poparticlestest.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit


val mainViewModule: Module = module {

    //Inject viewModel
    viewModel {
        MainViewModel(
            mainViewUseCase = get(),
            mainSaveDataViewUseCase = get(),
            mainGetSavedDataViewUseCase = get(),
            sharedPreferences = get(),
            bindingDelegate = get()
        )
    }

    factory { provideDataBase(get()) }
    factory { providerMainViewBindingDelegate() }
    factory { providerArticlesDao(get()) }
    factory { provideRepository(get(), get()) }
    factory { provideSharedPreferences(get()) }


    //Inject service
    single(named("ApiPrivate")) {
        providerMainViewService(
            get(named(RETROFIT_API_AUTH))
        )
    }

    single { providerMainNavigation() }


    //Inject repository
    single<IMainRepository> { MainRepository(get(named("ApiPrivate")), get()) }

    //Inject useCase
    single { providerMainViewUseCase(get()) }
    single { providerMainSaveDataViewUseCase(get()) }
    single { providerMainGetSavedDataViewUseCase(get()) }

}


fun provideSharedPreferences(applicationContext: Context): SharePreferencesManager {
    return SharePreferencesManager(applicationContext)
}

fun provideRepository(
    iService: IMainService,
    articlesDao: ArticlesDao): MainRepository {
    return MainRepository(iService, articlesDao)
}

fun provideDataBase(applicationContext: Context): AppDatabase {
    return Room.databaseBuilder(applicationContext, AppDatabase::class.java, "App-Database").build()
}

fun providerArticlesDao(appDatabase: AppDatabase): ArticlesDao {
    return appDatabase.articlesDao()
}

fun providerMainViewBindingDelegate(): MainBindingDelegate {
    return MainBindingDelegate()
}

fun providerMainNavigation(): MainNavigation {
    return MainNavigation()
}

fun providerMainViewUseCase(mainViewRepository: IMainRepository): MainUseCase {
    return MainUseCase(mainViewRepository)
}

fun providerMainGetSavedDataViewUseCase(mainViewRepository: IMainRepository): MainGetSavedDataUseCase {
    return MainGetSavedDataUseCase(mainViewRepository)
}

fun providerMainSaveDataViewUseCase(mainViewRepository: IMainRepository): MainSaveDataUseCase {
    return MainSaveDataUseCase(mainViewRepository)
}

fun providerMainViewService(retrofit: Retrofit): IMainService {
    return retrofit.create(IMainService::class.java)
}



