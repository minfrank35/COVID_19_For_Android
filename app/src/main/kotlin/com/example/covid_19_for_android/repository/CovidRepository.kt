package com.example.covid_19_for_android.repository

import com.example.covid_19_for_android.data.response.RES_CovidTodayDO
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO
import retrofit2.Call
import retrofit2.Response


interface CovidRepository {
    suspend fun getNewAdmission() : ResCovidNewAdmissionDO

    suspend fun getTodayCovidData(
        //optional
        pageNo : String,
        //optional
        numOfRows : String,
        //optional
        startCreateDt : String,
        //optional
        endCreateDt : String
    ) : RES_CovidTodayDO
}