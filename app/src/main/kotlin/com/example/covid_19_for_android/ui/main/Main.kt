package com.example.covid_19_for_android.ui.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covid_19_for_android.R
import com.example.covid_19_for_android.data.response.ResCovidNewAdmissionDO3
import com.example.covid_19_for_android.repository.impl.CovidRepositoryImpl
import com.example.covid_19_for_android.ui.theme.*
import com.example.covid_19_for_android.viewmodel.CovidViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


private val covidViewModel : CovidViewModel by lazy { CovidViewModel(CovidRepositoryImpl()) }

@Composable
fun TopAppBarTitle() {
    Row() {
        Text(
            text = stringResource(R.string.top_app_bar_name1),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = color_cfcfcf,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = stringResource(R.string.top_app_bar_name2),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = color_5e70e5,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview("TopAppBarMain")
@Composable
fun TopAppBarMain() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color_1a1f2c)
        ,
    ) {
        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            TopAppBarImage1()
        }

        Box(modifier = Modifier.align(Alignment.Center)) {
            TopAppBarTitle()
        }
    }
}

@Composable
fun TopAppBarImage1() {
    IconButton(onClick = {  }) {
        Image(painter = painterResource(id = R.drawable.icon), contentDescription = null)
    }
}

//@Composable
//fun ModalDrawerSample(content : @Composable () -> Unit) {
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//
//    ModalDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            Column {
//                Text("Text in Drawer")
//                Button(onClick = {
//                    scope.launch {
//                        drawerState.close()
//                    }
//                }) {
//                    Text("Close Drawer")
//                }
//            }
//        },
//        content = content
//    )
//}

@Preview("MainView")
@Composable
fun MainView() {
    val swipeRefreshState by covidViewModel.refreshState.observeAsState(false)

    SwipeRefresh(state = rememberSwipeRefreshState(swipeRefreshState), onRefresh = { covidViewModel.refreshMain() }) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())){
            TopAppBarMain()

            ContentMain()
        }
    }
}

@Composable
fun ContentMain() {
    ContentTopMain()

    ContentTop2Main()

    ContentTop3Main()

}


@Preview("ContentCenterMain", showBackground = true)
@Composable
fun ContentTop3Main() {
    val patientWeek by covidViewModel.patitentWeek.observeAsState(ResCovidNewAdmissionDO3())

    Column(
        modifier = Modifier
            .padding(top = 0.dp, start = 15.dp, end = 15.dp, bottom = 15.dp)
            .clip(shape = RoundedCornerShape(10.dp))
    ) {
        ContentCenterMainTitle()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color_1a1f2c),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ContentTopMainDetail(title = "??????", content = patientWeek.cnt7)
            ContentTopMainDetail(title = "1??????", content = patientWeek.cnt6)
            ContentTopMainDetail(title = "2??????", content = patientWeek.cnt5)
            ContentTopMainDetail(title = "3??????", content = patientWeek.cnt4)
        }
    }
}


@Composable
fun ContentCenterMainTitle() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(color_1a1f2c)
            .padding(10.dp),
        textAlign = TextAlign.Center,
        text = "?????? ????????? ???",
        color = color_cfcfcf,
        fontSize = 20.sp,
        fontFamily = fontDalseo
    )
}

@Composable
fun ContentTopMain() {
    Row(modifier = Modifier
        .padding(top = 15.dp, start = 15.dp, end = 15.dp, bottom = 15.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .fillMaxWidth()
        .background(color_1a1f2c),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

    }
}

@Composable
fun ContentTopMainDetail(title : String, content : String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(13.dp)
    ) {
        Text(
            text = title,
            color = color_cfcfcf,
            fontSize = 12.sp
        )
        Text(
            text = content,
            color = color_eb5374,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ContentTop2Main() {
    Row(
        modifier = Modifier
            .padding(top = 0.dp, start = 15.dp, end = 15.dp, bottom = 15.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .heightIn()
            .background(color_1a1f2c)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TodayInfected()

        CompareWithToday()
    }
}


@Composable
fun TodayInfected() {
    val todayInfectedCount by covidViewModel.todayInfectedCount.observeAsState("0")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "?????? ?????????",
            fontSize = 12.sp,
            color = color_cfcfcf
        )

        Text(
            text = todayInfectedCount,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = color_cfcfcf,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun CompareWithToday() {
    Column() {
        CompareWithTodayDetail("??????", 18003)

        CompareWithTodayDetail(compareDay = "1??????", compareNumber = 11677)
    }

    Column() {
        CompareWithTodayDetail("2??????", 18003)

        CompareWithTodayDetail(compareDay = "4??????", compareNumber = 11677)
    }

}

@Composable
fun CompareWithTodayDetail(compareDay : String, compareNumber : Int) {
    Row(verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            text = "vs",
            color = color_cfcfcf,
            fontSize = 10.sp,
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = compareDay,
            color = color_cfcfcf,
            fontSize = 13.sp,
            modifier = Modifier.width(35.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Surface(
            color = color_2b2331,
            shape = RoundedCornerShape(50),
        ) {
            Text(
                text = compareNumber.toString(),
                color = color_cfcfcf,
                fontSize = 12.sp,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

