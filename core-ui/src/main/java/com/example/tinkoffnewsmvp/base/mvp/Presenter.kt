package com.example.tinkoffnewsmvp.base.mvp

import android.os.Parcelable
import com.example.tinkoffnewsmvp.base.back.BackListener

interface Presenter : LifecyclePresenter, BackListener {

    fun restoreState(presenterState: Parcelable?) {
        // empty
    }

    fun getState(): Parcelable? = null

}