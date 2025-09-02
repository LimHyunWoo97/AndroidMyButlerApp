package com.example.mybutler.Screen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mybutler.MunapTextSizeConverter
import com.example.mybutler.Widget.MenuHorizontalButton
import com.example.mybutler.Widget.MenuVerticalButton
import com.example.mybutler.Widget.SubTitle2
import com.example.mybutler.Widget.TitleBox
import com.example.mybutler.ui.theme.moonapColor

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun HomeScreen(navController: NavHostController, context: Context) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val textSizeConverter = MunapTextSizeConverter()
    // 로딩 상태를 관리하는 상태 변수
    val isLoading = remember { mutableStateOf(true) }


    Surface(
        color = moonapColor.MoonapWhite,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    }
                )
            }
    ) {
        BoxWithConstraints(Modifier.fillMaxSize()) {
            val buttonH = maxHeight * 0.2f   // 예: 화면의 16%
            val buttonHH = maxHeight * 0.35f   // 예: 화면의 16%

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)

            ) {
                TitleBox()
                Spacer(modifier = Modifier.fillMaxHeight(0.03f))
                SubTitle2(
                    title = "원하는 지역의 가사도우미 찾기",
                    fontsize = 18.dp,
                    fontWeight = FontWeight.W700
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.03f))
                MenuHorizontalButton(
                    onClick = {
                        navController.navigate("selectButler")
                    },
                    width = 1f,
                    height = buttonH,
                    backgroundColor = moonapColor.MoonapWhite,
                    Maintext = "가능한  전문가  찾기",
                    Subtext = "가능한  전문가  찾기",
                    textColor = Color.Black,
                    cornerRadius = 5.dp,
                    MaintextSize = 22.dp,
                    SubtextSize = 15.dp,
                    elevation = 4.dp,
                    icon = Icons.Filled.CleaningServices // ✅ 원하는 아이콘 전달
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.05f))
                Row ( modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp), // 간격만 지정
                    verticalAlignment = Alignment.CenterVertically// 좌우로 요소 분리
                    ){
                    MenuVerticalButton(
                        onClick = {    },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(buttonHH)
                            .weight(1f) ,     // 또는 .weight(1f) — 부모가 Column/Row일 때만!
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
                    MenuVerticalButton(
                        onClick = { /*...*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(buttonHH)
                            .weight(1f) ,     // 또는 .weight(1f) — 부모가 Column/Row일 때만!
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
                }

            }
        }
    }
}
@Preview(name = "PreviewAccessLogScreen", showBackground = true)
@Composable
fun PreviewAccessLogScreen(){
    val navController = rememberNavController()
    HomeScreen(navController,context = LocalContext.current)
}