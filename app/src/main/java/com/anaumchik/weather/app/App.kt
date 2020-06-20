package com.anaumchik.weather.app

import android.app.Application
import com.anaumchik.weather.app.network.NetworkClient
import com.anaumchik.weather.app.ui.weather.WeatherViewModel
import com.anaumchik.weather.app.ui.weather.interactor.WeatherInteractor
import com.anaumchik.weather.app.ui.weather.interactor.WeatherInteractorImpl
import com.anaumchik.weather.app.ui.weather.repository.WeatherRepository
import com.anaumchik.weather.app.ui.weather.repository.WeatherRepositoryImpl
import com.anaumchik.weather.app.utils.DateUtils
import com.anaumchik.weather.app.utils.StringUtils
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App : Application() {

    private val modules = module {
        single<WeatherRepository> { WeatherRepositoryImpl(NetworkClient.weatherApi) }
        single<WeatherInteractor> {
            WeatherInteractorImpl(
                repository = get(),
                dateUtils = get()
            )
        }
        single { StringUtils(context = applicationContext) }
        single { DateUtils(stringUtils = get()) }
        viewModel { WeatherViewModel(interactor = get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@App)
            modules(listOf(modules))
        }
    }
}