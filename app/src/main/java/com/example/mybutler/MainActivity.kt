@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mybutler

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.mybutler.Widget.FindButton
import com.example.mybutler.Widget.SubTitle
import com.example.mybutler.Widget.ButlerList
import com.example.mybutler.ui.theme.MyButlerTheme
import com.example.mybutler.ui.theme.freesentation
import com.example.mybutler.ui.theme.moonapColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            MyButlerTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars) // <- 시스템 바 (안드로이드 폰 밑부분) 화면 비율 맞추기 위한 작업
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            MainScreen()
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(topBar = {
        TopAppBar(
            title= {
                Title()
            },

            modifier= Modifier.fillMaxWidth().padding(all= 0.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = moonapColor.MoonapWhite
            ),
            // 기본값이 statusBars 인셋이라 이대로 두면 OK
            windowInsets = TopAppBarDefaults.windowInsets

        )
    },
    ){innerPadding ->
        Surface(
            color = moonapColor.MoonapWhite,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .pointerInput(Unit) {

                }
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ){
                Spacer(modifier = Modifier.fillMaxHeight(0.03f))
                Text(
                    "가사청소",
                    modifier = Modifier.padding(horizontal = 20.dp),
                    style = TextStyle(
                    fontFamily = freesentation,
                    fontSize = textSizeConverter.dpToSp(25.dp),
                    fontWeight = FontWeight.W600,
                    color = moonapColor.MoonapBlack

                ))
                Spacer(modifier = Modifier.fillMaxHeight(0.03f))
                FindButton(
                    onClick = {},
                    height = 45.dp,
                    backgroundColor = moonapColor.MoonapWhite,
                    text = "가능한  전문가  찾기",
                    textColor = Color.Black,
                    cornerRadius = 5.dp,
                    textSize = 22.dp,
                    elevation = 2.dp)
                Spacer(modifier = Modifier.fillMaxHeight(0.03f))
                SubTitle()
                Spacer(modifier = Modifier.fillMaxHeight(0.01f))
                ButlerList()
            }
        }
    }
}



@Composable
fun Title(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        // 🔹 왼쪽: 뒤로가기 버튼
        Button(
            onClick = { },
            modifier = Modifier
                .align(Alignment.CenterStart) // 왼쪽 정렬
                .size(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = moonapColor.MoonapBlack
            ),
            elevation = null,
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "뒤로가기",
                modifier = Modifier.size(25.dp)
            )
        }

        // 🔹 가운데: 공지사항 타이틀
        Text(
            text = "마포구 상암동",
            fontFamily = freesentation,
            style = TextStyle(
                fontSize = textSizeConverter.dpToSp(18.dp),
                fontWeight = FontWeight.W500,
                color = moonapColor.MoonapBlack
            ),
            modifier = Modifier.align(Alignment.Center) // 가운데 정렬
        )
    }
}




val textSizeConverter = MunapTextSizeConverter()
class MunapTextSizeConverter {
    @Composable
    fun dpToSp(dp: Dp) = with(LocalDensity.current) { dp.toSp() }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyButlerTheme {
        Greeting()
    }
}