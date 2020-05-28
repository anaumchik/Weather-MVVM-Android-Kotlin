package com.anaumchik.weather.app.repository

import com.anaumchik.weather.app.network.WeatherApi
import com.anaumchik.weather.app.network.models.WeatherResponse

class WeatherRepositoryImpl(private val api: WeatherApi) : WeatherRepository {

    override suspend fun getWeather(city: String): WeatherResponse = api.getWeather(city)
}