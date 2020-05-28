package com.anaumchik.weather.repository

import com.anaumchik.weather.network.models.WeatherResponse

interface WeatherRepository {

    suspend fun getWeather(city: String): WeatherResponse
}