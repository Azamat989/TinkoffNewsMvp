package com.example.tinkoffnewsmvp.news_details

import com.example.tinkoffnewsmvp.core_ui.base.BaseRouter
import com.example.tinkoffnewsmvp.core_ui.base.mvp.BasePresenter
import com.example.tinkoffnewsmvp.core_ui.base.mvp.Presenter
import com.example.tinkoffnewsmvp.core_ui.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.dto.newscontent.NewsContent
import javax.inject.Inject
import javax.inject.Named

interface NewsDetailsPresenter : Presenter {

    interface Router : BaseRouter

}

@ActivityScope
class NewsDetailsPresenterImpl @Inject constructor(
    @Named(EXTRA_NEWS_ID) private var newsId: String?,
    private val interactor: NewsDetailsInteractor
) : BasePresenter<NewsDetailsPresenter.Router, NewsDetailsView>(),
    NewsDetailsPresenter,
    NewsDetailsView.Presenter {

    private lateinit var newsDetails: NewsContent

    override fun onStart() {
        newsId?.let { uploadNewsDetails(it) }
    }

    private fun uploadNewsDetails(newsId: String) {
        view.tryLaunch({
            interactor.uploadNewsContent(newsId)?.let {
                newsDetails = it
                view.showNewsDetails(newsDetails.content)
            }

        }, {
            handleWithDialog("Something goes wrong. Please, try again.")
        })
    }


}