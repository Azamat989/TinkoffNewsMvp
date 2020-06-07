package com.example.tinkoffnewsmvp.base

import android.net.http.SslCertificate.restoreState
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tinkoffnewsmvp.base.coroutines.ProgressCoroutineJobDelegate
import com.example.tinkoffnewsmvp.base.coroutines.ProgressCoroutineJobDelegateImpl
import com.example.tinkoffnewsmvp.utils.getContentView
import com.example.tinkoffnewsmvp.view.utils.hideKeyboard
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(),
    HasAndroidInjector,
    ProgressCoroutineJobDelegate by ProgressCoroutineJobDelegateImpl() {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>

    private val contentView: View by lazy { getContentView() }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        savedInstanceState?.let { restoreState(it) }
    }

    override fun onStart() {
        super.onStart()
        initializeCoroutineJob()
    }

    override fun onStop() {
        super.onStop()
        cancelCoroutineJob()
    }

    override fun onDestroy() {
        super.onDestroy()
        cancelCoroutineJob()
    }

    override fun androidInjector(): AndroidInjector<Any> = injector

    /**
     * Хак решает проблему возвращения с экрана с открытой клавиатурой.
     * При открытой клавиатуре и вызове finish() контент и другие элементы на предыдущей
     * активити могут прыгать и вести себя непредсказуемо.
     * Основано на задачах: MVNO-6163, MVNO-6321, MVNO-6827, MVNO-7730
     */
    private fun preventUglyReturnWithKeyboard() {
        contentView.clearFocus()
        contentView.hideKeyboard()
    }

}