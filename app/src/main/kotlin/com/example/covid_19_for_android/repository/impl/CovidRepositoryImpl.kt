package com.example.covid_19_for_android.repository.impl

import android.util.Log
import com.example.covid_19_for_android.const.ApiConst
import com.example.covid_19_for_android.data.response.*
import com.example.covid_19_for_android.repository.CovidRepository
import com.example.covid_19_for_android.retrofit.RetrofitClient
import com.example.covid_19_for_android.retrofit.RetrofitCovidInterface
import com.example.covid_19_for_android.retrofit.XmlRetrofitInterface
import com.google.gson.GsonBuilder
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalStateException
import java.util.concurrent.TimeUnit

class CovidRepositoryImpl() : CovidRepository {
    override suspend fun getNewAdmission(): ResCovidNewAdmissionDO {
        val call = RetrofitClient.createJsonRetrofitService(RetrofitCovidInterface::class.java)?.getNewAdmission(ApiConst.SERVICE_KEY_NEW_ADMISSION)
        return if(call != null) {
            val response: Response<ResCovidNewAdmissionDO> = call.execute()
            if (response.isSuccessful) response.body() as ResCovidNewAdmissionDO
            else ResCovidNewAdmissionDO(ResCovidNewAdmissionDO2())
        } else {
            ResCovidNewAdmissionDO(ResCovidNewAdmissionDO2())
        }
    }


    override suspend fun getTodayCovidData(pageNo : String, numOfRows : String, startCreateDt : String, endCreateDt : String) : RES_CovidTodayDO {
        val call  = RetrofitClient.createXmlRetrofitService(XmlRetrofitInterface::class.java)
            ?.getCovidToday(
                ApiConst.SERVICE_KEY_TODAY_COVID,
                pageNo,
                numOfRows,
                startCreateDt,
                endCreateDt
            ) ?: return RES_CovidTodayDO()

        val response : Response<RES_CovidTodayDO> = call.execute()

        if(response.isSuccessful) return response.body() as RES_CovidTodayDO
        return RES_CovidTodayDO(RES_CovidTodayHeaderDO(), RES_CovidTodayBodyDO())
    }
}


//.enqueue(object : Callback<ResCovidNewAdmissionDO> {
//    override fun onResponse(call: Call<ResCovidNewAdmissionDO>,response: Response<ResCovidNewAdmissionDO>) {
//        Log.e("minfrank", response.isSuccessful.toString())
//
//    }
//
//    override fun onFailure(call: Call<ResCovidNewAdmissionDO>, t: Throwable) {
//        Log.e("minfrank", "실패")
//    }
//})








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