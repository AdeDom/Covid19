package com.adedom.covid19.di

import com.adedom.covid19.data.repositories.Covid19Repository
import com.adedom.covid19.data.repositories.Covid19RepositoryImpl
import com.adedom.covid19.viewmodel.CasesViewModel
import com.adedom.covid19.viewmodel.SumViewModel
import com.adedom.covid19.viewmodel.TimelineViewModel
import com.adedom.covid19.viewmodel.TodayViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<Covid19Repository> { Covid19RepositoryImpl(get(), get()) }

    viewModel { TodayViewModel(get()) }
    viewModel { TimelineViewModel(get()) }
    viewModel { CasesViewModel(get()) }
    viewModel { SumViewModel(get()) }

}
