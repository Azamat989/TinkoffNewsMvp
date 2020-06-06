package com.example.tinkoffnewsmvp.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.tinkoffnewsmvp.R
import com.example.tinkoffnewsmvp.dto.news.NewsBlock
import com.example.tinkoffnewsmvp.news.MainActivityPresenterImpl
import javax.inject.Inject

class NewsAdapter @Inject constructor(
    private val callback: MainActivityPresenterImpl
) : PagedListAdapter<NewsBlock, NewsBlockViewHolder>(diffUtilItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsBlockViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news_block, parent, false)

        return NewsBlockViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: NewsBlockViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {

        private val diffUtilItemCallback = object : DiffUtil.ItemCallback<NewsBlock>() {
            override fun areItemsTheSame(oldItem: NewsBlock, newItem: NewsBlock): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: NewsBlock, newItem: NewsBlock): Boolean =
                oldItem == newItem
        }
    }
}
