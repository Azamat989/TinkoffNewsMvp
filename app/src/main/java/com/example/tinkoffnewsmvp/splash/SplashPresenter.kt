package com.example.tinkoffnewsmvp.splash

import com.example.tinkoffnewsmvp.core_ui.base.BaseRouter
import com.example.tinkoffnewsmvp.core_ui.base.mvp.BasePresenter
import com.example.tinkoffnewsmvp.core_ui.base.mvp.Presenter
import com.example.tinkoffnewsmvp.core_ui.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.utils.coroutines.tryLaunch
import javax.inject.Inject

interface SplashPresenter : Presenter {

    interface Router : BaseRouter {

        fun moveToNews()

    }

}

@ActivityScope
class SplashPresenterImpl @Inject constructor(
    private val interactor: SplashInteractor
) : BasePresenter<SplashPresenter.Router, SplashView>(),
    SplashPresenter,
    SplashView.Presenter {

    override fun onStart() {
        tryLaunch({
            view.showLoading()
            interactor.uploadNewsAndSave()
            showNews()
        }, {
            handleWithDialog()
        })
    }

    private fun showNews() {
        router.moveToNews()
        router.finish()
    }

}