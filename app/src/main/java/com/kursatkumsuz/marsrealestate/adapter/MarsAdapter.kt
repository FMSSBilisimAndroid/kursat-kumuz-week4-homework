package com.kursatkumsuz.marsrealestate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.kursatkumsuz.marsrealestate.databinding.ListItemBinding
import com.kursatkumsuz.marsrealestate.view.fragment.FeedFragmentDirections
import com.kursatkumsuz.marsrealestate.model.MarsModel
import javax.inject.Inject

class MarsAdapter @Inject constructor(
    val glide: RequestManager) :
    RecyclerView.Adapter<MarsAdapter.MarsViewHolder>() {

    lateinit var dataList : List<MarsModel>

    class MarsViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, android.R.anim.slide_in_left)
        holder.itemView.startAnimation(animation)

        holder.binding.apply {
            glide.load(dataList[position].image).into(rowImageView)
            idText.text = dataList[position].id
        }

        holder.itemView.setOnClickListener {
            val action = FeedFragmentDirections.actionListFragmentToDetailFragment(arrayOf(dataList.toTypedArray()[position]))
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}