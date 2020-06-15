package com.anaumchik.weather.app.network.mappers

import com.anaumchik.weather.app.models.Main
import com.anaumchik.weather.app.models.Weather
import com.anaumchik.weather.app.models.Wind
import com.anaumchik.weather.app.network.models.MainResponse
import com.anaumchik.weather.app.network.models.WeatherResponseModel
import com.anaumchik.weather.app.network.models.WindResponse

fun WeatherResponseModel.toModel(): Weather = Weather(
    main = this.main?.toModel(),
    wind = this.wind?.toModel(),
    name = this.name
)

internal fun MainResponse.toModel(): Main = Main(
    temp = this.temp,
    humidity = this.humidity,
    pressure = this.pressure,
    temp_min = this.temp_min,
    temp_max = this.temp_max
)

internal fun WindResponse.toModel(): Wind = Wind(
    speed = this.speed,
    deg = this.deg
)

