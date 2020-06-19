package com.anaumchik.weather.app.ui.weather.interactor

import com.anaumchik.weather.app.models.Weather
import com.anaumchik.weather.app.network.mappers.toModel
import com.anaumchik.weather.app.ui.weather.repository.WeatherRepository
import com.anaumchik.weather.app.utils.DateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherInteractorImpl(
    private val repository: WeatherRepository,
    private val dateUtils: DateUtils
) : WeatherInteractor {

    override suspend fun getWeather(city: String): Weather = withContext(Dispatchers.IO) {
        repository.getWeather(city).toModel()
            .apply { date = dateUtils.getCurrentDate() }
    }
}
