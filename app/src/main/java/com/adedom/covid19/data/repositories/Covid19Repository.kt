package com.adedom.covid19.data.repositories

import androidx.lifecycle.LiveData
import com.adedom.covid19.data.db.entities.*
import com.adedom.covid19.data.models.Cases

interface Covid19Repository {

    //Today
    suspend fun fetchToday(): Today

    suspend fun saveToday(today: Today)

    fun getToday(): LiveData<Today>

    //Timeline
    suspend fun fetchTimeline(): Timeline

    suspend fun saveTimeline(timeline: Timeline)

    fun getTimeline(): LiveData<Timeline>

    //Cases
    suspend fun fetchCases(): Cases

    //Sum
    suspend fun fetchSum(): Sum

    suspend fun saveGender(gender: Gender)

    suspend fun saveNation(nation: Nation)

    suspend fun saveProvince(province: Province)

    suspend fun saveSum(sum: Sum): Long

    fun getGender(): LiveData<Gender>

    fun getNation(): LiveData<Nation>

    fun getProvince(): LiveData<Province>

    fun getSum(): LiveData<Sum>

}
