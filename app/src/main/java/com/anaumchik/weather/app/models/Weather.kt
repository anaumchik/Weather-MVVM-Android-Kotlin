package com.anaumchik.weather.app.models

data class Weather(val main: Main?)

data class Main(
    val temp: Float = 0.toFloat(),
    val humidity: Float = 0.toFloat(),
    val pressure: Float = 0.toFloat(),
    val temp_min: Float = 0.toFloat(),
    val temp_max: Float = 0.toFloat()
)
