package com.example.covid_19_for_android.ui.main

import android.content.Context
import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covid_19_for_android.MainActivity
import com.example.covid_19_for_android.R


@Composable
fun TopAppBarTitle() {
    Row() {
        Text(
            text = stringResource(R.string.top_app_bar_name1),
            textAlign = TextAlign.Center,
            fontSize = 23.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = stringResource(R.string.top_app_bar_name2),
            textAlign = TextAlign.Center,
            fontSize = 23.sp,
            color = Color.White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopAppBarMain() {
    CenterAlignedTopAppBar(
        title = {
            TopAppBarTitle()
        }
        ,navigationIcon = {
            IconButton(onClick = {
            }) {
                Image(painter = painterResource(id = R.drawable.icon), contentDescription = null)
            }
        }
        , actions =  {
            IconButton(onClick = { /*TODO*/ }) {
                Image(painter = painterResource(id = R.drawable.icon), contentDescription = null)
            }
        }
        , colors =
    )
}

