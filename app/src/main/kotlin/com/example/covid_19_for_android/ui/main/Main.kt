package com.example.covid_19_for_android.ui.main

import android.content.Context
import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.example.covid_19_for_android.MainActivity
import com.example.covid_19_for_android.R
import com.example.covid_19_for_android.data.serviceDO.ServiceMainContentDetailDO
import com.example.covid_19_for_android.ui.theme.*
import kotlinx.coroutines.launch


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
    Column {
        TopAppBarMain()
        ContentMain()
    }
}

@Composable
fun ContentMain() {
    Spacer(modifier = Modifier.height(15.dp))

    ContentTopMain()

    Spacer(modifier = Modifier.height(15.dp))

    ContentTop2Main()
}

@Composable
fun ContentTopMain() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color_1a1f2c),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
//        var list :MutableList<ServiceMainContentDetailDO> = mutableListOf()
//        list.add(ServiceMainContentDetailDO("확진자"))
        for(i in 0..3) {
            ContentTopMainDetail(null)
        }
    }
}


@Composable
fun ContentTopMainDetail(detailContent : ServiceMainContentDetailDO?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(13.dp)
    ) {
        Text(
            text = "확진자",
            color = color_cfcfcf,
            fontSize = 12.sp
        )

        Text(
            text = "content",
            color = color_eb5374,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ContentTop2Main() {
    Row(modifier = Modifier
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
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "오늘 확진자",
            fontSize = 12.sp,
            color = color_cfcfcf
        )

        Text(
            text = "30,260",
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
        CompareWithTodayDetail("어제", 18003)

        CompareWithTodayDetail(compareDay = "1주전", compareNumber = 11677)
    }

    Column() {
        CompareWithTodayDetail("2주전", 18003)

        CompareWithTodayDetail(compareDay = "4주전", compareNumber = 11677)
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

