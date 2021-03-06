package com.example.tinkoffnewsmvp

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.tinkoffnewsmvp.adapter.NewsCallback
import com.example.tinkoffnewsmvp.base.BaseRouter
import com.example.tinkoffnewsmvp.base.mvp.BasePresenter
import com.example.tinkoffnewsmvp.base.mvp.Presenter
import com.example.tinkoffnewsmvp.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.dto.news.NewsBlock
import com.example.tinkoffnewsmvp.utils.coroutines.tryLaunch
import com.example.tinkoffnewsmvp.view.SwipeRefreshView
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