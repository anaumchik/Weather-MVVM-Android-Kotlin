package com.anaumchik.weather.app.ui.weather.repository

import com.anaumchik.weather.app.network.WeatherApi
import com.anaumchik.weather.app.network.models.WeatherResponseModel

class WeatherRepositoryImpl(private val api: WeatherApi) : WeatherRepository {

    override suspend fun getWeather(city: String): WeatherResponseModel = api.getWeather(city)
}
