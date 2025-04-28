package com.example.listacompras.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.listacompras.data.Item
import com.example.listacompras.viewmodel.ShoppingListViewModel

@Composable
fun AddItemScreen(viewModel: ShoppingListViewModel) {
    var name by remember { mutableStateOf("") }

    Column {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Nombre") })
        Button(onClick = { viewModel.addItem(Item(name = name, bought = false)) }) {
            Text("Agregar")
        }
    }
}
