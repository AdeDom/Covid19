package com.adedom.covid19.viewmodel

import android.content.Context
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adedom.covid19.data.db.AppDatabase
import com.adedom.covid19.data.db.TodayDao
import com.adedom.covid19.data.db.entities.Today
import com.adedom.covid19.data.repositories.Covid19Repository
import com.adedom.covid19.util.TestDispatcher
import com.adedom.covid19.util.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.KoinContextHandler
import org.robolectric.annotation.Config
import java.io.IOException

@InternalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class TodayViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: TodayDao
    private lateinit var db: AppDatabase
    private val repository = mockk<Covid19Repository>(relaxed = true)
    private lateinit var viewModel: TodayViewModel

    init {
        ApplicationDispatcher = TestDispatcher
    }

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).apply {
            allowMainThreadQueries()
        }.build()
        dao = db.getTodayDao()

        viewModel = TodayViewModel(repository)
    }

    @After
    @Throws(IOException::class)
    fun cleanup() {
        db.close()
        KoinContextHandler.stop()
    }

    @Test
    @Throws(Exception::class)
    fun fetchToday_success() {
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
        coEvery { repository.fetchToday() } returns today

        viewModel.fetchToday()
        runBlocking { dao.saveToday(today) }

        val state = viewModel.state.getOrAwaitValue()
        val getTodayDb = dao.getToday().getOrAwaitValue()
        assertEquals(state.loading, false)
        assertEquals(today, getTodayDb)
    }

    @Test
    @Throws(Exception::class)
    fun writeTodayAndReadData() {
        runBlocking {
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
            dao.saveToday(today)

            val data = dao.getToday().getOrAwaitValue()
            assertEquals(data, today)
        }
    }

    @Test
    fun fetchToday_error() {
        val throwable = Throwable("Api error")
        coEvery { repository.fetchToday() } throws throwable

        viewModel.fetchToday()

        val state = viewModel.state.getOrAwaitValue()
        val error = viewModel.error.getOrAwaitValue()
        assertEquals(state.loading, false)
        assertEquals(error, throwable)
    }

}
