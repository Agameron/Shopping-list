package com.example.shoppinglist.ui.shoppinglist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.others.ShoppingListAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShoppingActivity : AppCompatActivity() {
    private val viewModel: ShoppingViewModel by viewModel()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val adapter = ShoppingListAdapter(listOf(),viewModel)

        rv_shopping_item.layoutManager = LinearLayoutManager(this)
        rv_shopping_item.adapter = adapter

        viewModel.getAllItems().observe(this) {
            adapter.item = it
            adapter.notifyDataSetChanged()
        }
        fab.setOnClickListener{
            AddShoppingItemDialog(this,
            object : AddDialogListener{
                override fun onAddBtnClicked(item: ShoppingItem) {
                     viewModel.insert(item)
                }
            }).show()
        }

    }
}