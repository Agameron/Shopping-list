package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun retornAllItens(): LiveData<List<ShoppingItem>>
}