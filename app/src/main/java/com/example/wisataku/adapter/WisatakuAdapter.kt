package com.example.wisataku.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wisataku.DetailActivity
import com.example.wisataku.data.Wisataku
import com.example.wisataku.databinding.RowItemListBinding

class WisatakuAdapter(private val listWisataku: ArrayList<Wisataku>) :
    RecyclerView.Adapter<WisatakuAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: RowItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bindItem(wisataku: Wisataku){
                binding.tvDataJudul.text = wisataku.name
                binding.tvDataDetail.text = wisataku.detail
                binding.imgDetail.setImageResource(wisataku.photo!!)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder = ListViewHolder(
        RowItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindItem(listWisataku[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.WISATAKU_DATA, listWisataku[position])
            it.context.startActivity(intent)
            }
        }

    override fun getItemCount(): Int = listWisataku.size
}