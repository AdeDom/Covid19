package com.adedom.covid19.ui.sum

import com.adedom.covid19.data.repositories.Covid19Repository
import com.adedom.covid19.util.base.BaseViewModel

class SumViewModel(private val repository: Covid19Repository) : BaseViewModel() {

    val sum = repository.getSum()
    val gender = repository.getGender()
    val nation = repository.getNation()
    val province = repository.getProvince()

    fun fetchSum() = ioThenMain(
        { repository.fetchSum() },
        { response ->
            response?.gender?.let { repository.saveGender(it) }
            response?.nation?.let { repository.saveNation(it) }
            response?.province?.let { repository.saveProvince(it) }
            response?.let { repository.saveSum(it) }
        }
    )

}
