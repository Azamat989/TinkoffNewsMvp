package com.example.tinkoffnewsmvp.news_details.dependencies

import android.app.Activity
import android.view.ViewGroup
import com.example.tinkoffnewsmvp.core_ui.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.core_ui.utils.getContentView
import com.example.tinkoffnewsmvp.news_details.EXTRA_NEWS_ID
import com.example.tinkoffnewsmvp.news_details.NewsDetailsActivity
import com.example.tinkoffnewsmvp.news_details.NewsDetailsPresenter
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Named

@ActivityScope
@Subcomponent(modules = [NewsDetailsModule::class])
interface NewsDetailsComponent : AndroidInjector<NewsDetailsActivity> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<NewsDetailsActivity> {

        override fun create(instance: NewsDetailsActivity): AndroidInjector<NewsDetailsActivity> =
            create(
                instance,
                instance,
                instance.getContentView(),
                instance.getExtraNewsId()
            )

        abstract fun create(
            @BindsInstance activity: Activity,
            @BindsInstance router: NewsDetailsPresenter.Router,
            @BindsInstance viewGroup: ViewGroup,
            @BindsInstance @Named(EXTRA_NEWS_ID) newsId: String?
        ): AndroidInjector<NewsDetailsActivity>

    }

}