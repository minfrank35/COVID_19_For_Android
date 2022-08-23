package com.example.covid_19_for_android.viewmodel

import android.text.TextUtils
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covid_19_for_android.data.CovidRepository
import com.example.covid_19_for_android.data.impl.CovidRepositoryImpl
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO3
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class CovidViewModel(private val repository: CovidRepositoryImpl)  {
//    private val _covidResponse = MutableLiveData<ResCovidNewAdmissionDO>()
//    val covidResponse : LiveData<ResCovidNewAdmissionDO> = _covidResponse
//
//    fun covidResponse(){
//        CoroutineScope(Dispatchers.IO).launch {
//            val response : Response<ResCovidNewAdmissionDO> = repository.getNewAdmission()
//            if(response.isSuccessful) {
//                Log.e("minfrank", response.body().toString())
////                _covidResponse.postValue(response.body())
//            } else {
//
//            }
//        }
//    }
    var todaypatient : MutableState<String> = mutableStateOf("")
    var accumulatedpatient : MutableState<String> = mutableStateOf("")

    init {
        CoroutineScope(Dispatchers.IO).launch {
            todaypatient.value = getTodayPatient()
        }
    }

    suspend fun getTodayPatient() : String {
        val res = repository.getNewAdmission()
        val jsonObject: JsonObject = res.response.result[0] as JsonObject
        val gson = Gson().fromJson(jsonObject, ResCovidNewAdmissionDO3::class.java)
        return gson.cnt7
    }

    fun refreshTodayPatient() {
        CoroutineScope(Dispatchers.IO).launch {
            val res = repository.getNewAdmission()
            val jsonObject: JsonObject = res.response.result[0] as JsonObject
            val gson = Gson().fromJson(jsonObject, ResCovidNewAdmissionDO3::class.java)
            todaypatient.value = gson.cnt7
        }
    }

}