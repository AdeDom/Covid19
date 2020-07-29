package com.adedom.covid19.data.networks

import com.adedom.covid19.data.db.entities.Sum
import com.adedom.covid19.data.db.entities.Timeline
import com.adedom.covid19.data.db.entities.Today
import com.adedom.covid19.data.models.Cases
import retrofit2.http.GET

interface Covid19Api {

    @GET("api/open/today")
    suspend fun fetchToday(): Today

    @GET("api/open/timeline")
    suspend fun fetchTimeline(): Timeline

    @GET("api/open/cases")
    suspend fun fetchCases(): Cases

    @GET("api/open/cases/sum")
    suspend fun fetchSum(): Sum

}
