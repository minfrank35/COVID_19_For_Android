package com.example.covid_19_for_android.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.covid_19_for_android.repository.impl.CovidRepositoryImpl
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO3
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.*


/**
 * 코로나 관련 ViewModel
 */
class CovidViewModel(private val repository: CovidRepositoryImpl)  {

    /**
     * SwipeRefresh의 작업 상태
     * 네트워크나 작업 중인상태면 : true
     * 작업이 끝나거나 아무것도 안하는 상태 : false
     */
    var _refreshState : MutableLiveData<Boolean> = MutableLiveData(false)
    val refreshState : LiveData<Boolean> get() = _refreshState

    /**
     * 일주일간의 신규 입원자 수
     */
    var _patitentWeek : MutableLiveData<ResCovidNewAdmissionDO3> = MutableLiveData(ResCovidNewAdmissionDO3())
    val patitentWeek : LiveData<ResCovidNewAdmissionDO3> get() = _patitentWeek


    /**
     * 오늘 입원자 숫자
     */
    var _todayInfectedCount : MutableLiveData<String> = MutableLiveData("0")
    val todayInfectedCount : LiveData<String> get() = _todayInfectedCount

    init {
        getPatientInHospital().start()
        getTodayInfected().start()
    }

    fun refreshMain() {
        CoroutineScope(Dispatchers.IO).launch {
            _refreshState.postValue( true)

            val job1 = getPatientInHospital()
            val job2 = getTodayInfected()

            job1.start()
            job2.start()

            job1.join()
            job2.join()

            _refreshState.postValue( false)
        }
    }
//    /**
//     * 일주일간의 신규 입원자수 refresh
//     */
//    fun refreshPatientInHospital() : Job
//        = CoroutineScope(Dispatchers.IO).launch {
//            try {
//
//                val res = repository.getNewAdmission()
//                val jsonObject: JsonObject = res.response.result[0] as JsonObject
//                val resObject = Gson().fromJson(jsonObject, ResCovidNewAdmissionDO3::class.java)
//                patitentWeek.value = resObject
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }


    /**
     * 일주일간의 신규 입원자수 api 요청
     */
    fun getPatientInHospital() =
        CoroutineScope(Dispatchers.IO).launch {
            val res = repository.getNewAdmission()
            val jsonObject: JsonObject = res.response.result[0] as JsonObject
            val resObject = Gson().fromJson(jsonObject, ResCovidNewAdmissionDO3::class.java)
            _patitentWeek.postValue(resObject)
        }


    /**
     * 오늘의 확진자 수
     */
    fun getTodayInfected()
        = CoroutineScope(Dispatchers.IO).launch {
            val res = repository.getTodayCovidData("1", "10", "20200310", "20200315")
            for(i in res.body.items.item) {
                if(i.stateDt == "20220830")
                _todayInfectedCount.postValue(i.decideCnt)
            }
        }

}