package com.example.wb_week_five_1.presentation.heroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.wb_week_five_1.data.HeroRepositoryImp.Companion.BASE_URL
import com.example.wb_week_five_1.databinding.HeroesListItemBinding
import com.example.wb_week_five_1.domain.Hero

class HeroesAdapter : ListAdapter<Hero, HeroesVewHolder>(DiffCallback()) {

    var onItemClickListener: ((Hero) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesVewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HeroesListItemBinding.inflate(layoutInflater, parent, false)
        return HeroesVewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroesVewHolder, position: Int) {
        val heroItem = getItem(position)
        holder.bind(heroItem)
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(heroItem)
        }
    }
}

class HeroesVewHolder(private val binding: HeroesListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Hero) {
        val url = BASE_URL + item.img

        binding.ivImage.load(url) {
            scale(Scale.FIT)
        }
        binding.tvName.text = item.name
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Hero>() {
    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean =
        oldItem.name == newItem.name
}
