package com.anaumchik.weather.app.network.models

data class WeatherResponseModel(
    val coord: CoordResponse? = null,
    val sys: SysResponse? = null,
    val weather: List<WeatherResponse> = emptyList(),
    val main: MainResponse? = null,
    val wind: WindResponse? = null,
    val rain: RainResponse? = null,
    val clouds: CloudsResponse? = null,
    val dt: Float = 0.toFloat(),
    val id: Int = 0,
    val name: String? = null,
    val cod: Float = 0.toFloat()
)

data class WeatherResponse(
    val id: Int = 0,
    val main: String? = null,
    val description: String? = null,
    val icon: String? = null
)

data class CloudsResponse(
    val all: Float = 0.toFloat()
)

data class RainResponse(
    val h3: Float = 0.toFloat()
)

data class WindResponse(
    val speed: Float = 0.toFloat(),
    val deg: Float = 0.toFloat()
)

data class MainResponse(
    val temp: Float = 0.toFloat(),
    val humidity: Float = 0.toFloat(),
    val pressure: Float = 0.toFloat(),
    val temp_min: Float = 0.toFloat(),
    val temp_max: Float = 0.toFloat()
)

data class SysResponse(
    val country: String? = null,
    val sunrise: Long = 0,
    val sunset: Long = 0
)

data class CoordResponse(
    val lon: Float = 0.toFloat(),
    val lat: Float = 0.toFloat()
)