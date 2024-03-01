package com.tatry.harryretrofit.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tatry.harryretrofit.R
import com.tatry.harryretrofit.databinding.CharacterItemBinding
import com.tatry.harryretrofit.domain.model.CharacterModel

class CharacterListAdapter
    : ListAdapter<CharacterModel, CharacterListAdapter.CharacterListViewHolder>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        val itemView = LayoutInflater
//            .from(parent.context)
//            .inflate(R.layout.character_item, parent, false) // inflate - долгая операция; выполняется
        // столько раз сколько элементов помещается на экране + запас элементов +- 2
        return CharacterListViewHolder(binding)
    }

    // вызывается для отрисовки всех элемнов list, для переиспользования
    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        val characterItem = getItem(position)
        holder.binding.imageView.load(characterItem.imageUrl)
        holder.binding.tvName.text = characterItem.name
        holder.binding.tvHouse.text = characterItem.hogwartsHouse
    }



        // инкапсулирует все виджеты - inflate
    class CharacterListViewHolder(val binding: CharacterItemBinding)
            : RecyclerView.ViewHolder(binding.root) {
//        val imageView: ImageView = itemView.findViewById(R.id.imageView)
//        val tvName: TextView = itemView.findViewById(R.id.tvName)
//        val tvHouse: TextView = itemView.findViewById(R.id.tvHouse)
    }

}


val callback = object: DiffUtil.ItemCallback<CharacterModel>() {
    override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem == newItem
    }

}