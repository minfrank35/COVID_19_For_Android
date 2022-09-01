package com.example.covid_19_for_android.retrofit

import android.util.Log
import android.view.animation.AnticipateInterpolator
import com.example.covid_19_for_android.const.ApiConst
import com.google.gson.GsonBuilder
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
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
            .headers(
                Headers.headersOf(
                "Content-type", "application/json"
            ))
            .build()
        // Response
        val response = it.proceed(request)
        response
    }.connectTimeout(5000, TimeUnit.MILLISECONDS).build()

    private val gson = GsonBuilder().setLenient().create()

    private val covidRetrofitJson = Retrofit.Builder()
        .baseUrl(ApiConst.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    private val parser = TikXml.Builder()
        .exceptionOnUnreadXml(false)
        .build()

    private val covidRetrofitXml = Retrofit.Builder()
        .baseUrl(ApiConst.BASE_URL2)
        .client(okHttpClient)
        .addConverterFactory(TikXmlConverterFactory.create(parser))
        .build()

    fun <T> createJsonRetrofitService(temp : Class<T>) : T? {
        return covidRetrofitJson.create(temp)
    }

    fun <T> createXmlRetrofitService(temp : Class<T>) : T? {
        return covidRetrofitXml.create(temp)
    }
}