package com.adedom.covid19.ui.timeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adedom.covid19.data.repositories.Covid19Repository

@Suppress("UNCHECKED_CAST")
class TimelineFactory(
    private val repository: Covid19Repository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TimelineViewModel(repository) as T
    }
}
