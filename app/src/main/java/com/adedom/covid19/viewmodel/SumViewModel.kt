package com.adedom.covid19.viewmodel

import com.adedom.covid19.data.repositories.Covid19Repository
import kotlinx.coroutines.launch

data class SumViewState(
    val loading: Boolean = false
)

class SumViewModel(
    private val repository: Covid19Repository
) : BaseViewModel<SumViewState>(SumViewState()) {

    val sum = repository.getSum()
    val gender = repository.getGender()
    val nation = repository.getNation()
    val province = repository.getProvince()

    fun fetchSum() {
        launch {
            try {
                setState { copy(loading = true) }
                val response = repository.fetchSum()
                response.gender?.let { repository.saveGender(it) }
                response.nation?.let { repository.saveNation(it) }
                response.province?.let { repository.saveProvince(it) }
                response.let { repository.saveSum(it) }
                setState { copy(loading = false) }
            } catch (e: Throwable) {
                setState { copy(loading = false) }
                setError(e)
            }
        }
    }

}
