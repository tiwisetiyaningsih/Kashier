package org.chevalierlabsas.kashier.home.presentetion.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ItemDivider(
    modifier: Modifier = Modifier,
    label: String = "Semua barang",
    isExpanded: Boolean = true,
    onToggleVisibility: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onToggleVisibility() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Divider(
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )

        val icon = if (isExpanded) {
            Icons.Default.KeyboardArrowDown
        } else {
            Icons.Default.KeyboardArrowDown
        }

        Icon(
            imageVector = icon,
            contentDescription = "Tampilkan/Sembunyikan daftar barang",
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview
@Composable
private fun PreviewItemDivider() {
    MaterialTheme {
        ItemDivider(
            label = "Semua barang",
            onToggleVisibility = { println("Toggle visibility") }
        )
    }
}