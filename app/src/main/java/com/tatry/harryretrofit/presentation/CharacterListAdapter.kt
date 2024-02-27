package com.tatry.harryretrofit.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tatry.harryretrofit.R
import com.tatry.harryretrofit.domain.model.CharacterModel

class CharacterListAdapter
    : RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>() {


        var characterList = mutableListOf<CharacterModel>(
            CharacterModel(1, "Potter1", "r1", ""),
            CharacterModel(2, "Potter2", "r1", ""),
            CharacterModel(3, "Potter3", "r1", ""),
            CharacterModel(4, "Potter4", "r1", ""),
            CharacterModel(5, "Potter5", "r1", ""),
            CharacterModel(6, "Potter6", "r1", ""),
        )

            set(value) {
                val callback = CharacterListDiffCallback(characterList, value)
                val diffResult = DiffUtil.calculateDiff(callback)
                diffResult.dispatchUpdatesTo(this)
                field = value
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.character_item, parent, false) // inflate - долгая операция; выполняется
        // столько раз сколько элементов помещается на экране + запас элементов +- 2
        return CharacterListViewHolder(itemView)
    }

    // вызывается для отрисовки всех элемнов list, для переиспользования
    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        val characterItem = characterList[position]
        holder.imageView.load(characterItem.imageUrl)
        holder.tvName.text = characterItem.name
        holder.tvHouse.text = characterItem.hogwartsHouse
    }
    override fun getItemCount(): Int = characterList.size


        // инкапсулирует все виджеты
    class CharacterListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvHouse: TextView = itemView.findViewById(R.id.tvHouse)


    }

}