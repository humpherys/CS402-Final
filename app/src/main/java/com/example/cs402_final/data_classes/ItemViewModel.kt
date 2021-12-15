package com.example.cs402_final.data_classes

import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.

    var allItems = repository.readAllItems().asLiveData()

    fun getItemName(itemName: String) {
        return repository.getItem(itemName)
    }

    // Launch new coroutine to unsert data in a nonblocking way

    fun insert(item: Item)  {
        viewModelScope.launch {
            repository.addItem(item)
        }
    }
}

class ItemViewModelFactory(private val repository: ItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}