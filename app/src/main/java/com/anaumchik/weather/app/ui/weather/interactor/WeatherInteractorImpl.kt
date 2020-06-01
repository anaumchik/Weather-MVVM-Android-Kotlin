package com.anaumchik.weather.app.ui.weather.interactor

import com.anaumchik.weather.app.models.Weather
import com.anaumchik.weather.app.network.mappers.toModel
import com.anaumchik.weather.app.ui.weather.repository.WeatherRepository

class WeatherInteractorImpl(private val repository: WeatherRepository) : WeatherInteractor {

    override suspend fun getWeather(city: String): Weather {
        return repository.getWeather(city).toModel()
    }
}
