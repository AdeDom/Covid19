package com.adedom.covid19.ui.today

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adedom.covid19.data.repositories.Covid19Repository

@Suppress("UNCHECKED_CAST")
class TodayFactory(
    private val repository: Covid19Repository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodayViewModel(repository) as T
    }
}
