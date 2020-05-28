package com.anaumchik.weather.app.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anaumchik.weather.app.network.models.WeatherResponse
import com.anaumchik.weather.app.repository.WeatherRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepositoryImpl) : ViewModel() {

    val weatherLiveData = MutableLiveData<WeatherResponse>()

    fun onUpdateWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            val weather = repository.getWeather(CITY_MOSCOW)
            weatherLiveData.postValue(weather)
        }
    }

    companion object {
        private const val CITY_MOSCOW = "Moscow,RU"
    }
}
