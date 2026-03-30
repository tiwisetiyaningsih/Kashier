package org.chevalierlabsas.kashier.history.presentation

import org.chevalierlabsas.kashier.history.domain.History

data class HistoryState(
    val histories: Map<String, List<History>> = emptyMap()
)