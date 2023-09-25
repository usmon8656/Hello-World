package com.example.helloworld.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asadullo.wordsapp.databinding.ItemRvBinding
import com.example.helloworld.Models.User

class MyAdapter(var list: ArrayList<User> = ArrayList(), val click:Clikc) : RecyclerView.Adapter<MyAdapter.Vh>() {
    inner class Vh(var item: ItemRvBinding) : RecyclerView.ViewHolder(item.root) {
        @SuppressLint("Range")
        fun onBind(user: User, position: Int) {
            val unit = "GROUP ${position+1}"
            item.txtItem.text = user.name
            item.txtItemCount.text = unit
            item.root.setOnClickListener {
                click.click(user, position, unit)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    interface Clikc{
        fun click(user: User, position: Int, unit:String)
    }
}