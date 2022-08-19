package com.example.covid_19_for_android.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covid_19_for_android.data.CovidRepository
import com.example.covid_19_for_android.data.impl.CovidRepositoryImpl
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO
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

    fun getTodayPatient() {
        repository.getNewAdmission()
    }

}