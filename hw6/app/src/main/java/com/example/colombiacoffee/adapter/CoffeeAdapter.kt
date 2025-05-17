package com.example.colombiacoffee.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.colombiacoffee.databinding.CoffeeItemBinding
import com.example.colombiacoffee.model.Coffee

class CoffeeAdapter(
    private val coffeeList: List<Coffee>,
    private val onItemClick: (Coffee) -> Unit
) : RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {

    inner class CoffeeViewHolder(val binding: CoffeeItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val binding = CoffeeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoffeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        val coffee = coffeeList[position]
        holder.binding.apply {
            coffeeNameText.text = coffee.name
            coffeePriceText.text = coffee.price
            imageView.setImageResource(coffee.imageResId)
            root.setOnClickListener { onItemClick(coffee) }
        }
    }

    override fun getItemCount(): Int = coffeeList.size
}
