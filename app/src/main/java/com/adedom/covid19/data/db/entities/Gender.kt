package com.adedom.covid19.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "gender")
data class Gender(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "gender_id") var genderId: Int = 0,
    @SerializedName("Male") @ColumnInfo(name = "male") val male: Int? = null,
    @SerializedName("Female") @ColumnInfo(name = "female") val female: Int? = null
)
