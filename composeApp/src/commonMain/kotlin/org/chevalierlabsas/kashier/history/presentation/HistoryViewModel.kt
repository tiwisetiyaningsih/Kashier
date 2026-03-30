package org.chevalierlabsas.kashier.history.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.datetime.*
import org.chevalierlabsas.kashier.history.data.DummyHistoryDataSource
import org.chevalierlabsas.kashier.history.domain.History

class HistoryViewModel : ViewModel() {

    private val _histories = DummyHistoryDataSource().getHistories()

    private val _state = MutableStateFlow(HistoryState())
    val state = _state.asStateFlow()

    init {
        val today = LocalDate(2026, 3, 31)

        _state.value = HistoryState(
            histories = groupHistoryByDate(_histories, today)
        )
    }

    private fun groupHistoryByDate(
        histories: List<History>,
        today: LocalDate
    ): Map<String, List<History>> {

        val sevenDaysAgo = today.minus(7, DateTimeUnit.DAY)

        return histories.groupBy { history ->
            val date = history.date

            when {
                date == today -> "Hari ini"

                date > sevenDaysAgo && date < today -> "Minggu ini"

                date.year == today.year && date.month == today.month -> "Bulan ini"

                else -> {
                    val monthName = date.month.getDisplayName()
                    "$monthName ${date.year}"
                }
            }
        }
    }

    private fun Month.getDisplayName(): String {
        return this.name.lowercase().replaceFirstChar { it.uppercase() }
    }
}