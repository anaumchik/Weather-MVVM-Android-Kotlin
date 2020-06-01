package com.anaumchik.weather.app.models

data class Weather(
    val main: Main?,
    val wind: Wind?
)

data class Main(
    val temp: Float,
    val humidity: Float,
    val pressure: Float,
    val temp_min: Float,
    val temp_max: Float
)

data class Wind(
    val speed: Float,
    val deg: Float
)