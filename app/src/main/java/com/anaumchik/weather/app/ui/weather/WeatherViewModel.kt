package com.anaumchik.weather.app.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anaumchik.weather.app.models.Weather
import com.anaumchik.weather.app.ui.weather.interactor.WeatherInteractor
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val interactor: WeatherInteractor
) : ViewModel() {

    private val _weatherLiveData = MutableLiveData<Weather>()
    val weatherLiveData: LiveData<Weather> = _weatherLiveData
    private val _weatherErrorLiveData = MutableLiveData<Exception>()
    val weatherErrorLiveData: LiveData<Exception> = _weatherErrorLiveData

    fun onUpdateWeather() {
        viewModelScope.launch {
            try {
                val weather = interactor.getWeather(CITY_MOSCOW)
                _weatherLiveData.postValue(weather)
            } catch (error: Exception) {
                _weatherErrorLiveData.postValue(error)
            }
        }
    }

    companion object {
        private const val CITY_MOSCOW = "Moscow,RU"
    }
}
