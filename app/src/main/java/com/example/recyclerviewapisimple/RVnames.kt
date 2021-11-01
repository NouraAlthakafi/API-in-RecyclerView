package com.example.recyclerviewapisimple

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapisimple.databinding.ItemNamesBinding

class RVnames(var nameArray: ArrayList<namesListItem?>) : RecyclerView.Adapter<RVnames.ViewHolder>() {
    class ViewHolder(val binding: ItemNamesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNamesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aNames = nameArray[position]
        holder.binding.apply {
            tvName.text = aNames!!.name
        }
    }

    override fun getItemCount(): Int {
        return nameArray.size
    }

}
