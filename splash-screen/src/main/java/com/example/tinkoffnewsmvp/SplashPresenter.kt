package com.example.tinkoffnewsmvp

import com.example.tinkoffnewsmvp.base.BaseRouter
import com.example.tinkoffnewsmvp.base.mvp.BasePresenter
import com.example.tinkoffnewsmvp.base.mvp.Presenter
import com.example.tinkoffnewsmvp.dependencies.ActivityScope
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