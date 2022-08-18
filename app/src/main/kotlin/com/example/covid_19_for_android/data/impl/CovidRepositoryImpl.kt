package com.example.covid_19_for_android.data.impl

import android.util.Log
import com.example.covid_19_for_android.const.ApiConst
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO
import com.example.covid_19_for_android.data.CovidRepository
import com.example.covid_19_for_android.retrofit.RetrofitApiCallback
import com.example.covid_19_for_android.retrofit.RetrofitApiHelper
import com.example.covid_19_for_android.retrofit.RetrofitCovidNewAdmission
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidRepositoryImpl(var retrofitApiCallback: Callback<ResCovidNewAdmissionDO>) : CovidRepository  {
    override fun getNewAdmission(): ResCovidNewAdmissionDO {
//        (RetrofitApiHelper(RetrofitCovidNewAdmission::class).service as RetrofitCovidNewAdmission).getNewAdmission(
//            serviceKey = ApiConst.SERVICE_KEY
//        ).enqueue(
//            object : Callback<ResCovidNewAdmissionDO> {
//                override fun onResponse(
//                    call: Call<ResCovidNewAdmissionDO>,
//                    response: Response<ResCovidNewAdmissionDO>
//                ) {
//                    if (response.isSuccessful) {
//                        retrofitApiCallback.onSuccess()
//                    } else {
//                        callback.successFail()
//                    }
//                }
//
//                override fun onFailure(call: Call<ResCovidNewAdmissionDO>, t: Throwable) {
//
//                    callback.fail()
//                }
//            }
//        )
        return ResCovidNewAdmissionDO("","","")
    }
}