package com.adedom.covid19.di

import com.adedom.covid19.BuildConfig
import com.adedom.covid19.data.networks.Covid19Api
import com.adedom.covid19.data.networks.NetworkConnectionInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

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

    single<Converter.Factory> { GsonConverterFactory.create() }

    single<Retrofit> {
        Retrofit.Builder().apply {
            client(get<OkHttpClient>())
            baseUrl(get<String>(named("base_url")))
            addConverterFactory(get<Converter.Factory>())
        }.build()
    }

    single<Covid19Api> { get<Retrofit>().create(Covid19Api::class.java) }

}
