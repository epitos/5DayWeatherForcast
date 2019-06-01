package exercise.coding.weatherforcast.ui.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import exercise.coding.weatherforcast.R
import exercise.coding.weatherforcast.model.Response
import exercise.coding.weatherforcast.presenter.WeatherForecastPresenter
import exercise.coding.weatherforcast.ui.adapter.WeatherForecastAdapter
import kotlinx.android.synthetic.main.activity_main.*

class WeatherForecastActivity : AppCompatActivity(), WeatherForecastView {

    private lateinit var presenter: WeatherForecastPresenter
    private var weatherForecastAdapter: WeatherForecastAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = WeatherForecastPresenter(this)
        presenter.getWeatherForecast()
    }

    override fun displayWeatherForecast(response: Response) {
        city.text = response.city.name
        initRecyclerView()
        weatherForecastAdapter = WeatherForecastAdapter(response.list)
        forecast_list.adapter = weatherForecastAdapter
    }

    override fun hideProgressbar() {
        progressbar.visibility = View.GONE
        loading_message.visibility = View.GONE
    }

    private fun initRecyclerView() {
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        forecast_list.layoutManager = layoutManager
    }
}
