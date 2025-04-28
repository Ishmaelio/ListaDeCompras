package com.example.listacompras.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.listacompras.data.AppDatabase
import com.example.listacompras.data.Item
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShoppingListViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    private val itemDao = db.itemDao()

    val items: StateFlow<List<Item>> = itemDao.getAllItems()

    fun addItem(item: Item) = viewModelScope.launch { itemDao.addItem(item) }
    fun updateItem(item: Item) = viewModelScope.launch { itemDao.updateItem(item) }
    fun deleteItem(item: Item) = viewModelScope.launch { itemDao.deleteItem(item) }
}
