package com.example.tinkoffnewsmvp

import android.view.ViewGroup
import androidx.core.text.parseAsHtml
import com.example.tinkoffnewsmvp.base.back.BackListener
import com.example.tinkoffnewsmvp.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.utils.baseInit
import com.example.tinkoffnewsmvp.view.*
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_news_details.view.*
import javax.inject.Inject
import javax.inject.Named

interface NewsDetailsView : CommonErrorView,
    TransparentProgress {

    fun showNewsDetails(newsContent: String)

    interface Presenter : BackListener

}

@ActivityScope
class NewsDetailsViewImpl @Inject constructor(
    @Named(EXTRA_NEWS_ID) private var newsId: String?,
    override val containerView: ViewGroup,
    presenter: NewsDetailsView.Presenter
) : NewsDetailsView,
    LayoutContainer,
    CommonErrorView by CommonErrorViewImpl(containerView.context),
    ToolbarContainer by ToolbarContainerImpl(containerView),
    TransparentProgress by TransparentProgressDelegate(containerView.context, presenter) {

    init {
        toolbar.baseInit(newsId) { presenter.onBackPressed() }
    }

    override fun showNewsDetails(newsContent: String) {
        containerView.newsContentTextView.text = newsContent.parseAsHtml()
    }

}