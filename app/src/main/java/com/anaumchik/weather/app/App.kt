package com.anaumchik.weather.app

import android.app.Application
import com.anaumchik.weather.app.network.NetworkClient
import com.anaumchik.weather.app.ui.weather.WeatherViewModel
import com.anaumchik.weather.app.ui.weather.interactor.WeatherInteractor
import com.anaumchik.weather.app.ui.weather.interactor.WeatherInteractorImpl
import com.anaumchik.weather.app.ui.weather.repository.WeatherRepository
import com.anaumchik.weather.app.ui.weather.repository.WeatherRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    private val modules = module {
        single<WeatherRepository> { WeatherRepositoryImpl(NetworkClient.weatherApi) }
        single<WeatherInteractor> { WeatherInteractorImpl(get()) }
        viewModel { WeatherViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(modules))
        }
    }
}