package com.example.shoppinglist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDAO(): ShoppingDAO

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: creatDatabase(context).also { instance = it }
        }

        private fun creatDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java, "shoppingDB.db"
            ).build()
    }
}