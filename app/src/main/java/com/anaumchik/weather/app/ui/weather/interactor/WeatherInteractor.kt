package com.anaumchik.weather.app.ui.weather.interactor

import com.anaumchik.weather.app.models.Weather

interface WeatherInteractor {

    suspend fun getWeather(city: String): Weather
}
