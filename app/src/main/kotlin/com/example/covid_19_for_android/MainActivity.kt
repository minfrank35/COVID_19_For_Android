package com.example.covid_19_for_android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import com.example.covid_19_for_android.repository.impl.CovidRepositoryImpl
import com.example.covid_19_for_android.ui.main.MainView
import com.example.covid_19_for_android.viewmodel.CovidViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainView()
            }
        }
    }

//    fun main() = runBlocking<Unit> {
//        launch(Dispatchers.Unconfined) {
//            Log.e("coroutine", "Unconfined      : I'm working in thread ${Thread.currentThread().name}")
//            delay(500)
//            Log.e("coroutine","Unconfined      : After delay in thread ${Thread.currentThread().name}")
//        }
//
//        launch {
//            Log.e("coroutine","main runBlocking: I'm working in thread ${Thread.currentThread().name}")
//            delay(1000)
//            Log.e("coroutine","main runBlocking: After delay in thread ${Thread.currentThread().name}")
//        }
//    }

}





