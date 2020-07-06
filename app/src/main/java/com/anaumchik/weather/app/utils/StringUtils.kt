package com.anaumchik.weather.app.utils

import android.content.Context
import com.anaumchik.weather.R

class StringUtils(private val context: Context) {

    fun getCurrentDate(currentDate: String): String {
        return context.getString(R.string.date_utils_updated_at, currentDate)
    }
}
