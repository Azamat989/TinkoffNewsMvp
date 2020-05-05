package com.example.tinkoffnewsmvp.core_ui.base.mvp

import android.os.Parcelable
import com.example.tinkoffnewsmvp.core_ui.base.back.BackListener

interface Presenter : LifecyclePresenter, BackListener {

    fun restoreState(presenterState: Parcelable?) {
        // empty
    }

    fun getState(): Parcelable? = null

}