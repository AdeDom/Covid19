package com.adedom.covid19.ui.cases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adedom.covid19.data.models.Cases
import com.adedom.covid19.data.repositories.Covid19Repository
import com.adedom.covid19.util.base.BaseViewModel

class CasesViewModel(private val repository: Covid19Repository) : BaseViewModel() {

    private val _cases = MutableLiveData<Cases>()
    val cases: LiveData<Cases>
        get() = _cases

    fun fetchCases() = ioThenMain(
        { repository.fetchCases() },
        { _cases.value = it }
    )

}
