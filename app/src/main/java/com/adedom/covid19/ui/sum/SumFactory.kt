package com.adedom.covid19.ui.sum

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adedom.covid19.data.repositories.Covid19Repository

@Suppress("UNCHECKED_CAST")
class SumFactory(
    private val repository: Covid19Repository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SumViewModel(repository) as T
    }
}
