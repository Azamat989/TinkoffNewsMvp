package com.example.tinkoffnewsmvp.view

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

interface SwipeRefreshView {

    fun onRefreshComplete()

    fun disableSwipeRefresh()

    fun enableSwipeRefresh()

    interface Presenter {

        fun onSwipeRefresh()

    }

}

class SwipeRefreshViewImpl(
    private val swipeLayout: SwipeRefreshLayout,
    val presenter: SwipeRefreshView.Presenter
) : SwipeRefreshView {

    init {
        swipeLayout.setOnRefreshListener { presenter.onSwipeRefresh() }
        swipeLayout.setupTopOffsetForLoaderView()
    }

    override fun onRefreshComplete() {
        swipeLayout.isRefreshing = false
    }

    override fun disableSwipeRefresh() {
        swipeLayout.isEnabled = false
    }

    override fun enableSwipeRefresh() {
        swipeLayout.isEnabled = true
    }

    /**
     * Устанавливает отступ снизу для индикатора прогресса от верхнего края.
     * Причина использоавния: при медленном свайпе вверх-вниз, индикатор не скрывается и его тень видна из-под верхнего края.
     * Задача с описанием бага: MVNO-6383
     */
    private fun SwipeRefreshLayout.setupTopOffsetForLoaderView() {
        val topOffset = 4
        setProgressViewOffset(
            false,
            progressViewStartOffset - topOffset,
            progressViewEndOffset
        )
    }

}