package com.anaumchik.weather.app.repository

import com.anaumchik.weather.app.network.WeatherApi
import com.anaumchik.weather.app.network.models.WeatherResponseModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherRepositoryTest {

    private val city = "city"
    private val weatherResponse: WeatherResponseModel = mockk()

    private val api: WeatherApi = mockk()
    private val repository = WeatherRepositoryImpl(api)

    @Test
    fun `should call getWeather() api when repository called`() = runBlocking {
        coEvery { api.getWeather(any()) } returns weatherResponse

        repository.getWeather(city)

        coVerify(exactly = 1) { api.getWeather(city) }
    }

    @Test
    fun `should return response when getWeather succeeds`() = runBlocking {
        coEvery { api.getWeather(any()) } returns weatherResponse

        val actual = repository.getWeather(city)
        val expected = weatherResponse

        assertEquals(expected, actual)
    }
}
