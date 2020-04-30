package com.adedom.covid19.ui.today

import com.adedom.covid19.data.repositories.Covid19Repository
import com.adedom.covid19.util.base.BaseViewModel

class TodayViewModel(private val repository: Covid19Repository) : BaseViewModel() {

    val today = repository.getToday()

    fun fetchToday() = ioThenMain(
        { repository.fetchToday() },
        { response -> response?.let { repository.saveToday(it) } }
    )

}
