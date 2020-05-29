package com.anaumchik.weather.app.network.mappers

import com.anaumchik.weather.app.models.Main
import com.anaumchik.weather.app.models.Weather
import com.anaumchik.weather.app.network.models.MainResponse
import com.anaumchik.weather.app.network.models.WeatherResponseModel

fun WeatherResponseModel.toModel(): Weather = Weather(
    main = this.main?.toModel()
)

internal fun MainResponse.toModel(): Main = Main(
    temp = this.temp,
    humidity = this.humidity,
    pressure = this.pressure,
    temp_min = this.temp_min,
    temp_max = this.temp_max
)
