package com.example.shoppinglist

import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.repositories.ShoppingRepository
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val shoppingModule = module {
    single {
        ShoppingDatabase.invoke(get())
    }
    single {
        ShoppingRepository(get())
   }
    viewModel {
        ShoppingViewModel(repository = get())
    }
}