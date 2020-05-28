package com.anaumchik.weather.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anaumchik.weather.network.models.WeatherResponse
import com.anaumchik.weather.repository.WeatherRepositoryImpl
import kotlinx.coroutines.Dispatchers

class WeatherViewModel(private val repository: WeatherRepositoryImpl) : ViewModel() {

    val weatherLiveData: LiveData<WeatherResponse> = liveData(Dispatchers.IO) {
        val weatherLiveData = repository.getWeather(CITY_MOSCOW)
        emit(weatherLiveData)
    }

    companion object {
        private const val CITY_MOSCOW = "Moscow,RU"
    }
}
