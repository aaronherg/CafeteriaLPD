package com.aarondevs.cafeterialpd

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.aarondevs.cafeterialpd.presentation.component.NotificationHost
import com.aarondevs.cafeterialpd.presentation.navigation.NavigationNavHost
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        val navHost = rememberNavController()
        NavigationNavHost(navHost)
        NotificationHost()
    }
}