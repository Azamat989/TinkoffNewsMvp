package com.example.tinkoffnewsmvp.news

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.tinkoffnewsmvp.core_ui.base.BaseRouter
import com.example.tinkoffnewsmvp.core_ui.base.mvp.BasePresenter
import com.example.tinkoffnewsmvp.core_ui.base.mvp.Presenter
import com.example.tinkoffnewsmvp.core_ui.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.core_ui.view.SwipeRefreshView
import com.example.tinkoffnewsmvp.dto.news.NewsBlock
import com.example.tinkoffnewsmvp.news.adapter.NewsCallback
import com.example.tinkoffnewsmvp.utils.coroutines.tryLaunch
import javax.inject.Inject

interface MainActivityPresenter : Presenter {

    interface Router : BaseRouter {

        fun moveToNewsDetails(newsId: String)

    }

}

@ActivityScope
class MainActivityPresenterImpl @Inject constructor(
    private val interactor: NewsInteractor
) : BasePresenter<MainActivityPresenter.Router, MainView>(),
    MainActivityPresenter,
    MainView.Presenter,
    SwipeRefreshView.Presenter,
    NewsCallback {

    private var newsLiveData: LiveData<PagedList<NewsBlock>>? = null

    override fun onStart() {
        uploadNews()
    }

    override fun onSwipeRefresh() {
        tryLaunch(
            {
                interactor.refreshNews()
                uploadNews()
            },
            { handleWithDialog("Try again") },
            { view.onRefreshComplete() }
        )
    }

    private fun uploadNews() {
        tryLaunch(
            {
                if (newsLiveData?.value.isNullOrEmpty()) newsLiveData =
                    interactor.getNewsPagedList()
                newsLiveData?.let { view.showNews(it) }
            },
            { handleWithDialog("Try again") }
        )
    }

    override fun onNewsViewHolderClicked(id: String) {
        router.moveToNewsDetails(id)
    }

}