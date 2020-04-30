package com.adedom.covid19.data.db

import androidx.room.TypeConverter
import com.adedom.covid19.data.models.TimelineData
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<TimelineData>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<TimelineData>::class.java).toList()

}
