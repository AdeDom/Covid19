package com.adedom.covid19.viewmodel

import com.adedom.covid19.data.repositories.Covid19Repository
import kotlinx.coroutines.launch

data class TodayViewState(
    val loading: Boolean = false
)

class TodayViewModel(
    private val repository: Covid19Repository
) : BaseViewModel<TodayViewState>(TodayViewState()) {

    val today = repository.getToday()

    fun fetchToday() {
        launch {
            try {
                setState { copy(loading = true) }
                val response = repository.fetchToday()
                response.let { repository.saveToday(it) }
                setState { copy(loading = false) }
            } catch (e: Throwable) {
                setState { copy(loading = false) }
                setError(e)
            }
        }
    }

}
