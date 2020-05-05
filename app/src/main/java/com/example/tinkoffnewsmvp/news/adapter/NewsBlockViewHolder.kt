package com.example.tinkoffnewsmvp.news.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoffnewsmvp.core.dto.news.NewsBlock
import kotlinx.android.synthetic.main.item_news_block.view.*

interface NewsCallback {

    fun onNewsViewHolderClicked(id: String)

}

class NewsBlockViewHolder(
    private val view: View,
    private val callback: NewsCallback
) : RecyclerView.ViewHolder(view) {

    fun bind(newsBlock: NewsBlock) {
        view.newsTextView.text = newsBlock.text
        view.setOnClickListener {
            Log.d(this.javaClass.name, "newsId=${newsBlock.id}")
            callback.onNewsViewHolderClicked(newsBlock.id)
        }
    }

}