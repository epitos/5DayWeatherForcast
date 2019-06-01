package exercise.coding.weatherforcast.presenter

import exercise.coding.weatherforcast.api.ApiServiceInterface
import exercise.coding.weatherforcast.model.Response
import exercise.coding.weatherforcast.ui.view.WeatherForecastView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WeatherForecastPresenter(private val view: WeatherForecastView) : Presenter {

    private var compositeDisposable = CompositeDisposable()

    override fun getWeatherForecast() {
        compositeDisposable.add(
            ApiServiceInterface.create().getWeatherForecast()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse))
    }

    private fun handleResponse(response: Response) {
        view.hideProgressbar()
        view.displayWeatherForecast(response)
    }
}