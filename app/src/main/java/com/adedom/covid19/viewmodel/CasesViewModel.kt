package com.adedom.covid19.viewmodel

import com.adedom.covid19.data.models.Cases
import com.adedom.covid19.data.repositories.Covid19Repository
import kotlinx.coroutines.launch

data class CasesViewState(
    val cases: Cases = Cases(),
    val loading: Boolean = false
)

class CasesViewModel(
    private val repository: Covid19Repository
) : BaseViewModel<CasesViewState>(CasesViewState()) {

    fun fetchCases() {
        launch {
            try {
                setState { copy(loading = true) }
                val response = repository.fetchCases()
                setState { copy(loading = false, cases = response) }
            } catch (e: Throwable) {
                setState { copy(loading = false) }
                setError(e)
            }
        }
    }

}
