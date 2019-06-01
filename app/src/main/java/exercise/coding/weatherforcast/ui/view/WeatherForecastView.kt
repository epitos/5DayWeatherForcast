package exercise.coding.weatherforcast.ui.view

import exercise.coding.weatherforcast.model.Response

interface WeatherForecastView {
    fun displayWeatherForecast(response: Response)
    fun hideProgressbar()
}