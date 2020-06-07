package com.example.tinkoffnewsmvp.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
import android.view.WindowManager.LayoutParams.MATCH_PARENT
import com.example.tinkoffnewsmvp.R
import com.example.tinkoffnewsmvp.base.back.BackListener

interface TransparentProgress {

    fun showTransparentProgress()
    fun hideTransparentProgress()
    fun asView(): View

}

class TransparentProgressDelegate(
    private val context: Context,
    private val backListener: BackListener? = null,
    private val isCancelable: Boolean = true
) : TransparentProgress {

    private var dialog: Dialog? = null

    override fun showTransparentProgress() {
        if (dialog != null) {
            return
        }
        dialog = Dialog(context).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.transparent_progress_bar)
            setCancelable(false)
            window?.setLayout(MATCH_PARENT, MATCH_PARENT)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.enableStatusBarDrawing()
            if (isCancelable) {
                setBackListener {
                    dismiss()
                    backListener?.onBackPressed()
                }
            }
            show()
        }
    }

    override fun hideTransparentProgress() {
        dialog?.dismiss()
        dialog = null
    }

    override fun asView(): View = checkNotNull(dialog?.findViewById(R.id.transparentProgressBar))

    private fun Window.enableStatusBarDrawing() {
        addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    }

}