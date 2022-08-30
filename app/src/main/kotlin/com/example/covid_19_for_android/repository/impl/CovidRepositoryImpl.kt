package com.example.covid_19_for_android.repository.impl

import android.util.Log
import com.example.covid_19_for_android.const.ApiConst
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO
import com.example.covid_19_for_android.repository.CovidRepository
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO2
import com.example.covid_19_for_android.retrofit.RetrofitCovidInterface
import com.google.gson.GsonBuilder
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalStateException

class CovidRepositoryImpl() : CovidRepository {

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor { message ->
        Log.e(
            "minfrank2",
            message
        )
    }.apply {
        level = HttpLoggingInterceptor.Level.NONE
    }).addInterceptor {
        // Request
        val request = it.request()
            .newBuilder()
            .headers(Headers.headersOf(
                "Content-type", "application/json"
            ))
            .build()
        // Response
        val response = it.proceed(request)
        response
    }.build()

    private var gson = GsonBuilder().setLenient().create()

    private val covidRetrofit = Retrofit.Builder()
        .baseUrl(ApiConst.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val covidRetrofitService  = covidRetrofit.create(RetrofitCovidInterface::class.java)

    override suspend fun getNewAdmission(): ResCovidNewAdmissionDO {
            val call = covidRetrofitService.getNewAdmission(ApiConst.SERVICE_KEY_NEW_ADMISSION)
            val response : Response<ResCovidNewAdmissionDO> = call.execute()

            if(response.isSuccessful) return response.body() as ResCovidNewAdmissionDO
            return ResCovidNewAdmissionDO(ResCovidNewAdmissionDO2())
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