package com.example.mybutler.Widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mybutler.MunapTextSizeConverter
import com.example.mybutler.ui.theme.moonapColor
import com.example.mybutler.ui.theme.freesentation

@Composable
fun FindButton(onClick: () -> Unit,
    //width: Float = 1.0f,
                height: Dp,
                backgroundColor: Color,
                text: String,
                textColor: Color,
                disabledTextColor: Color = Color.Black,
                cornerRadius: Dp,
                textSize: Dp,
                elevation: Dp,
                horizontalPadding : Dp = 20.dp,
                enabled: Boolean = true // ✅ 추가
) {
    val textSizeConverter = MunapTextSizeConverter()
    val fontsizeSp = textSizeConverter.dpToSp(textSize) // Dp를 Sp로 변환합니다.
    Button(
        onClick = onClick,
        enabled = enabled, // ✅ 연결
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .padding(horizontal = horizontalPadding)
            .background(color = backgroundColor, shape = RoundedCornerShape(cornerRadius)),
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
            disabledContainerColor = moonapColor.MoonapGray,
            disabledContentColor = disabledTextColor // 텍스트 색상도 설정
        ),
        elevation = ButtonDefaults.buttonElevation(elevation),
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "뒤로가기",
                modifier = Modifier.size(25.dp),
                tint = moonapColor.MoonapYellow
            )
            Spacer(modifier = Modifier.padding(start = 5.dp))
            Text(
                text = text,
                color = textColor,
                fontSize = fontsizeSp,
                fontFamily = freesentation
            )
        }

    }
}

@Preview(name = "MunapButton")
@Composable
fun MunapButtonreView(){
    FindButton(
        onClick = {

        },
        height = 45.dp,
        backgroundColor = moonapColor.MoonapWhite,
        text = "가능한  전문가  찾기",
        textColor = Color.Black,
        cornerRadius = 5.dp,
        textSize = 22.dp,
        elevation = 2.dp
    )


}