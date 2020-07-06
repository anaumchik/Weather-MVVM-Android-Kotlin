package com.anaumchik.weather.app.ui.weather

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.anaumchik.weather.R
import kotlinx.android.synthetic.main.fragment_main.cityTv
import kotlinx.android.synthetic.main.fragment_main.dateTv
import kotlinx.android.synthetic.main.fragment_main.humidityTv
import kotlinx.android.synthetic.main.fragment_main.maxTempValueTv
import kotlinx.android.synthetic.main.fragment_main.minTempValueTv
import kotlinx.android.synthetic.main.fragment_main.pressureTv
import kotlinx.android.synthetic.main.fragment_main.refreshImg
import kotlinx.android.synthetic.main.fragment_main.tempTv
import kotlinx.android.synthetic.main.fragment_main.windTv
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherFragment : Fragment() {

    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshImg.setOnClickListener { viewModel.onUpdateWeather() }

        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onUpdateWeather()
    }

    private fun observeViewModel() {
        // SUCCESS
        viewModel.weatherLiveData.observe(
            viewLifecycleOwner,
            Observer { weather ->
                Log.d("WeatherFragment", "received from server: $weather")

                cityTv.text = weather?.name
                dateTv.text = weather?.date

                val temp = weather?.main?.temp?.toInt() ?: 0
                tempTv.text = getString(R.string.weather_temp, temp)

                val windSpeed = weather?.wind?.speed?.toInt() ?: 0
                windTv.text = getString(R.string.weather_wind_speed, windSpeed)
                val humidity = weather?.main?.humidity?.toInt() ?: 0
                val humidityText = "$humidity%"
                humidityTv.text = humidityText
                pressureTv.text = weather?.main?.pressure?.toInt().toString()

                val tempMin = weather?.main?.temp_min?.toInt() ?: 0
                minTempValueTv.text = getString(R.string.weather_temp, tempMin)
                val tempMax = weather?.main?.temp_max?.toInt() ?: 0
                maxTempValueTv.text = getString(R.string.weather_temp, tempMax)
            }
        )
        // ERROR
        viewModel.weatherErrorLiveData.observe(
            viewLifecycleOwner,
            Observer { error ->
                Toast.makeText(context, error.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        )
    }
}
