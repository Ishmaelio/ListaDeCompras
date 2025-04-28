package com.example.listacompras.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.listacompras.ui.ShoppingListScreen
import com.example.listacompras.ui.AddItemScreen
import com.example.listacompras.viewmodel.ShoppingListViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: ShoppingListViewModel) {
    NavHost(navController, startDestination = "shoppingList") {
        composable("shoppingList") { ShoppingListScreen(viewModel) }
        composable("addItem") { AddItemScreen(viewModel) }
    }
}
