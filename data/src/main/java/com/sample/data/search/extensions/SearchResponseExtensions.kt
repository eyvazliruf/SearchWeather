package com.sample.data.search.extensions

import com.sample.data.BuildConfig
import com.sample.data.search.remotedatasource.model.SearchResponse
import com.sample.domain.search.model.SearchData
import kotlin.math.roundToInt

/**
 * Converts search response to domain model: SearchData
 * */
fun SearchResponse.toDomainModel(): SearchData = SearchData(
    city = name,
    temperature = main.temp.toFahrenheit(),
    lowTemp = main.tempMin.toFahrenheit(),
    highTemp = main.tempMax.toFahrenheit(),
    feelsLike = main.feelsLike.toFahrenheit(),
    humidity = main.humidity,
    description = if (weather.isNotEmpty()) weather[0].description else "",
    icon = if (weather.isNotEmpty()) "${BuildConfig.ICON_URL}${weather[0].icon}@2x.png" else ""
)

fun Double.toFahrenheit() = ((this - 273.15) * 1.8 + 32).roundToInt()