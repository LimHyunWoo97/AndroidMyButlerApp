// ButlerInfoBox.kt
package com.example.mybutler.Widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybutler.Model.DummyModel
import com.example.mybutler.ui.theme.moonapColor

@Composable
fun ButlerInfoBox(item: DummyModel) { // ✅ 단일 모델
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(moonapColor.MoonapWhite, shape = RoundedCornerShape(5.dp))
            .padding(0.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement =Arrangement.SpaceBetween){
            // 오른쪽: 티어 박스



            Text(
                "${item.butlerName} • ${item.careerYears} • ${item.activeScore}",
                color = moonapColor.MoonapDarkGray,
                fontSize = 15.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.weight(1f) // ✅ 왼쪽을 차지하도록
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val (bgColor, textColor) = when (item.tier) {
                    "New" -> Color.LightGray to Color.Black
                    "베이직" -> moonapColor.MunapBlue to Color.White
                    "프리미엄" -> Color(0xFFFFD700) to Color.Black   // 금색 느낌
                    "VIP" -> Color(0xFF8B0000) to Color.White        // 진한 빨강
                    else -> Color.Gray to Color.White
                }

                Box(
                    modifier = Modifier
                        .width(60.dp)   // ✅ 고정 가로
                        .height(28.dp)  // ✅ 고정 세로
                        .background(bgColor, shape = RoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = item.tier,
                        color = textColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(4.dp)) // 티어 박스와 점수 간격

                Text(
                    item.gradePoint,
                    color = moonapColor.MoonapDarkGray,
                    fontSize = 13.sp
                )
            }
        }
    }
}

fun Modifier.Companion.height(dp: Dp) {}

@Preview
@Composable
private fun ButlerInfoBoxPreview() {
    ButlerInfoBox(
        DummyModel("홍길동", "5년", "120회 활동", "4.8점", "프리미엄")
    )
}
