package com.example.tinkoffnewsmvp.core_ui.view

import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.toolbar_without_shadow.view.*

interface ToolbarContainer {

    val toolbar: Toolbar

}

class ToolbarContainerImpl(
    override val containerView: ViewGroup
) : LayoutContainer,
    ToolbarContainer {

    override val toolbar: Toolbar
        get() = containerView.toolbarView

}