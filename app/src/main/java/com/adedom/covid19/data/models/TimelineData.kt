package com.adedom.covid19.data.models

import com.google.gson.annotations.SerializedName

data class TimelineData(
    @SerializedName("Date") val date: String? = null,
    @SerializedName("NewConfirmed") val newConfirmed: Int? = null,
    @SerializedName("NewRecovered") val newRecovered: Int? = null,
    @SerializedName("NewHospitalized") val newHospitalized: Int? = null,
    @SerializedName("NewDeaths") val newDeaths: Int? = null,
    @SerializedName("Confirmed") val confirmed: Int? = null,
    @SerializedName("Recovered") val recovered: Int? = null,
    @SerializedName("Hospitalized") val hospitalized: Int? = null,
    @SerializedName("Deaths") val deaths: Int? = null
)
