package exercise.coding.weatherforcast.model

import com.google.gson.annotations.SerializedName

data class Response (
	@SerializedName("cod") val cod : Int,
	@SerializedName("message") val message : Double,
	@SerializedName("cnt") val cnt : Int,
	@SerializedName("list") val list : ArrayList<List>,
	@SerializedName("city") val city : City
)