package com.anaumchik.weather.app.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils(private val stringUtils: StringUtils) {

    fun getCurrentDate(): String {
        val currentTimeInMillis = getCurrentTimeInMillis()
        val formattedDate = formatDate(currentTimeInMillis)
        return stringUtils.getCurrentDate(formattedDate)
    }

    private fun getCurrentTimeInMillis(): Date = Calendar.getInstance().time

    private fun formatDate(currentTimeInMillis: Date): String {
        val sdf = SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.getDefault())
        return sdf.format(currentTimeInMillis)
    }

    companion object {
        private const val DATE_FORMAT_PATTERN = "dd/MM/yyyy HH:mm"
    }
}