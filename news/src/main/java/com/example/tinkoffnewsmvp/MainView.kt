package com.example.tinkoffnewsmvp

import android.util.Log
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.tinkoffnewsmvp.adapter.NewsAdapter
import com.example.tinkoffnewsmvp.base.back.BackListener
import com.example.tinkoffnewsmvp.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.dto.news.NewsBlock
import com.example.tinkoffnewsmvp.utils.baseInit
import com.example.tinkoffnewsmvp.utils.context
import com.example.tinkoffnewsmvp.utils.getTag
import com.example.tinkoffnewsmvp.view.*
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
        containerView.newsRecyclerView.adapter = adapter

    }

    override fun showNews(news: LiveData<PagedList<NewsBlock>>) {
        news.observe(context as MainActivity, Observer {
            Log.d(getTag(), "get new PagedList = $it")
            adapter.submitList(it)
        })
    }

}