package com.example.mybutler.Utilities

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybutler.MunapTextSizeConverter
import com.example.mybutler.R
import com.example.mybutler.Screen.MainScreen
import com.example.mybutler.Screen.SelectButlerScreen
import com.example.mybutler.ui.theme.freesentation
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ViewModelConstructorInComposable")
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun MunapNavigationController(navController: NavHostController, context: Context) {
    NavHost(navController, startDestination = "main") {
        composable(route = "selectButler",
            enterTransition = { slideInFromRight() }, // 진입 시 왼쪽에서 오른쪽으로 슬라이드
            exitTransition = { slideOutToLeft() },   // 종료 시 오른쪽에서 왼쪽으로 슬라이드
            popEnterTransition = { slideInFromLeft() }, // 뒤로 가기 시 오른쪽에서 왼쪽으로 슬라이드
            popExitTransition = { slideOutToRight() }   // pop 시 왼쪽에서 오른쪽으로 슬라이드
        ) { SelectButlerScreen(navController) }

        composable(route ="main",
            enterTransition = { slideInFromRight() }, // 진입 시 왼쪽에서 오른쪽으로 슬라이드
            exitTransition = { slideOutToLeft() },   // 종료 시 오른쪽에서 왼쪽으로 슬라이드
            popEnterTransition = { slideInFromLeft() }, // 뒤로 가기 시 오른쪽에서 왼쪽으로 슬라이드
            popExitTransition = { slideOutToRight() }   // pop 시 왼쪽에서 오른쪽으로 슬라이드
     ) { MainScreen(navController,context) }
    }
}
fun slideInFromRight(): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { fullWidth -> fullWidth },
        animationSpec = tween(300)
    ) + fadeIn(animationSpec = tween(300))
}

fun slideOutToLeft(): ExitTransition {
    return slideOutHorizontally(
        targetOffsetX = { fullWidth -> -fullWidth },
        animationSpec = tween(300)
    ) + fadeOut(animationSpec = tween(300))
}

fun slideInFromLeft(): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { fullWidth -> -fullWidth },
        animationSpec = tween(300)
    ) + fadeIn(animationSpec = tween(300))
}

fun slideOutToRight(): ExitTransition {
    return slideOutHorizontally(
        targetOffsetX = { fullWidth -> fullWidth },
        animationSpec = tween(300)
    ) + fadeOut(animationSpec = tween(300))
}

enum class ScaleTransitionDirection {
    INWARDS, OUTWARDS
}
@OptIn( ExperimentalFoundationApi::class)
@Composable
fun MunapBottomNavigationController(navController: NavHostController,pagerState: PagerState) {
    val iconSize = 20.dp

    val items = listOf(
        BottomNavItem.Main,
        BottomNavItem.CleanService,
        BottomNavItem.Chat,
        //BottomNavItem.LocationRecognition,
        BottomNavItem.Setting
    )
    val textSizeConverter = MunapTextSizeConverter()
    val coroutineScope = rememberCoroutineScope() // CoroutineScope 생성
    BottomNavigation(
        backgroundColor = Color(0xFFFFFFFF),
        modifier = Modifier.wrapContentHeight()
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = pagerState.currentPage == index
            BottomNavigationItem(
                icon = {
                    Image(
                        painter = painterResource(
                            id = if (isSelected) item.selectedIcon else item.unselectedIcon
                        ),
                        contentDescription = item.title,
                        modifier = Modifier.size(iconSize)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = freesentation,
                            color = if (isSelected) Color.Black else Color(0xFF999999)
                        ),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                },
                selected = isSelected,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                selectedContentColor = Color.Transparent,
                unselectedContentColor = Color.Transparent
            )
        }
    }
}

sealed class BottomNavItem(val route: String, val selectedIcon: Int, val unselectedIcon: Int, val title: String) {
    data object Main : BottomNavItem(
        "main",
        R.mipmap.selected_home,
        R.mipmap.unselected_home,
        "홈"
    )

    data object CleanService : BottomNavItem(
        "clean_service",
        R.mipmap.selected_cleaning_services,
        R.mipmap.unselected_cleaning_services,
        "예약관리"
    )

    data object Chat : BottomNavItem(
        "chat",
        R.mipmap.selected_chat,
        R.mipmap.unselected_chat,
        "커뮤니티"
    )

    data object Setting : BottomNavItem(
        "setting",
        R.mipmap.selected_settings,
        R.mipmap.unselected_settings,
        "설정"
    )

    /*data object LocationRecognition : BottomNavItem(
        "locationRecogn",
        R.mipmap.access_log_button_xxxhdpi,
        R.mipmap.access_log_button_unselected_xxxhdpi,
        "위치서비스"
    )*/
}


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true, name = "BottomNavigation")
@Composable
fun PreviewBottomNavigation(){
    val navController = rememberNavController()
    val pagerState = rememberPagerState(  initialPage = 0, // AccessCardScreen이 기본 화면이 되도록 설정
        pageCount = { 4 })
    MunapBottomNavigationController(navController,pagerState)
}