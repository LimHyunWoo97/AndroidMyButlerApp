package com.example.mybutler.Widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mybutler.textSizeConverter
import com.example.mybutler.ui.theme.freesentation
import com.example.mybutler.ui.theme.moonapColor

@Composable
fun SubTitle() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(color = Color.Transparent)
            .padding(start = 2.dp, end = 2.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp), // 좌우 여백 추가
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // 좌우로 요소 분리
        ) {
            Text(
                text = "우리동네 전문가",
                fontFamily = freesentation,
                style = TextStyle(
                    fontSize = textSizeConverter.dpToSp(15.dp),
                    fontWeight = FontWeight.W500,
                    color = moonapColor.MoonapBlack
                )
            )

            // 우측 버튼

            Box (modifier = Modifier.background(moonapColor.MoonapLightGray, shape = RoundedCornerShape(5.dp))
                .fillMaxWidth(0.2f)
                .fillMaxHeight(0.5f)
                .align(Alignment.CenterVertically),
                contentAlignment = Alignment.Center ){
                Text(
                    text = "등급안내",
                    fontFamily = freesentation,
                    style = TextStyle(
                        fontSize = textSizeConverter.dpToSp(11.dp),
                        fontWeight = FontWeight.Normal,
                        color = moonapColor.MoonapDarkGray,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }

}

@Composable
fun SubTitle2(title:String, fontsize: Dp, fontWeight: FontWeight) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(color = Color.Transparent)
            .padding(start = 2.dp, end = 2.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp), // 좌우 여백 추가
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // 좌우로 요소 분리
        ) {
            Text(
                text = title,
                fontFamily = freesentation,
                style = TextStyle(
                    fontSize = textSizeConverter.dpToSp(fontsize),
                    fontWeight = fontWeight,
                    color = moonapColor.MoonapBlack
                )
            )


        }
    }

}


@Preview(name = "PreviewAccessLogScreen", showBackground = true)
@Composable
fun PreviewAccessLogScreen(){
    Column {
        SubTitle()
        SubTitle2(title = "원하는 전문가를 찾아보세요", fontsize = 18.dp, fontWeight = FontWeight.W700)
    }

}