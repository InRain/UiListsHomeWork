package com.homework.uilistshomework.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.Item
import com.homework.uilistshomework.databinding.CarItemBinding
import com.homework.uilistshomework.databinding.MotorcycleItemBinding
import com.homework.uilistshomework.databinding.TaxiItemBinding

class Adapter() :
    RecyclerView.Adapter<Adapter.BaseViewHolder>() {

    var itemList: List<Item> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            CAR_ITEM_TYPE -> CarViewHolder(parent)
            TAXI_ITEM_TYPE -> TaxiViewHolder(parent)
            else -> MotorcycleViewHolder(parent)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (val item = itemList[position]) {
            is Item.Car -> (holder as CarViewHolder).bind(item, position)
            is Item.Motorcycle -> (holder as MotorcycleViewHolder).bind(item, position)
            is Item.Taxi -> (holder as TaxiViewHolder).bind(item, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is Item.Car -> CAR_ITEM_TYPE
            is Item.Motorcycle -> MOTORCYCLE_ITEM_TYPE
            is Item.Taxi -> TAXI_ITEM_TYPE
        }
    }

    inner class CarViewHolder(private val binding: CarItemBinding) :
        BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup) : this(
            CarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Car, position: Int) {
            binding.carName.text = item.name
            binding.carColor.text = item.color
            binding.delete.setOnClickListener {
                this@Adapter.itemList =
                    this@Adapter.itemList.filterIndexed { idx, element -> idx != position }
            }
        }
    }

    inner class MotorcycleViewHolder(private val binding: MotorcycleItemBinding) :
        BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            MotorcycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Motorcycle, position: Int) {
            binding.motorcycleName.text = item.name
            binding.motorcycleType.text = item.type
            binding.delete.setOnClickListener {
                this@Adapter.itemList =
                    this@Adapter.itemList.filterIndexed { idx, element -> idx != position }
            }
        }
    }

    inner class TaxiViewHolder(private val binding: TaxiItemBinding) :
        BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            TaxiItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Taxi, position: Int) {
            binding.taxiName.text = item.name
            binding.taxiNumber.text = item.number
            binding.delete.setOnClickListener {
                this@Adapter.itemList =
                    this@Adapter.itemList.filterIndexed { idx, element -> idx != position }
            }
        }
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        const val CAR_ITEM_TYPE = 1
        const val MOTORCYCLE_ITEM_TYPE = 2
        const val TAXI_ITEM_TYPE = 3
    }
}
