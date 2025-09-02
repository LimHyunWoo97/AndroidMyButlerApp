package com.example.mybutler.Widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybutler.R
import com.example.mybutler.textSizeConverter
import com.example.mybutler.ui.theme.freesentation

@Composable
fun TitleBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .clip(RoundedCornerShape(10.dp)), // 이미지도 모서리 둥글게
        contentAlignment = Alignment.Center
    ) {
        // 1. 배경 이미지
        Image(
            painter = painterResource(id = R.mipmap.notice_image), // ✅ 원하는 이미지 리소스
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // 꽉 채우기
        )

        // 2. 어둡게 덮는 반투명 레이어
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.01f)) // 40% 어둡게
        )

        // 3. 텍스트 (중앙 정렬 예시)
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(start = 20.dp, end = 25.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom){
            Text(
                text = "청소가 힘들때 신청해보세요",
                color = Color(0xC4FFFFFF),
                fontSize = textSizeConverter.dpToSp(15.dp),
                fontFamily = freesentation
            )
            Text(
                text = "깨끗한 우리집",
                color = Color(0xFFFFFFFF),
                fontSize = textSizeConverter.dpToSp(18.dp),
                fontFamily = freesentation,
                fontWeight = FontWeight.W700
            )
            Text(
                text = "나만의 가사도우미 찾기",
                color = Color(0xFFFFFFFF),
                fontSize = textSizeConverter.dpToSp(18.dp),
                fontFamily = freesentation,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
        }

    }
}


@Composable
fun NoticeBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f)
            .clip(RoundedCornerShape(10.dp)), // 이미지도 모서리 둥글게
        contentAlignment = Alignment.Center
    ) {
        // 1. 배경 이미지
        Image(
            painter = painterResource(id = R.mipmap.notice_image), // ✅ 원하는 이미지 리소스
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // 꽉 채우기
        )

        // 2. 어둡게 덮는 반투명 레이어
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.01f)) // 40% 어둡게
        )

        // 3. 텍스트 (중앙 정렬 예시)
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(start = 20.dp, end = 25.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom){
            Text(
                text = "청소가 힘들때 신청해보세요",
                color = Color(0xC4FFFFFF),
                fontSize = textSizeConverter.dpToSp(15.dp),
                fontFamily = freesentation
            )
            Text(
                text = "깨끗한 우리집",
                color = Color(0xFFFFFFFF),
                fontSize = textSizeConverter.dpToSp(18.dp),
                fontFamily = freesentation,
                fontWeight = FontWeight.W700
            )
            Text(
                text = "나만의 가사도우미 찾기",
                color = Color(0xFFFFFFFF),
                fontSize = textSizeConverter.dpToSp(18.dp),
                fontFamily = freesentation,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
        }

    }
}



@Preview
@Composable
private fun ButlerInfoBoxPreview() {
    Surface {
        Box (modifier = Modifier.fillMaxSize()
            .padding(2.dp)){

            NoticeBox(

            )
        }
    }
}
