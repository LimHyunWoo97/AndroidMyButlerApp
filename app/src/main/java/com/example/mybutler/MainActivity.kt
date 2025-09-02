@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mybutler

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.mybutler.Utilities.MunapNavigationController
import com.example.mybutler.ui.theme.MyButlerTheme

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

@SuppressLint("NewApi")
@Composable
fun Greeting() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars) // <- 시스템 바 (안드로이드 폰 밑부분) 화면 비율 맞추기 위한 작업
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            MunapNavigationController(
                navController = rememberNavController(),
                context = LocalContext.current
            )
        }
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