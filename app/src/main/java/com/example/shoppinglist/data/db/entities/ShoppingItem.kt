package com.example.shoppinglist.data.db.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem (
    @ColumnInfo(name = "iten_name")
    var name: String,
    @ColumnInfo(name = "iten_amount")
    var quantity: Int,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}