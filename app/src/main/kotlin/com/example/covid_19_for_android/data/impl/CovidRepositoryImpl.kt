package com.example.covid_19_for_android.data.impl

import com.example.covid_19_for_android.const.ApiConst
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO
import com.example.covid_19_for_android.data.CovidRepository
import com.example.covid_19_for_android.retrofit.RetrofitCovidInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CovidRepositoryImpl(var retrofitApiCallback: Callback<ResCovidNewAdmissionDO>) : CovidRepository  {
    private val covidRetrofit = Retrofit.Builder()
        .baseUrl(ApiConst.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val covidRetrofitService  = covidRetrofit.create(RetrofitCovidInterface::class.java)

    override suspend fun getNewAdmission(): Response<ResCovidNewAdmissionDO>
        = covidRetrofitService.getNewAdmission(ApiConst.SERVICE_KEY_NEW_ADMISSION)
}








//    (RetrofitApiHelper(RetrofitCovidNewAdmission::class).service as RetrofitCovidNewAdmission).getNewAdmission(
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