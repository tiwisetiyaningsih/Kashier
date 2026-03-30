import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.chevalierlabsas.kashier.home.presentation.HomeEvent
import org.chevalierlabsas.kashier.home.presentation.HomeState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditItemSheet(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    onDismiss: () -> Unit,
    isEdit: Boolean = false
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color.White,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = if (isEdit) "Edit Barang" else "Tambah Barang",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Nama barang", fontWeight = FontWeight.SemiBold)
                TextField(
                    value = state.itemNameInput,
                    onValueChange = { onEvent(HomeEvent.OnItemNameChange(it)) },
                    placeholder = { Text("Beri nama barang", color = MaterialTheme.colorScheme.onTertiaryContainer) },
                    leadingIcon = {
                        Icon(Icons.Default.TextFields, contentDescription = null, tint = MaterialTheme.colorScheme.onTertiaryContainer)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        focusedContainerColor = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.1f),
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Harga barang", fontWeight = FontWeight.SemiBold)
                TextField(
                    value = state.itemPriceInput,
                    onValueChange = { onEvent(HomeEvent.OnItemPriceChange(it)) },
                    placeholder = { Text("000,00", color = MaterialTheme.colorScheme.onTertiaryContainer) },
                    leadingIcon = {
                        Text("Rp. ", modifier = Modifier.padding(start = 12.dp), fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onTertiaryContainer)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        focusedContainerColor = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.1f),
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    onEvent(HomeEvent.OnAddNewItem)
                    onDismiss()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8D5262)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Simpan", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}