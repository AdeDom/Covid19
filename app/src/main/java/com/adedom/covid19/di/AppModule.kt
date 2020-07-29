package com.adedom.covid19.di

import androidx.room.Room
import com.adedom.covid19.BuildConfig
import com.adedom.covid19.data.db.AppDatabase
import com.adedom.covid19.data.networks.Covid19Api
import com.adedom.covid19.data.networks.NetworkConnectionInterceptor
import com.adedom.covid19.data.repositories.Covid19Repository
import com.adedom.covid19.data.repositories.Covid19RepositoryImpl
import com.adedom.covid19.viewmodel.CasesViewModel
import com.adedom.covid19.viewmodel.SumViewModel
import com.adedom.covid19.viewmodel.TimelineViewModel
import com.adedom.covid19.viewmodel.TodayViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<Interceptor> { NetworkConnectionInterceptor(get()) }

    single<OkHttpClient> {
        OkHttpClient.Builder().apply {
            addInterceptor(get<Interceptor>())
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
        }.build()
    }

    single(named("base_url")) { "https://covid19.th-stat.com/" }

    single<Retrofit> {
        Retrofit.Builder().apply {
            client(get<OkHttpClient>())
            baseUrl(get<String>(named("base_url")))
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    single<Covid19Api> { get<Retrofit>().create(Covid19Api::class.java) }

    single(named("db_name")) { "Covid19.db" }

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, get(named("db_name"))).apply {
            fallbackToDestructiveMigration()
        }.build()
    }

    single<Covid19Repository> { Covid19RepositoryImpl(get(), get()) }

    viewModel { TodayViewModel(get()) }
    viewModel { TimelineViewModel(get()) }
    viewModel { CasesViewModel(get()) }
    viewModel { SumViewModel(get()) }

}
