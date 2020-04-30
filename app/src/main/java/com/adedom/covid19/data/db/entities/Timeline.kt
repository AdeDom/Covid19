package com.adedom.covid19.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adedom.covid19.data.models.TimelineData
import com.google.gson.annotations.SerializedName

@Entity(tableName = "timeline")
data class Timeline(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "timeline_id") var timelineId: Int = 0,
    @SerializedName("UpdateDate") @ColumnInfo(name = "update_date") val updateDate: String? = null,
    @SerializedName("Source") @ColumnInfo(name = "source") val source: String? = null,
    @SerializedName("DevBy") @ColumnInfo(name = "dev_by") val devBy: String? = null,
    @SerializedName("SeverBy") @ColumnInfo(name = "sever_by") val severBy: String? = null,
    @SerializedName("Data") @ColumnInfo(name = "timeline_data") val `data`: List<TimelineData>? = null
)
