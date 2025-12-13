import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.unit.dp
import org.chevalierlabsas.kashier.home.presentetion.components.formatRupiah

@Composable
fun History(onBack: () -> Unit) {

    val todayHistory = listOf(
        Triple(250000.0, 10, "26 Juli 2025"),
        Triple(150000.0, 5, "26 Juli 2025")
    )

    val weekHistory = listOf(
        Triple(500000.0, 20, "24 Juli 2025"),
        Triple(100000.0, 1, "23 Juli 2025")
    )

    val monthHistory = listOf(
        Triple(250000.0, 10, "26 Juli 2025"),
        Triple(150000.0, 5, "26 Juli 2025"),
        Triple(500000.0, 20, "24 Juli 2025"),
        Triple(250000.0, 20, "16 Juli 2025"),
        Triple(250000.0, 20, "16 Juli 2025"),
        Triple(250000.0, 20, "16 Juli 2025"),
        Triple(250000.0, 20, "16 Juli 2025"),
        Triple(250000.0, 20, "16 Juli 2025"),
        Triple(250000.0, 20, "16 Juli 2025")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }

            Text(
                text = "History",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Hari ini
        Text(
            text = "Hari ini",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        todayHistory.forEach { (totalHarga, totalBarang, tanggal) ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Row {
                        Text("Total Harga",
                              fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(formatRupiah(totalHarga))
                    }
                    Row {
                        Text("Total Barang",
                            fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text("$totalBarang")
                    }
                    Row {
                        Text("Tanggal",
                            fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(tanggal)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        // Minggu ini
        Text(
            text = "Minggu ini",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        weekHistory.forEach { (totalHarga, totalBarang, tanggal) ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Row {
                        Text("Total Harga",
                            fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(formatRupiah(totalHarga))
                    }
                    Row {
                        Text("Total Barang",
                            fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text("$totalBarang")
                    }
                    Row {
                        Text("Tanggal",
                            fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(tanggal)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        // Bulan ini
        Text(
            text = "Bulan ini",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        monthHistory.forEach { (totalHarga, totalBarang, tanggal) ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Row {
                        Text("Total Harga",
                            fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(formatRupiah(totalHarga))
                    }
                    Row {
                        Text("Total Barang",
                            fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text("$totalBarang")
                    }
                    Row {
                        Text("Tanggal",
                            fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(tanggal)
                    }
                }
            }
        }
    }
}
