package com.anaumchik.weather.app.repository

import com.anaumchik.weather.app.models.Weather

interface WeatherRepository {

    suspend fun getWeather(city: String): Weather
}