package org.chevalierlabsas.kashier.core

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

import org.chevalierlabsas.kashier.core.navigation.HomeDestination
import org.chevalierlabsas.kashier.core.navigation.HistoryDestination
import org.chevalierlabsas.kashier.home.presentetion.HistoryScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = HomeDestination
        ) {

            composable<HomeDestination> {
                HomeScreen(
                    onNavigate = { navController.navigate(it) }
                )
            }

            composable<HistoryDestination> {
                HistoryScreen(
                    onNavigateBack = { navController.navigateUp() }
                )
            }
        }
    }
}

@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    TODO("Not yet implemented")
}
