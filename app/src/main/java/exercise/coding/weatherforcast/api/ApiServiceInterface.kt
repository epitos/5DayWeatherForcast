package exercise.coding.weatherforcast.api

import example.coding.repositories.util.Constants
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServiceInterface {

    @GET(Constants.GET_5_DAY_WEATHER_FORECAST)
    fun getWeatherForecast(): Observable<exercise.coding.weatherforcast.model.Response>

    companion object {
        fun create(): ApiServiceInterface {
            val requestInterface = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return requestInterface.create(ApiServiceInterface::class.java)
        }
    }
}