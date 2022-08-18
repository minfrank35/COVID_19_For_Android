package com.example.covid_19_for_android.retrofit

import com.example.covid_19_for_android.const.ApiConst
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitCovidNewAdmission {
    @GET("/1790387/covid19CurrentStatusHospitalizations")
    fun getNewAdmission(@Query(ApiConst.SERVICE_KEY) serviceKey : String) :  Call<ResCovidNewAdmissionDO>
}