package com.anaumchik.weather.network

import com.anaumchik.weather.network.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather?&appid=${NetworkClient.API_KEY}")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String = NetworkClient.UNITS_METRIC
    ): WeatherResponse
}