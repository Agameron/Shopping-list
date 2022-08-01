package com.example.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository:ShoppingRepository
):ViewModel() {

    fun insert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        repository.insert(item)
    }
    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun getAllItems() = repository.getAllItems()

}
