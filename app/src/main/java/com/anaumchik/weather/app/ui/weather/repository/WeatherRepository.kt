package com.anaumchik.weather.app.ui.weather.repository

import com.anaumchik.weather.app.network.models.WeatherResponseModel

interface WeatherRepository {

    suspend fun getWeather(city: String): WeatherResponseModel
}