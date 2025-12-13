package org.chevalierlabsas.kashier.core

import AddEditItemDialog
import SaveButton
import Searchbar
import SelectedItemChip
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.chevalierlabsas.kashier.home.domain.Item
import org.chevalierlabsas.kashier.home.presentetion.components.ItemDivider
import org.chevalierlabsas.kashier.home.presentetion.components.ItemListItem
import org.chevalierlabsas.kashier.home.presentetion.components.formatRupiah

@Composable
fun HomeScreen(
    onOpenHistory: () -> Unit
) {
    val dummyItems = remember {
        listOf(
            Item(1, 1, "Telur 0.5 KG", 12000.0),
            Item(2, 1, "Jeruk Mandarin 1 KG", 30000.0),
            Item(3, 1, "Alpukat 250 GR", 50000.0),
            Item(4, 1, "Teh Celup 25 PCS", 15500.0)
        )
    }

    var isItemsExpanded by remember { mutableStateOf(true) }
    var isSelectedItemsExpanded by remember { mutableStateOf(true) } // state baru
    var showAddEditDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<Item?>(null) }

    var searchQuery by remember { mutableStateOf("") }

    val filteredItems = dummyItems.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    val selectedItems = remember {
        mutableStateListOf<Item>(
            Item(1, 1, "Telur 0.5 KG", 12000.0),
            Item(2, 1, "Jeruk Mandarin 1 KG", 30000.0)
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Kashier",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(onClick = onOpenHistory) {
                        Icon(
                            imageVector = Icons.Default.History,
                            contentDescription = "History"
                        )
                    }
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text("Total Harga", style = MaterialTheme.typography.bodyMedium)
                }

                Text(
                    text = formatRupiah(250000000000.0),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )

                SaveButton(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    onSave = { println("Buka form Buat Barang") }
                )

                // Barang Terpilih (collapsible)
                ItemDivider(
                    label = "Barang terpilih",
                    isExpanded = isSelectedItemsExpanded,
                    onToggleVisibility = { isSelectedItemsExpanded = !isSelectedItemsExpanded }
                )

                if (isSelectedItemsExpanded) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        selectedItems.forEach { item ->
                            SelectedItemChip(text = item.name, onRemove = { selectedItems.remove(item) })
                        }
                    }
                }

                // Semua Barang
                ItemDivider(
                    label = "Semua barang",
                    isExpanded = isItemsExpanded,
                    onToggleVisibility = { isItemsExpanded = !isItemsExpanded }
                )

                Searchbar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 16.dp),
                    value = searchQuery,
                    onValueChange = { searchQuery = it }
                )

                if (isItemsExpanded) {
                    Column(
                        modifier = Modifier.padding(top = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        filteredItems.forEach { item ->
                            ItemListItem(
                                item = item,
                                onEdit = {
                                    selectedItem = it
                                    showAddEditDialog = true
                                },
                                onAdd = {
                                    selectedItem = it
                                    showAddEditDialog = true
                                }
                            )
                        }
                    }
                }
            }

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp, bottom = 60.dp),
                containerColor = MaterialTheme.colorScheme.primary,
                onClick = {
                    selectedItem = null
                    showAddEditDialog = true
                }
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "+ Buat Barang"
                )
            }

            if (showAddEditDialog) {
                AddEditItemDialog(
                    item = selectedItem,
                    onDismiss = { showAddEditDialog = false },
                    onSave = {
                        showAddEditDialog = false
                    }
                )
            }
        }
    }
}
