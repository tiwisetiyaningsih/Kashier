package org.chevalierlabsas.kashier.home.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.chevalierlabsas.kashier.home.data.DummyDataSource
import org.chevalierlabsas.kashier.home.domain.Item

class HomeViewModel: ViewModel() {

    private val _items = DummyDataSource().getData()
    private val _state = MutableStateFlow(HomeState(items = _items))
    val state = _state.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.OnShowBottomSheet -> {
                _state.update { it.copy(isBottomSheetVisible = true) }
            }

            HomeEvent.OnHideBottomSheet -> {
                _state.update { it.copy(isBottomSheetVisible = false) }
            }

            HomeEvent.OnAddNewItem -> addNewItemFromInput()

            HomeEvent.OnHideBottomSheet -> {
                _state.update {
                    it.copy(
                        isBottomSheetVisible = false,
                        itemBeingEdited = null,
                        itemNameInput = "",
                        itemPriceInput = ""
                    )
                }
            }

            is HomeEvent.OnRemoveItem -> removeItem(event.item)
            is HomeEvent.OnAddItem -> addItem(event.item)
            is HomeEvent.OnAllItemVisibilityChange -> setAllItemVisibility(event.isVisible)
            is HomeEvent.OnSelectedItemVisibilityChange -> setSelectedItemVisibility(event.isVisible)
            is HomeEvent.OnSearchQueryChange -> updateQuery(event.query)
            HomeEvent.OnSearchQuerySubmit -> search()
            HomeEvent.OnSaveTransaction -> saveTransaction()

            is HomeEvent.OnItemNameChange -> {
                _state.update { it.copy(itemNameInput = event.name) }
            }
            is HomeEvent.OnItemPriceChange -> {
                _state.update { it.copy(itemPriceInput = event.price) }
            }
            is HomeEvent.OnEditItem -> {
                _state.update {
                    it.copy(
                        itemBeingEdited = event.item,
                        itemNameInput = event.item.name,
                        itemPriceInput = event.item.price.toString(),
                        isBottomSheetVisible = true
                    )
                }
            }

        }
    }

    private fun removeItem(item: Item) {
        if (_state.value.selectedItems.contains(item)) {
            _state.update { currentState ->
                currentState.copy(
                    selectedItems = currentState.selectedItems - item,
                    totalPrice = (currentState.totalPrice - item.price).coerceAtLeast(0.0)
                )
            }
        }
    }

    private fun saveTransaction() {
        println("Data berhasil disimpan: ${_state.value.selectedItems}")
        _state.update {
            it.copy(selectedItems = emptyList(), totalPrice = 0.0)
        }
    }

    private fun addItem(item: Item) {
        _state.update { currentState ->
            currentState.copy(
                selectedItems = currentState.selectedItems + item,
                totalPrice = currentState.totalPrice + item.price
            )
        }
    }

    private fun addNewItemFromInput() {
        val currentState = _state.value
        val price = currentState.itemPriceInput.toDoubleOrNull() ?: 0.0

        if (currentState.itemBeingEdited != null) {

            // EDIT ITEM
            val updatedList = currentState.items.map { item ->
                if (item.id == currentState.itemBeingEdited.id) {
                    item.copy(
                        name = currentState.itemNameInput,
                        price = price
                    )
                } else {
                    item
                }
            }

            _state.update {
                it.copy(
                    items = updatedList,
                    itemBeingEdited = null,
                    itemNameInput = "",
                    itemPriceInput = ""
                )
            }

        } else {

            // TAMBAH ITEM
            val newItem = Item(
                id = (0..1000).random(),
                userId = 1,
                name = currentState.itemNameInput,
                price = price
            )

            _state.update {
                it.copy(
                    items = it.items + newItem,
                    itemNameInput = "",
                    itemPriceInput = ""
                )
            }
        }
    }

    private fun setAllItemVisibility(visible: Boolean) {
        _state.update { it.copy(showAllItem = visible) }
    }

    private fun setSelectedItemVisibility(visible: Boolean) {
        _state.update { it.copy(showSelectedItem = visible) }
    }

    private fun search() {
        if (state.value.searchQuery.isNotBlank()) {
            _state.update {
                it.copy(
                    items = _state.value.items.filter { item ->
                        item.name.contains(_state.value.searchQuery, ignoreCase = true)
                    }
                )
            }
        } else {
            _state.update { it.copy(items = _items) }
        }
    }

    private fun updateQuery(query: String) {
        _state.update { it.copy(searchQuery = query) }

        if (query.isBlank()) {
            _state.update { it.copy(items = _items) }
        } else {
            _state.update {
                it.copy(
                    items = _items.filter { item ->
                        item.name.contains(query, ignoreCase = true)
                    }
                )
            }
        }
    }


}