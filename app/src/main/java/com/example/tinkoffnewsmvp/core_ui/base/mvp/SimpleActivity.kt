package com.example.tinkoffnewsmvp.core_ui.base.mvp

import android.content.Intent
import android.os.Bundle
import com.example.tinkoffnewsmvp.core_ui.base.BaseActivity
import javax.inject.Inject

private const val PRESENTER_STATE = "PRESENTER_STATE"
const val NO_LAYOUT_ID = 0

abstract class SimpleActivity<P : Presenter> : BaseActivity() {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = getLayout()
        if (layout != NO_LAYOUT_ID) {
            setContentView(layout)
        }

    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onStop() {
        presenter.stop()
        super.onStop()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    override fun onNewIntent(intent: Intent?) {
        presenter.init()
        super.onNewIntent(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        presenter.init()
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        presenter.getState()
            ?.let { outState.putParcelable(PRESENTER_STATE, it) }
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    protected abstract fun getLayout(): Int

}