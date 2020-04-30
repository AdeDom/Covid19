package com.adedom.covid19.ui.timeline

import com.adedom.covid19.data.repositories.Covid19Repository
import com.adedom.covid19.util.base.BaseViewModel

class TimelineViewModel(private val repository: Covid19Repository) : BaseViewModel() {

    val timeline = repository.getTimeline()

    fun fetchTimeline() = ioThenMain(
        { repository.fetchTimeline() },
        { response -> response?.let { repository.saveTimeline(it) } }
    )

}
