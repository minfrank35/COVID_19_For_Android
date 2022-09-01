package com.example.covid_19_for_android.retrofit

import com.example.covid_19_for_android.const.ApiConst
import com.example.covid_19_for_android.data.response.RES_CovidTodayDO
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitCovidInterface {
    @GET("1790387/covid19CurrentStatusHospitalizations/covid19CurrentStatusHospitalizationsJson")
    fun getNewAdmission(@Query("serviceKey") serviceKey : String) :  Call<ResCovidNewAdmissionDO>
}