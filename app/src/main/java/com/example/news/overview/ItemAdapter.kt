package com.example.news.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.news.R
import com.example.news.databinding.ViewItemBinding
import com.example.news.domain.Article

class ItemAdapter(val listener: ArticleClickListener) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    var articleList: List<Article> = listOf()
        set(value) {
            field = value
            notifyItemRangeChanged(0, value.lastIndex)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.create(parent, listener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(articleList[position], position)

    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    class ItemViewHolder private constructor(
        private val binding: ViewItemBinding,
        val listener: ArticleClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Article, position: Int) {
            binding.textArticle.text = item.title
            binding.root.setOnClickListener {
                listener.onItemClick(position)
            }
        }


        companion object {
            fun create(parent: ViewGroup, listener: ArticleClickListener): ItemViewHolder =
                ItemViewHolder(
                    ViewItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), listener
                )

        }

    }


}

interface ArticleClickListener {
    fun onItemClick(position: Int)

}