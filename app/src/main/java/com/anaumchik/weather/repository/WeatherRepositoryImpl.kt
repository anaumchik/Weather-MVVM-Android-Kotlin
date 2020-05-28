package com.anaumchik.weather.repository

import com.anaumchik.weather.network.WeatherApi
import com.anaumchik.weather.network.models.WeatherResponse

class WeatherRepositoryImpl(private val api: WeatherApi) : WeatherRepository {

    override suspend fun getWeather(city: String): WeatherResponse = api.getWeather(city)
}