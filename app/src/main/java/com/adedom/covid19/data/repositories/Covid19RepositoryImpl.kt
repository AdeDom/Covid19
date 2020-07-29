package com.adedom.covid19.data.repositories

import com.adedom.covid19.data.db.AppDatabase
import com.adedom.covid19.data.db.entities.*
import com.adedom.covid19.data.networks.Covid19Api

class Covid19RepositoryImpl(
    private val api: Covid19Api,
    private val db: AppDatabase
) : Covid19Repository {

    //Today
    override suspend fun fetchToday() = api.fetchToday()

    override suspend fun saveToday(today: Today) = db.getTodayDao().saveToday(today)

    override fun getToday() = db.getTodayDao().getToday()

    //Timeline
    override suspend fun fetchTimeline() = api.fetchTimeline()

    override suspend fun saveTimeline(timeline: Timeline) =
        db.getTimelineDao().saveTimeline(timeline)

    override fun getTimeline() = db.getTimelineDao().getTimeline()

    //Cases
    override suspend fun fetchCases() = api.fetchCases()

    //Sum
    override suspend fun fetchSum() = api.fetchSum()

    override suspend fun saveGender(gender: Gender) = db.getSumDao().saveGender(gender)

    override suspend fun saveNation(nation: Nation) = db.getSumDao().saveNation(nation)

    override suspend fun saveProvince(province: Province) = db.getSumDao().saveProvince(province)

    override suspend fun saveSum(sum: Sum) = db.getSumDao().saveSum(sum)

    override fun getGender() = db.getSumDao().getGender()

    override fun getNation() = db.getSumDao().getNation()

    override fun getProvince() = db.getSumDao().getProvince()

    override fun getSum() = db.getSumDao().getSum()

}
