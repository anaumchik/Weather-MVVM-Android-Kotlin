package com.anaumchik.weather.app

import android.app.Application
import com.anaumchik.weather.app.network.NetworkClient
import com.anaumchik.weather.app.repository.WeatherRepositoryImpl
import com.anaumchik.weather.app.ui.weather.WeatherViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    private val modules = module {
        single { WeatherRepositoryImpl(NetworkClient.weatherApi) }
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