package com.example.shoppinglist.data.repositories

import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun insert(item: ShoppingItem) = db.getShoppingDAO().insert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDAO().delete(item)

    fun getAllItems() = db.getShoppingDAO().returnAllItems()

}