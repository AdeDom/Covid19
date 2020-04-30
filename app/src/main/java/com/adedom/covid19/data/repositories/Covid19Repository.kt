package com.adedom.covid19.data.repositories

import com.adedom.covid19.data.db.AppDatabase
import com.adedom.covid19.data.db.entities.Gender
import com.adedom.covid19.data.db.entities.Nation
import com.adedom.covid19.data.db.entities.Province
import com.adedom.covid19.data.db.entities.Today
import com.adedom.covid19.data.networks.Covid19Api
import com.adedom.covid19.data.networks.SafeApiRequest
import com.adedom.covid19.data.db.entities.Sum
import com.adedom.covid19.data.db.entities.Timeline

class Covid19Repository(
    private val api: Covid19Api,
    private val db: AppDatabase
) : SafeApiRequest() {

    //Today
    suspend fun fetchToday() = apiRequest { api.fetchToday() }

    suspend fun saveToday(today: Today) = db.getTodayDao().saveToday(today)

    fun getToday() = db.getTodayDao().getToday()

    //Timeline
    suspend fun fetchTimeline() = apiRequest { api.fetchTimeline() }

    suspend fun saveTimeline(timeline: Timeline) =
        db.getTimelineDao().saveTimeline(timeline)

    fun getTimeline() = db.getTimelineDao().getTimeline()

    //Cases
    suspend fun fetchCases() = apiRequest { api.fetchCases() }

    //Sum
    suspend fun fetchSum() = apiRequest { api.fetchSum() }

    suspend fun saveGender(gender: Gender) = db.getSumDao().saveGender(gender)

    suspend fun saveNation(nation: Nation) = db.getSumDao().saveNation(nation)

    suspend fun saveProvince(province: Province) = db.getSumDao().saveProvince(province)

    suspend fun saveSum(sum: Sum) = db.getSumDao().saveSum(sum)

    fun getGender() = db.getSumDao().getGender()

    fun getNation() = db.getSumDao().getNation()

    fun getProvince() = db.getSumDao().getProvince()

    fun getSum() = db.getSumDao().getSum()

}
