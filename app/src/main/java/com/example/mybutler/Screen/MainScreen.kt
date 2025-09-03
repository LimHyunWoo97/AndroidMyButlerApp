package com.example.mybutler.Screen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mybutler.Utilities.MunapBottomNavigationController
import com.example.mybutler.textSizeConverter
import com.example.mybutler.ui.theme.freesentation
import com.example.mybutler.ui.theme.moonapColor

@SuppressLint("ObsoleteSdkInt")
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun MainScreen(navController: NavHostController, context: Context) {
    val screens = listOf(
        "main",
        "chat",
        "clean_service",
        "setting"
    )
    // "accessCard"의 위치 찾기 (없으면 0번 페이지)
    val initialPageIndex = screens.indexOf("main")
    val pagerState = rememberPagerState(initialPage = initialPageIndex, pageCount = { screens.size })

    val scope = rememberCoroutineScope()
    val currentPageState = remember { mutableStateOf(pagerState.currentPage) }
    var currentScreen by remember { mutableStateOf(screens[initialPageIndex]) }
    //var showTutorial = sharedPreference.getTutorialState()

    // 페이지 전환 시 상태 업데이트
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            currentPageState.value = page
            currentScreen = screens[page]
        }
    }


    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = moonapColor.MoonapWhite,
                elevation = 0.dp,
                contentColor = contentColorFor(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                ) {
                    // 🔹 가운데: 공지사항 타이틀
                    Text(
                        text = "노양구 산주동",
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
        },
        bottomBar = { MunapBottomNavigationController(navController = navController, pagerState = pagerState)}
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            beyondViewportPageCount = screens.size,
            modifier = Modifier.padding(innerPadding).background(Color.White)
        ) { page ->
            when (screens[page]) {
                "main" -> {
                    if (currentPageState.value == page) {
                        HomeScreen(navController, context)
                    }
                }
                "chat" -> {

                }
                "clean_service" -> {

                }

                "setting" -> {

                }
            }
        }

    }


}


@RequiresApi(Build.VERSION_CODES.S)
@Preview( showBackground = true)
@Composable
fun PreviewMainScreen(){
    //val viewModel = AptKeyInfoViewModel() // 미리보기에서 사용할 ViewModel 인스턴스 생성
    val navController = rememberNavController()
    MainScreen(
        navController = navController,
        context = LocalContext.current
    )
}
