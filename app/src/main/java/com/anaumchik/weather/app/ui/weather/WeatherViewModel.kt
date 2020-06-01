package com.anaumchik.weather.app.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anaumchik.weather.app.models.Weather
import com.anaumchik.weather.app.ui.weather.interactor.WeatherInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(private val interactor: WeatherInteractor) : ViewModel() {

    private val _weatherLiveData = MutableLiveData<Weather>()
    val weatherLiveData: LiveData<Weather> = _weatherLiveData

    fun onUpdateWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            val weather = interactor.getWeather(CITY_MOSCOW)
            _weatherLiveData.postValue(weather)
        }
    }

    companion object {
        private const val CITY_MOSCOW = "Moscow,RU"
    }
}
