package com.adedom.covid19.data.repositories

import com.adedom.covid19.data.db.AppDatabase
import com.adedom.covid19.data.db.entities.Today
import com.adedom.covid19.data.networks.Covid19Api
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class Covid19RepositoryImplTest {

    private val api = mockk<Covid19Api>(relaxed = true)
    private val db = mockk<AppDatabase>(relaxed = true)
    val repository = Covid19RepositoryImpl(api, db)

    @Test
    fun fetchToday() {
        val today = Today(
            confirmed = 3330,
            recovered = 3148,
            hospitalized = 124,
            deaths = 58,
            newConfirmed = 2,
            newRecovered = 4,
            newHospitalized = -2,
            newDeaths = 0,
            updateDate = "06/08/2020 13:08",
            source = "https://covid19.th-stat.com/",
            devBy = "https://www.kidkarnmai.com/",
            severBy = "https://smilehost.asia/"
        )
        coEvery { api.fetchToday() } returns today

        val actual = runBlocking { repository.fetchToday() }

        assertEquals(today, actual)
    }

}
