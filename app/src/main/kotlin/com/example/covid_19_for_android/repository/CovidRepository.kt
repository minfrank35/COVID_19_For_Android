package com.example.covid_19_for_android.repository

import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO
import retrofit2.Call
import retrofit2.Response


interface CovidRepository {
    suspend fun getNewAdmission() : ResCovidNewAdmissionDO
}