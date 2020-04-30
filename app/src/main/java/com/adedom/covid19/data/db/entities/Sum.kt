package com.adedom.covid19.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "sum")
data class Sum(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "sum_id") var sumId: Int = 0,
    @SerializedName("Province") @Ignore var province: Province? = null,
    @SerializedName("Nation") @Ignore var nation: Nation? = null,
    @SerializedName("Gender") @Ignore var gender: Gender? = null,
    @SerializedName("LastData") @ColumnInfo(name = "last_data") var lastData: String? = null,
    @SerializedName("UpdateDate") @ColumnInfo(name = "update_date") var updateDate: String? = null,
    @SerializedName("Source") @ColumnInfo(name = "source") var source: String? = null,
    @SerializedName("DevBy") @ColumnInfo(name = "dev_by") var devBy: String? = null,
    @SerializedName("SeverBy") @ColumnInfo(name = "sever_by") var severBy: String? = null
)
