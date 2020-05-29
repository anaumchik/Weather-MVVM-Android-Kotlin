package com.anaumchik.weather.app.repository

import com.anaumchik.weather.app.models.Weather
import com.anaumchik.weather.app.network.WeatherApi
import com.anaumchik.weather.app.network.mappers.toModel

class WeatherRepositoryImpl(private val api: WeatherApi) : WeatherRepository {

    override suspend fun getWeather(city: String): Weather = api.getWeather(city).toModel()
}