package com.anaumchik.weather.app.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anaumchik.weather.app.network.models.WeatherResponse
import com.anaumchik.weather.app.repository.WeatherRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepositoryImpl) : ViewModel() {

    private val _weatherLiveData = MutableLiveData<WeatherResponse>()
    val weatherLiveData: LiveData<WeatherResponse> = _weatherLiveData

    fun onUpdateWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            val weather = repository.getWeather(CITY_MOSCOW)
            _weatherLiveData.postValue(weather)
        }
    }

    companion object {
        private const val CITY_MOSCOW = "Moscow,RU"
    }
}
