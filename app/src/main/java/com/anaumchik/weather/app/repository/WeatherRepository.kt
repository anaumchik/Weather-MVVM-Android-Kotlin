package com.anaumchik.weather.app.repository

import com.anaumchik.weather.app.network.models.WeatherResponse

interface WeatherRepository {

    suspend fun getWeather(city: String): WeatherResponse
}