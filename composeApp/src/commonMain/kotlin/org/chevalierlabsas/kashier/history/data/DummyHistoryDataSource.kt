package org.chevalierlabsas.kashier.history.data

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.todayIn
import org.chevalierlabsas.kashier.history.domain.History
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class DummyHistoryDataSource {
    @OptIn(ExperimentalTime::class)
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())

    fun getHistories(): List<History> {
        return listOf(
            History(1, today, 150.0, 5), // Today
            History(2, today.minus(1, DateTimeUnit.DAY), 75000.0, 3), // Last Week
            History(3, today.minus(6, DateTimeUnit.DAY), 200000.0, 8), // Last Week
            History(4, today.minus(10, DateTimeUnit.DAY), 99000.0, 2), // This Month
            History(5, today.minus(1, DateTimeUnit.MONTH), 350000.0, 12), // Last Month
            History(6, today.minus(1, DateTimeUnit.MONTH).minus(2, DateTimeUnit.DAY), 45000.0, 1), // Last Month
            History(7, today.minus(2, DateTimeUnit.MONTH), 500000.0, 20), // 2 Months ago
            History(8, today.minus(1, DateTimeUnit.YEAR), 120000.0, 4) // Last Year
        )
    }

}