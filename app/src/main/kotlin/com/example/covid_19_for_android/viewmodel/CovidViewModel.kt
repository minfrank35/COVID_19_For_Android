package com.example.covid_19_for_android.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO
import com.example.covid_19_for_android.repository.impl.CovidRepositoryImpl
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO3
import com.example.covid_19_for_android.data.serviceDO.ServiceMainContentDetailDO
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.*
import okhttp3.internal.wait


/**
 * 코로나 관련 ViewModel
 */
class CovidViewModel(private val repository: CovidRepositoryImpl)  {

    /**
     * SwipeRefresh의 작업 상태
     * 네트워크나 작업 중인상태면 : true
     * 작업이 끝나거나 아무것도 안하는 상태 : false
     */
    var refreshState = mutableStateOf(false)

    /**
     * 일주일간의 신규 입원자 수
     */
    var patitentWeek : MutableState<ResCovidNewAdmissionDO3> = mutableStateOf(ResCovidNewAdmissionDO3())


    /**
     * 일주일간의 신규 입원자수 api 요청(patientweek 갱신)
     */
    fun refreshPatientInHospital() {

        CoroutineScope(Dispatchers.IO).launch {

            try {
                refreshState.value = true
                val res = repository.getNewAdmission()
                val jsonObject: JsonObject = res.response.result[0] as JsonObject
                val resObject = Gson().fromJson(jsonObject, ResCovidNewAdmissionDO3::class.java)

                patitentWeek.value = resObject
                refreshState.value = false
                } catch (e: Exception) {
                    e.printStackTrace()
            }
        }
    }
}