package com.adedom.covid19.viewmodel

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adedom.covid19.data.models.Cases
import com.adedom.covid19.data.models.CasesData
import com.adedom.covid19.data.repositories.Covid19Repository
import com.adedom.covid19.util.TestDispatcher
import com.adedom.covid19.util.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.InternalCoroutinesApi
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.KoinContextHandler
import org.robolectric.annotation.Config

@InternalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class CasesViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val repository = mockk<Covid19Repository>(relaxed = true)
    private lateinit var viewModel: CasesViewModel

    init {
        ApplicationDispatcher = TestDispatcher
    }

    @Before
    fun setup() {
        viewModel = CasesViewModel(repository)
    }

    @After
    fun cleanup() {
        KoinContextHandler.stop()
    }

    @Test
    fun fetchCases_completed() {
        val cases = Cases(
            lastData = "2020-08-09 00:00:00",
            updateDate = "09/08/2020",
            source = "https://data.go.th/dataset/covid-19-daily",
            devBy = "https://www.kidkarnmai.com/",
            severBy = "https://smilehost.asia/",
            data = listOf(
                CasesData(
                    confirmDate = "2020-01-17 00:00:00",
                    no = "2",
                    age = 74.toFloat(),
                    gender = "หญิง",
                    genderEn = "Female",
                    nation = "China",
                    province = "กรุงเทพมหานคร",
                    provinceId = 1,
                    district = "",
                    provinceEn = "Bangkok"
                ),
                CasesData(
                    confirmDate = "2020-01-12 00:00:00",
                    no = "1",
                    age = 61.toFloat(),
                    gender = "หญิง",
                    genderEn = "Female",
                    nation = "China",
                    province = "กรุงเทพมหานคร",
                    provinceId = 1,
                    district = "",
                    provinceEn = "Bangkok"
                )
            )
        )
        coEvery { repository.fetchCases() } returns cases

        viewModel.fetchCases()

        val state = viewModel.state.getOrAwaitValue()
        assertEquals(state.loading, false)
        assertEquals(state.cases, cases)
    }

    @Test
    fun fetchCases_error() {
        val throwable = Throwable("Api error")
        coEvery { repository.fetchCases() } throws throwable

        viewModel.fetchCases()

        val state = viewModel.state.getOrAwaitValue()
        val error = viewModel.error.getOrAwaitValue()
        assertEquals(state.loading, false)
        assertEquals(error, throwable)
    }

}
