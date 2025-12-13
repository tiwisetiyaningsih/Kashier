package org.chevalierlabsas.kashier.core
import History
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    var currentPage by remember { mutableStateOf("HOME") }

    when (currentPage) {
        "HOME" -> HomeScreen(
            onOpenHistory = { currentPage = "HISTORY" }
        )

        "HISTORY" -> History(
            onBack = { currentPage = "HOME" }
        )
    }
}