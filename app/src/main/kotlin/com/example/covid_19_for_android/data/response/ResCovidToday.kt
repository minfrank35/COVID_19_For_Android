package com.example.covid_19_for_android.data.response

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "response")
data class RES_CovidTodayDO(
    @Element(name = "header")
    var header : RES_CovidTodayHeaderDO = RES_CovidTodayHeaderDO(),

    @Element(name = "body")
    var body : RES_CovidTodayBodyDO = RES_CovidTodayBodyDO()
)


@Xml(name = "body")
data class RES_CovidTodayBodyDO(
    @Element(name="items")
    val items: RES_CovidTodayItems = RES_CovidTodayItems(),
    @PropertyElement(name="numOfRows")
    val numOfRows: String = "err",
    @PropertyElement(name="pageNo")
    val pageNo: String = "err",
    @PropertyElement(name="totalCount")
    val totalCount: String = "err"
)

@Xml(name="header")
data class RES_CovidTodayHeaderDO(
    //결과코드
    @PropertyElement(name="resultCode")
    val resultCode: String = "err",

    //결과메세지
    @PropertyElement(name="resultMsg")
    val resultMsg: String = "err"
)


@Xml(name = "items")
data class RES_CovidTodayItems(
    @Element(name="item")
    val item: List<RES_CovidTodayItem> = listOf(RES_CovidTodayItem())
)
@Xml(name = "item")
data class RES_CovidTodayItem(
    //누적 확진률
    @PropertyElement(name = "accDefRate")
    val accDefRate: String = "err",

    //누적 검사 완료 수
    @PropertyElement(name = "accExamCnt")
    val accExamCnt: String= "err",

    //등록일시분초
    @PropertyElement(name = "createDt")
    val createDt: String= "err",

    //사망자 수
    @PropertyElement(name = "deathCnt")
    val deathCnt: String= "err",

    //확진자 수
    @PropertyElement(name = "decideCnt")
    val decideCnt: String= "err",

    //게시글번호(감염현황 고유값)
    @PropertyElement(name = "seq")
    val seq: String= "err",

    //기준일
    @PropertyElement(name = "stateDt")
    val stateDt: String= "err",

    //기준시간
    @PropertyElement(name = "stateTime")
    val stateTime: String= "err",

    //수정일시분초
    @PropertyElement(name = "updateDt")
    val updateDt: String= "err"
)










