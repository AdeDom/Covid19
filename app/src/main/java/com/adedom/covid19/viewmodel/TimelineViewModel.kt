package com.adedom.covid19.viewmodel

import com.adedom.covid19.data.repositories.Covid19Repository
import kotlinx.coroutines.launch

data class TimelineViewState(
    val loading: Boolean = false
)

class TimelineViewModel(
    private val repository: Covid19Repository
) : BaseViewModel<TimelineViewState>(
    TimelineViewState()
) {

    val timeline = repository.getTimeline()

    fun fetchTimeline() {
        launch {
            try {
                setState { copy(loading = true) }
                val response = repository.fetchTimeline()
                response.let { repository.saveTimeline(it) }
                setState { copy(loading = false) }
            } catch (e: Throwable) {
                setState { copy(loading = false) }
                setError(e)
            }
        }
    }

}
