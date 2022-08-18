package com.example.covid_19_for_android.data

import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO


interface CovidRepository {
    fun getNewAdmission() : ResCovidNewAdmissionDO
}