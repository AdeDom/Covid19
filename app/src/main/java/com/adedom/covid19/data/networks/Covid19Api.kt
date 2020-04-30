package com.adedom.covid19.data.networks

import com.adedom.covid19.data.db.entities.Today
import com.adedom.covid19.data.models.Cases
import com.adedom.covid19.data.db.entities.Sum
import com.adedom.covid19.data.db.entities.Timeline
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Covid19Api {

    @GET("api/open/today")
    suspend fun fetchToday(): Response<Today>

    @GET("api/open/timeline")
    suspend fun fetchTimeline(): Response<Timeline>

    @GET("api/open/cases")
    suspend fun fetchCases(): Response<Cases>

    @GET("api/open/cases/sum")
    suspend fun fetchSum(): Response<Sum>

    companion object {
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor): Covid19Api {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://covid19.th-stat.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Covid19Api::class.java)
        }
    }

}
