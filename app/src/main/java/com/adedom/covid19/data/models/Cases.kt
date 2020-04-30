package com.adedom.covid19.data.models

import com.google.gson.annotations.SerializedName

data class Cases(
    @SerializedName("Data") val `data`: List<CasesData>? = null,
    @SerializedName("LastData") val lastData: String? = null,
    @SerializedName("UpdateDate") val updateDate: String? = null,
    @SerializedName("Source") val source: String? = null,
    @SerializedName("DevBy") val devBy: String? = null,
    @SerializedName("SeverBy") val severBy: String? = null
)
