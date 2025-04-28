package com.example.listacompras.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.listacompras.viewmodel.ShoppingListViewModel
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete

@Composable
fun ShoppingListScreen(viewModel: ShoppingListViewModel) {
    val items by viewModel.items.collectAsState(initial = emptyList())

    LazyColumn {
        items(items.size) { index ->
            val item = items[index]
            Row(modifier = Modifier.fillMaxWidth()) {
                Checkbox(
                    checked = item.bought,
                    onCheckedChange = { viewModel.updateItem(item.copy(bought = it)) }
                )
                Text(text = item.name)
                IconButton(onClick = { viewModel.deleteItem(item) }) {
                    //Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                    Icon(Icons.Filled.Delete, contentDescription = "Eliminar")
                }
            }
        }
    }
}
