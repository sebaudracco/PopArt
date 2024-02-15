package com.example.poparticlestest.main.module

import com.example.poparticlestest.core.koin.module.RETROFIT_API_AUTH
import com.example.poparticlestest.main.datasource.repository.IMainRepository
import com.example.poparticlestest.main.datasource.repository.MainRepository
import com.example.poparticlestest.main.datasource.service.IMainService
import com.example.poparticlestest.main.navigation.MainNavigation
import com.example.poparticlestest.main.usecase.MainUseCase
import com.example.poparticlestest.main.viewmodel.MainBindingDelegate
import com.example.poparticlestest.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit


val mainViewModule: Module =  module {

    //Inject viewModel
    viewModel { MainViewModel(mainViewUseCase = get(), bindingDelegate = get()) }
    factory { providerMainViewBindingDelegate() }

    //Inject repository
    single<IMainRepository> {  MainRepository(get(named("ApiPrivate"))) }

    //Inject useCase
    single { providerMainViewUseCase(get()) }

    //Inject service
    single(named("ApiPrivate")) {
        providerMainViewService(
            get(named(RETROFIT_API_AUTH))
        )
    }

    single { providerMainNavigation() }

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

fun providerMainViewService(retrofit: Retrofit): IMainService {
    return retrofit.create(IMainService::class.java)
}



