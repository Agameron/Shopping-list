package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context, private var addDialogListener: AddDialogListener):AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tv_add.setOnClickListener{
            val name = et_name.text.toString()
            val amount = et_amount.text.toString()

            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Coloque todas as informações",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name,amount.toInt())
            addDialogListener.onAddBtnClicked(item)
            dismiss()
        }

        tv_cancel.setOnClickListener{
            cancel()
        }
    }

}