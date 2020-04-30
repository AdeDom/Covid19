package com.adedom.covid19.data.models

import com.google.gson.annotations.SerializedName

data class CasesData(
    @SerializedName("ConfirmDate") val confirmDate: String? = null,
    @SerializedName("No") val no: String? = null,
    @SerializedName("Age") val age: Float? = null,
    @SerializedName("Gender") val gender: String? = null,
    @SerializedName("GenderEn") val genderEn: String? = null,
    @SerializedName("Nation") val nation: String? = null,
    @SerializedName("NationEn") val nationEn: String? = null,
    @SerializedName("Province") val province: String? = null,
    @SerializedName("ProvinceId") val provinceId: Int? = null,
    @SerializedName("District") val district: String? = null,
    @SerializedName("ProvinceEn") val provinceEn: String? = null,
    @SerializedName("Detail") val detail: Any? = null
)
