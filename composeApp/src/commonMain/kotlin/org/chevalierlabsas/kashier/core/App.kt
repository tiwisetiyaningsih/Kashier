package org.chevalierlabsas.kashier.core

import SaveButton
import Searchbar
import SelectedItemChip
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Searchbar(
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                )
                SelectedItemChip(
                    modifier = Modifier.padding(top = 16.dp).align(Alignment.Start),
                    text = "Contoh Barang Terpilih",
                    onRemove = {
                        println("Item dihapus!")
                    }
                )
                SaveButton(
                    modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                    onSave = {
                        println("Data disimpan!")
                    }
                )
            }
        }
    }
}