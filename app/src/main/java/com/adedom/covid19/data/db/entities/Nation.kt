package com.adedom.covid19.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "nation")
data class Nation(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "nation_id") var nationId: Int = 0,
    @SerializedName("Albanian") @ColumnInfo(name = "albanian") val albanian: Int? = null,
    @SerializedName("American") @ColumnInfo(name = "american") val american: Int? = null,
    @SerializedName("Australian") @ColumnInfo(name = "australian") val australian: Int? = null,
    @SerializedName("Belgian") @ColumnInfo(name = "belgian") val belgian: Int? = null,
    @SerializedName("British") @ColumnInfo(name = "british") val british: Int? = null,
    @SerializedName("Burmese") @ColumnInfo(name = "burmese") val burmese: Int? = null,
    @SerializedName("Cambodian") @ColumnInfo(name = "cambodian") val cambodian: Int? = null,
    @SerializedName("Canadian") @ColumnInfo(name = "canadian") val canadian: Int? = null,
    @SerializedName("Chinese") @ColumnInfo(name = "chinese") val chinese: Int? = null,
    @SerializedName("Danish") @ColumnInfo(name = "danish") val danish: Int? = null,
    @SerializedName("Dutch") @ColumnInfo(name = "dutch") val dutch: Int? = null,
    @SerializedName("English") @ColumnInfo(name = "english") val english: Int? = null,
    @SerializedName("Filipino") @ColumnInfo(name = "filipino") val filipino: Int? = null,
    @SerializedName("Finnish") @ColumnInfo(name = "finnish") val finnish: Int? = null,
    @SerializedName("French") @ColumnInfo(name = "french") val french: Int? = null,
    @SerializedName("German") @ColumnInfo(name = "german") val german: Int? = null,
    @SerializedName("Hungarian") @ColumnInfo(name = "hungarian") val hungarian: Int? = null,
    @SerializedName("Indian") @ColumnInfo(name = "indian") val indian: Int? = null,
    @SerializedName("Indian-Thai") @ColumnInfo(name = "indian_thai") val indianThai: Int? = null,
    @SerializedName("Indonesian") @ColumnInfo(name = "indonesian") val indonesian: Int? = null,
    @SerializedName("Iranian") @ColumnInfo(name = "iranian") val iranian: Int? = null,
    @SerializedName("Italian") @ColumnInfo(name = "italian") val italian: Int? = null,
    @SerializedName("Japanese") @ColumnInfo(name = "japanese") val japanese: Int? = null,
    @SerializedName("Korean") @ColumnInfo(name = "korean") val korean: Int? = null,
    @SerializedName("Laotian") @ColumnInfo(name = "laotian") val laotian: Int? = null,
    @SerializedName("Liberian") @ColumnInfo(name = "liberian") val liberian: Int? = null,
    @SerializedName("Malaysian") @ColumnInfo(name = "malaysian") val malaysian: Int? = null,
    @SerializedName("Mexican") @ColumnInfo(name = "mexican") val mexican: Int? = null,
    @SerializedName("New Zealand") @ColumnInfo(name = "new_zealand") val newZealand: Int? = null,
    @SerializedName("Pakistani") @ColumnInfo(name = "pakistani") val pakistani: Int? = null,
    @SerializedName("Portuguese") @ColumnInfo(name = "portuguese") val portuguese: Int? = null,
    @SerializedName("Russian") @ColumnInfo(name = "russian") val russian: Int? = null,
    @SerializedName("Serbian") @ColumnInfo(name = "serbian") val serbian: Int? = null,
    @SerializedName("Singaporean") @ColumnInfo(name = "singaporean") val singaporean: Int? = null,
    @SerializedName("Spain") @ColumnInfo(name = "spain") val spain: Int? = null,
    @SerializedName("Swedish") @ColumnInfo(name = "swedish") val swedish: Int? = null,
    @SerializedName("Swiss") @ColumnInfo(name = "swiss") val swiss: Int? = null,
    @SerializedName("Taiwanese") @ColumnInfo(name = "taiwanese") val taiwanese: Int? = null,
    @SerializedName("Thai") @ColumnInfo(name = "thai") val thai: Int? = null,
    @SerializedName("Tunisian") @ColumnInfo(name = "tunisian") val tunisian: Int? = null,
    @SerializedName("Ukrainian") @ColumnInfo(name = "ukrainian") val ukrainian: Int? = null,
    @SerializedName("Unknown") @ColumnInfo(name = "unknown") val unknown: Int? = null,
    @SerializedName("Uzbeks") @ColumnInfo(name = "uzbeks") val uzbeks: Int? = null,
    @SerializedName("Vietnamese") @ColumnInfo(name = "vietnamese") val vietnamese: Int? = null
)
