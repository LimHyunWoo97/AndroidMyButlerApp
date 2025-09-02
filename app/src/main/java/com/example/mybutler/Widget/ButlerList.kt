package com.example.mybutler.Widget

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybutler.Model.DummyModel
import com.example.mybutler.ui.theme.freesentation
import com.example.mybutler.ui.theme.moonapColor

@Composable
fun ButlerList() {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val butlerList = remember { getDummyButlerList() }

    Surface(
        color = moonapColor.MoonapWhite,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    }
                )

            }
    ) {

        if (butlerList.isEmpty()) {
            Text(
                text = "전문가가 없습니다.",
                color = moonapColor.MoonapBlack,
                style = TextStyle(fontSize = 16.sp, fontFamily = freesentation),
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                textAlign = TextAlign.Center
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(butlerList) { item ->
                    ButlerInfoBox(item)   // ✅ 단일 항목 전달
                }
            }
        }

    }
}

fun getDummyButlerList(): List<DummyModel> {
    return listOf(
        DummyModel(
            butlerName = "김영희",
            careerYears = "1년",
            activeScore = "17회 활동 ",
            gradePoint = "4.1점",
            tier = "New"
        ),
        DummyModel(
            butlerName = "박지연",
            careerYears = "2년",
            activeScore = "42회 활동",
            gradePoint = "4.2점",
            tier = "베이직"
        ),
        DummyModel(
            butlerName = "이수정",
            careerYears = "3년",
            activeScore = "63회 활동",
            gradePoint = "4.5점",
            tier = "베이직"
        ),
        DummyModel(
            butlerName = "정미라",
            careerYears = "1년",
            activeScore = "29회 활동",
            gradePoint = "4.4점",
            tier = "베이직"
        ),
        DummyModel(
            butlerName = "최선영",
            careerYears = "5년",
            activeScore = "128회 활동",
            gradePoint = "4.8점",
            tier = "프리미엄"
        ),
        DummyModel(
            butlerName = "한은주",
            careerYears = "4년",
            activeScore = "94회 활동",
            gradePoint = "4.7점",
            tier = "프리미엄"
        ),
        DummyModel(
            butlerName = "윤가영",
            careerYears = "2년",
            activeScore = "57회 활동",
            gradePoint = "4.3점",
            tier = "베이직"
        ),
        DummyModel(
            butlerName = "오현주",
            careerYears = "6년",
            activeScore = "166회 활동",
            gradePoint = "4.9점",
            tier = "프리미엄"
        ),
        DummyModel(
            butlerName = "강지현",
            careerYears = "8년",
            activeScore = "247회 활동",
            gradePoint = "4.8점",
            tier = "VIP"
        ),
        DummyModel(
            butlerName = "신혜림",
            careerYears = "7년",
            activeScore = "213회 활동",
            gradePoint = "4.7점",
            tier = "프리미엄"
        ),
        DummyModel(
            butlerName = "장미경",
            careerYears = "10년",
            activeScore = "308회 활동",
            gradePoint = "4.9점",
            tier = "VIP"
        ),
        DummyModel(
            butlerName = "김소라",
            careerYears = "9년",
            activeScore = "276회 활동",
            gradePoint = "4.9점",
            tier = "VIP"
        ),
        DummyModel(
            butlerName = "배은정",
            careerYears = "5년",
            activeScore = "143회 활동",
            gradePoint = "4.8점",
            tier = "프리미엄"
        ),
        DummyModel(
            butlerName = "문지수",
            careerYears = "1년",
            activeScore = "21회 활동",
            gradePoint = "4.2점",
            tier = "New"
        ),
        DummyModel(
            butlerName = "이선희",
            careerYears = "12년",
            activeScore = "355회 활동",
            gradePoint = "4.9점",
            tier = "VIP"
        ),
        DummyModel(
            butlerName = "조민정",
            careerYears = "3년",
            activeScore = "67회 활동",
            gradePoint = "4.4점",
            tier = "베이직"
        ),
        DummyModel(
            butlerName = "홍나래",
            careerYears = "6년",
            activeScore = "162회 활동",
            gradePoint = "4.8점",
            tier = "프리미엄"
        ),
        DummyModel(
            butlerName = "서윤정",
            careerYears = "2년",
            activeScore = "48회 활동",
            gradePoint = "4.3점",
            tier = "베이직"
        ),
        DummyModel(
            butlerName = "이영희",
            careerYears = "10년",
            activeScore = "362회 활동",
            gradePoint = "4.9점",
            tier = "VIP"
        )


        // 👉 원하는 만큼 계속 추가하면 됨 (20개까지 채워도 되고 몇 개만 넣어도 됨)
    )
}
@Preview
@Composable
private fun ButlerInfoBoxListPreview() {
    ButlerList()
}