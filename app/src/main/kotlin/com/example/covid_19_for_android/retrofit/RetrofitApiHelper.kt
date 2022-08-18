package com.example.covid_19_for_android.retrofit

import android.content.Context
import com.example.covid_19_for_android.const.ApiConst
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

class RetrofitApiHelper(arg: KClass<*>) {
    val service: Any by lazy {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(ApiConst.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(arg.java)
    }

//    fun enqueue() {
//        service.
//    }


}