package com.example.tinkoffnewsmvp.news

import android.util.Log
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoffnewsmvp.R
import com.example.tinkoffnewsmvp.core.dto.news.NewsBlock
import com.example.tinkoffnewsmvp.core_ui.CommonErrorView
import com.example.tinkoffnewsmvp.core_ui.CommonErrorViewImpl
import com.example.tinkoffnewsmvp.core_ui.base.back.BackListener
import com.example.tinkoffnewsmvp.core_ui.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.core_ui.utils.baseInit
import com.example.tinkoffnewsmvp.core_ui.utils.context
import com.example.tinkoffnewsmvp.core_ui.view.*
import com.example.tinkoffnewsmvp.news.adapter.NewsAdapter
import com.example.tinkoffnewsmvp.utils.logger.getTag
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.view.*
import javax.inject.Inject

interface MainView :
    CommonErrorView,
    SwipeRefreshView,
    TransparentProgress {

    fun showNews(news: LiveData<PagedList<NewsBlock>>)

    interface Presenter : BackListener

}

@ActivityScope
class MainViewImpl @Inject constructor(
    override val containerView: ViewGroup,
    private val adapter: NewsAdapter,
    presenter: MainView.Presenter,
    swipeRefreshView: SwipeRefreshView
) : MainView,
    LayoutContainer,
    CommonErrorView by CommonErrorViewImpl(containerView.context),
    TransparentProgress by TransparentProgressDelegate(containerView.context, presenter),
    SwipeRefreshView by swipeRefreshView,
    ToolbarContainer by ToolbarContainerImpl(containerView) {


    init {
        toolbar.baseInit(R.string.news_list_title)
        containerView.newsRecyclerView.layoutManager = LinearLayoutManager(context)
        containerView.newsRecyclerView.adapter = adapter

    }

    override fun showNews(news: LiveData<PagedList<NewsBlock>>) {
        news.observe(context as MainActivity, Observer {
            Log.d(getTag(), "get new PagedList = $it")
            adapter.submitList(it)
        })
    }

}