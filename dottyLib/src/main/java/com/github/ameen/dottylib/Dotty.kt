package com.github.ameen.dottylib

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

class Dotty @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var dottyCount: Int = 0
    private var selectedPosition: Int = 0

    init {
        initDotty(context, attrs)
    }

    @SuppressLint("CustomViewStyleable")
    private fun initDotty(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {

            val attributeArray = context.obtainStyledAttributes(attrs, R.styleable.DottyLayout)

            try {
                dottyCount = attributeArray.getInt(R.styleable.DottyLayout_dotty_count, 3)
            } finally {
                attributeArray.recycle()
            }
            updateIndicators()
        }
    }

    private fun px(dpValue: Float): Int {
        return (dpValue * context.resources.displayMetrics.density).toInt()
    }

    @SuppressLint("ResourceType")
    private fun updateIndicators() {
        removeAllViews()
        for (i in 0 until dottyCount) {
            val indicator = View(context)
            // setting indicator layout margin
            val layoutParams = LayoutParams(px(10f), px(10f))
            layoutParams.setMargins(px(3f), px(3f), px(3f), px(3f))
            indicator.layoutParams = layoutParams
            indicator.setBackgroundResource(R.drawable.default_drawable)
            // add the view to indicator layout
            addView(indicator)
        }
    }

    fun setIndicatorCount(count: Int) {
        dottyCount = count
        updateIndicators()
    }

    @SuppressLint("ResourceType")
    fun selectCurrentPosition(position: Int) {
        if (position in 0..dottyCount) {
            selectedPosition = position
            for (index in 0 until dottyCount) {
                val indicator = getChildAt(index)
                if (index == selectedPosition) {
//                    indicator.setBackgroundResource(R.drawable.default_drawable)
                    indicator.setBackgroundResource(R.styleable.DottyLayout_dotty_selected)
                } else {
//                    indicator.setBackgroundResource(R.drawable.default_drawable)
                    indicator.setBackgroundResource(R.styleable.DottyLayout_dotty_un_selected)
                }
            }
        }
    }
}