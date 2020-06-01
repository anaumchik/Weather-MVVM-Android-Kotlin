package com.anaumchik.weather.app.models

data class Weather(val main: Main?)

data class Main(
    val temp: Float,
    val humidity: Float,
    val pressure: Float,
    val temp_min: Float,
    val temp_max: Float
)
