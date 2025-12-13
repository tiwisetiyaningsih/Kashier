package org.chevalierlabsas.kashier.home.presentetion.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import org.chevalierlabsas.kashier.home.domain.Item
import org.jetbrains.compose.ui.tooling.preview.Preview

fun formatRupiah(amount: Double): String {
    val value = amount.toLong().toString()
    val formatted = value
        .reversed()
        .chunked(3)
        .joinToString(".")
        .reversed()

    return "Rp. $formatted"
}

@Composable
fun ItemListItem(
    modifier: Modifier = Modifier,
    item: Item,
    onEdit: (Item) -> Unit,
    onAdd: (Item) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onAdd(item) },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = formatRupiah(item.price),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.weight(0.1f))

            IconButton(
                onClick = { onEdit(item) },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit ${item.name}",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }

            IconButton(
                onClick = { onAdd(item) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambahkan ${item.name}",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewItemListItem() {
    val dummyItem = Item(id = 1, userId = 101, name = "Telur 0.5 KG", price = 12000.0)
    MaterialTheme {
        ItemListItem(
            item = dummyItem,
            onEdit = { println("Edit: ${it.name}") },
            onAdd = { println("Tambah: ${it.name}") }
        )
    }
}