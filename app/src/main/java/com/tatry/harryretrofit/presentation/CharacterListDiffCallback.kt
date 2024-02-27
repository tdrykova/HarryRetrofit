package com.tatry.harryretrofit.presentation

import androidx.recyclerview.widget.DiffUtil
import com.tatry.harryretrofit.domain.model.CharacterModel

class CharacterListDiffCallback(
    private val oldList: List<CharacterModel>,
    private val newList: List<CharacterModel>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }
}