package com.anaumchik.weather.app.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.anaumchik.weather.R
import kotlinx.android.synthetic.main.fragment_main.*

import org.koin.android.viewmodel.ext.android.viewModel

class WeatherFragment : Fragment() {

    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.weatherLiveData.observe(viewLifecycleOwner, Observer { data ->
            tempTv.text = data?.main?.temp.toString()
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.onUpdateWeather()
    }
}
