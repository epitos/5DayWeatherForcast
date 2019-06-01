package exercise.coding.weatherforcast.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import exercise.coding.weatherforcast.R
import exercise.coding.weatherforcast.model.List
import kotlinx.android.synthetic.main.row_layout.view.*

class WeatherForecastAdapter(private val list: ArrayList<List>) : RecyclerView.Adapter<WeatherForecastAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.count()

    override fun onBindViewHolder(viewholder: ViewHolder, postion: Int) {
        viewholder.bind(list[postion])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var dateTextView = view.date
        private var descTextView = view.desc
        private var tempTextView = view.temp
        private var humidityTextView = view.humidity


        fun bind(list: List) {
            tempTextView.text = list.main.temp.toString() + "%"
            humidityTextView.text = list.main.humidity.toString() + "%"
            dateTextView.text = list.dt_txt
            descTextView.text = list.weather[0].description
        }
    }
}