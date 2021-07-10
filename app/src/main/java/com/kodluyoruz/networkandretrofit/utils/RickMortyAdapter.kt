package com.kodluyoruz.networkandretrofit.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kodluyoruz.networkandretrofit.R
import com.kodluyoruz.networkandretrofit.models.core.Character

class RickMortyAdapter : RecyclerView.Adapter<RickMortyAdapter.RickMortyViewHolder>() {

    var list = ArrayList<Character>()

    class RickMortyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val rickAndMortImageView: ImageView = item.findViewById(R.id.chacterImageView)
        private val nameTextView: TextView = item.findViewById(R.id.nameTextView)
        private val isAliveTextView: TextView = item.findViewById(R.id.isAliveTextView)
        fun bind(character: Character) {
            Glide.with(rickAndMortImageView.context)
                .load(character.image).into(rickAndMortImageView);
            nameTextView.text = character.name
            isAliveTextView.text = character.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewHolder {
        val viewItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rickmorty, parent, false)
        return RickMortyViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: RickMortyViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

    fun setRickMortyData(list: List<Character>) {
        this.list = ArrayList(list)
        notifyDataSetChanged()
    }

    fun insertRickMortyData(list: List<Character>) {
        val listIndex = this.list.size
        this.list.addAll(ArrayList(list))
        notifyItemInserted(listIndex)
    }



}