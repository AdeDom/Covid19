package com.adedom.covid19.util.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adedom.covid19.data.repositories.Covid19Repository
import com.adedom.covid19.ui.cases.CasesViewModel
import com.adedom.covid19.ui.sum.SumViewModel
import com.adedom.covid19.ui.timeline.TimelineViewModel
import com.adedom.covid19.ui.today.TodayViewModel

@Suppress("UNCHECKED_CAST")
class BaseViewModelFactory(
    private val repository: Covid19Repository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TodayViewModel::class.java) -> TodayViewModel(repository) as T
            modelClass.isAssignableFrom(TimelineViewModel::class.java) -> TimelineViewModel(repository) as T
            modelClass.isAssignableFrom(CasesViewModel::class.java) -> CasesViewModel(repository) as T
            modelClass.isAssignableFrom(SumViewModel::class.java) -> SumViewModel(repository) as T
            else -> throw IllegalArgumentException("ViewModel class not found...")
        }
    }
}
