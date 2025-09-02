package com.example.mybutler.Widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mybutler.MunapTextSizeConverter
import com.example.mybutler.ui.theme.freesentation
import com.example.mybutler.ui.theme.moonapColor


@Composable
fun MenuVerticalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,          // ✅ 외부에서 치장
    backgroundColor: Color,
    Maintext: String,
    Subtext: String,
    textColor: Color,
    disabledTextColor: Color = Color.Black,
    cornerRadius: Dp,
    MainfontsizeSp: Dp,
    SubfontsizeSp: Dp,
    elevation: Dp,
    icon: ImageVector,
    horizontalPadding: Dp = 0.dp,
    enabled: Boolean = true
) {
    val textSizeConverter = MunapTextSizeConverter()
    val mainSp = textSizeConverter.dpToSp(MainfontsizeSp)
    val subSp  = textSizeConverter.dpToSp(SubfontsizeSp)

    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .padding(horizontal = horizontalPadding), // ✅ 여기엔 weight 없음
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
            disabledContainerColor = moonapColor.MoonapGray,
            disabledContentColor = disabledTextColor
        ),
        elevation = ButtonDefaults.buttonElevation(elevation),
        contentPadding = PaddingValues(10.dp)
    ) {
        Column (modifier = Modifier.fillMaxWidth().padding(0.dp)){
            Icon(

                imageVector = icon,
                contentDescription = "뒤로가기",
                modifier = Modifier.size(50.dp)
                    .padding(start = 5.dp),
                tint = moonapColor.MoonapYellow
            )
            Spacer(modifier = Modifier.padding(top = 15.dp))
            Text(
                text = Maintext,
                color = textColor,
                fontSize = mainSp,
                fontFamily = freesentation,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                text = Subtext,
                color = moonapColor.MoonapGray,
                fontSize = subSp,
                fontFamily = freesentation,
            )
        }
    }
}



@Composable
fun MenuHorizontalButton(onClick: () -> Unit,
                       width: Float = 1.0f,
                       height: Dp = 50.dp,
                       backgroundColor: Color,
                       Maintext: String,
                       Subtext: String,
                       textColor: Color,
                       disabledTextColor: Color = Color.Black,
                       cornerRadius: Dp,
                       MaintextSize: Dp,
                       SubtextSize: Dp,
                       elevation: Dp,
                       icon: ImageVector,
                       horizontalPadding : Dp = 0.dp,
                       enabled: Boolean = true // ✅ 추가
) {
    val textSizeConverter = MunapTextSizeConverter()
    val MainfontsizeSp = textSizeConverter.dpToSp(MaintextSize) // Dp를 Sp로 변환합니다.
    val SubfontsizeSp = textSizeConverter.dpToSp(SubtextSize) // Dp를 Sp로 변환합니다.
    Button(
        onClick = onClick,
        enabled = enabled, // ✅ 연결
        modifier = Modifier
            .fillMaxWidth(width)
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
        contentPadding = PaddingValues(10.dp)
    ) {
        Row (  modifier = Modifier.fillMaxWidth(0.9f).fillMaxHeight(0.7f),horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = "뒤로가기",
                modifier = Modifier.size(50.dp),
                tint = moonapColor.MoonapYellow
            )
            Spacer(modifier = Modifier.padding(start = 20.dp))
            Column( modifier = Modifier.fillMaxWidth().fillMaxHeight(1f), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
                Text(
                    text = Maintext,
                    color = textColor,
                    fontSize = MainfontsizeSp,
                    fontFamily = freesentation,
                    fontWeight = FontWeight.W700
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(
                    text = Subtext,
                    color = moonapColor.MoonapGray,
                    fontSize = SubfontsizeSp,
                    fontFamily = freesentation,
                )
            }

        }

    }
}

@Preview(name = "MunapButton")
@Composable
fun MenuButtonpreView(){
    Surface {
        Box (modifier = Modifier.fillMaxSize()
            .padding(2.dp)){

            Column(modifier = Modifier.fillMaxSize()) {

                MenuVerticalButton(
                    onClick = { /*...*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),     // 또는 .weight(1f) — 부모가 Column/Row일 때만!
                    backgroundColor = moonapColor.MoonapWhite,
                    Maintext = "가능한  전문가  찾기",
                    Subtext = "가능한  전문가  찾기",
                    textColor = Color.Black,
                    cornerRadius = 5.dp,
                    MainfontsizeSp = 22.dp,
                    SubfontsizeSp = 15.dp,
                    elevation = 4.dp,
                    icon = Icons.Filled.CleaningServices
                )


                Spacer(modifier = Modifier.padding(top = 30.dp))
                MenuHorizontalButton(
                    onClick = {

                    },
                    width = 1f,
                    height = 50.dp,
                    backgroundColor = moonapColor.MoonapWhite,
                    Maintext = "가능한  전문가  찾기",
                    Subtext = "가능한  전문가  찾기",
                    textColor = Color.Black,
                    cornerRadius = 5.dp,
                    MaintextSize = 22.dp,
                    SubtextSize = 15.dp,
                    elevation = 2.dp,
                    icon = Icons.Filled.CleaningServices // ✅ 원하는 아이콘 전달
                )
            }

        }
    }
}