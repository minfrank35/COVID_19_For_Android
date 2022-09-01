package com.example.covid_19_for_android.retrofit

import com.example.covid_19_for_android.data.response.RES_CovidTodayDO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface XmlRetrofitInterface {
    @GET("openapi/service/rest/Covid19/getCovid19InfStateJson")
    fun getCovidToday(
        @Query("serviceKey") serviceKey : String,
        @Query("pageNo") pageNo : String,
        @Query("numOfRows") numOfRows : String,
        @Query("startCreateDt") startCreateDt : String,
        @Query("endCreateDt") endCreateDt : String
    ) : Call<RES_CovidTodayDO>
}