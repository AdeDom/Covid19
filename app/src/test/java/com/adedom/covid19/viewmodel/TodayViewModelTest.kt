package com.adedom.covid19.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.adedom.covid19.TestDispatcher
import com.adedom.covid19.data.db.entities.Today
import com.adedom.covid19.data.repositories.Covid19Repository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.InternalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@InternalCoroutinesApi
class TodayViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val repository = mockk<Covid19Repository>(relaxed = true)
    private lateinit var viewModel: TodayViewModel

    init {
        ApplicationDispatcher = TestDispatcher
    }

    @Before
    fun setup() {
        viewModel = TodayViewModel(repository)
    }

    @Test
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
        coEvery { repository.saveToday(today) } returns Unit

        viewModel.fetchToday()

        val state = viewModel.state.value
        val error = viewModel.error.value
        assertEquals(state?.loading, false)
        assertEquals(error, null)
    }

    @Test
    fun fetchToday_error() {
        val throwable = Throwable("Api error")
        coEvery { repository.fetchToday() } throws throwable

        viewModel.fetchToday()

        val state = viewModel.state.value
        val error = viewModel.error.value
        assertEquals(state?.loading, false)
        assertEquals(error, throwable)
    }

}
