package com.example.covid_19_for_android.data.response

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONObject


data class ResCovidNewAdmissionDO(
    @SerializedName("response")
    var response : ResCovidNewAdmissionDO2
)

data class ResCovidNewAdmissionDO2(
    var resultMsg : String  = "",
    var result : JsonArray  = JsonArray(),
    var resultCnt : String  = "",
    var resultCode : String = ""
)

data class ResCovidNewAdmissionDO3(
    var cnt1 : String  = "",
    var cnt2 : String  = "",
    var cnt3 : String  = "",
    var cnt4 : String  = "",
    var cnt5 : String  = "",
    var cnt6 : String  = "",
    var cnt7 : String  = "",
    var cnt8 : String  = "",
)





