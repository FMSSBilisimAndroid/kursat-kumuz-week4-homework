package com.kursatkumsuz.marsrealestate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.kursatkumsuz.marsrealestate.databinding.CartItemBinding
import com.kursatkumsuz.marsrealestate.room.MarsEntity
import javax.inject.Inject

class CartAdapter @Inject constructor(
    private val glide: RequestManager
) : RecyclerView.Adapter<CartAdapter.CartHolder>() {
    class CartHolder(val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtill = object : DiffUtil.ItemCallback<MarsEntity>() {
        override fun areItemsTheSame(oldItem: MarsEntity, newItem: MarsEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MarsEntity, newItem: MarsEntity): Boolean {
            return oldItem == newItem
        }
    }

    private val recyclerListDiffer = AsyncListDiffer(this, diffUtill)
    var marsList: List<MarsEntity>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartHolder(binding)
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        holder.binding.apply {
            itemIdText.text = marsList[position].id
            itemTypeText.text = marsList[position].type
            itemPriceText.text = "$${marsList[position].price.toString()}"
            glide.load(marsList[position].image).into(itemImageView)
        }
    }

    override fun getItemCount(): Int {
        return marsList.size
    }
}