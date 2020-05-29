package com.anaumchik.weather.app.network

import com.anaumchik.weather.app.network.models.WeatherResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather?&appid=${NetworkClient.API_KEY}")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String = NetworkClient.UNITS_METRIC
    ): WeatherResponseModel
}