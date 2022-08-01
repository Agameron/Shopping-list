package com.example.shoppinglist.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*


class ShoppingListAdapter(
    var item: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = item[position]

        holder.itemView.tv_name.text = curShoppingItem.name
        holder.itemView.tv_amount.text = "${curShoppingItem.quantity}"

        holder.itemView.iv_delete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.iv_plus.setOnClickListener {
            curShoppingItem.quantity++
            viewModel.insert(curShoppingItem)
        }

        holder.itemView.iv_minus.setOnClickListener {
            if (curShoppingItem.quantity > 0) {
                curShoppingItem.quantity--
                viewModel.insert(curShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}