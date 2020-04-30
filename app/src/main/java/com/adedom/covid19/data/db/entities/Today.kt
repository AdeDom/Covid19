package com.adedom.covid19.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "today")
data class Today(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "today_id") var todayId: Int = 0,
    @SerializedName("UpdateDate") @ColumnInfo(name = "update_date") val updateDate: String? = null,
    @SerializedName("Confirmed") @ColumnInfo(name = "confirmed") val confirmed: Int? = null,
    @SerializedName("Recovered") @ColumnInfo(name = "recovered") val recovered: Int? = null,
    @SerializedName("Hospitalized") @ColumnInfo(name = "hospitalized") val hospitalized: Int? = null,
    @SerializedName("Deaths") @ColumnInfo(name = "deaths") val deaths: Int? = null,
    @SerializedName("NewConfirmed") @ColumnInfo(name = "new_confirmed") val newConfirmed: Int? = null,
    @SerializedName("NewRecovered") @ColumnInfo(name = "new_recovered") val newRecovered: Int? = null,
    @SerializedName("NewHospitalized") @ColumnInfo(name = "new_hospitalized") val newHospitalized: Int? = null,
    @SerializedName("NewDeaths") @ColumnInfo(name = "new_deaths") val newDeaths: Int? = null,
    @SerializedName("Source") @ColumnInfo(name = "source") val source: String? = null,
    @SerializedName("DevBy") @ColumnInfo(name = "dev_by") val devBy: String? = null,
    @SerializedName("SeverBy") @ColumnInfo(name = "sever_by") val severBy: String? = null
)
