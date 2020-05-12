package com.adedom.covid19

import com.adedom.covid19.data.db.AppDatabase
import com.adedom.covid19.data.networks.Covid19Api
import com.adedom.covid19.data.networks.NetworkConnectionInterceptor
import com.adedom.covid19.data.repositories.Covid19Repository
import com.adedom.covid19.ui.cases.CasesViewModel
import com.adedom.covid19.ui.sum.SumViewModel
import com.adedom.covid19.ui.timeline.TimelineViewModel
import com.adedom.covid19.ui.today.TodayViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { NetworkConnectionInterceptor(get()) }
    single { Covid19Api.invoke(get()) }
    single { AppDatabase.invoke(get()) }
    single { Covid19Repository(get(), get()) }
    viewModel { TodayViewModel(get()) }
    viewModel { TimelineViewModel(get()) }
    viewModel { CasesViewModel(get()) }
    viewModel { SumViewModel(get()) }
}