package com.anaumchik.weather

import android.app.Application
import com.anaumchik.weather.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    private val modules = module {
        viewModel { MainViewModel() }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(modules))
        }
    }
}