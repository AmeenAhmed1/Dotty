package com.github.ameen.dottylib

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.github.ameen.dottylib.util.*

class Dotty @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var dottyCount: Int = 0
    private var selectedPosition: Int = 0
    private var dottySize: Float = 0f
    private var dottySpaceBetween: Float = 0f
    private var dottySelectedDrawable: Drawable? = null
    private var dottyUnSelectedDrawable: Drawable? = null

    init {
        initDotty(context, attrs)
    }

    @SuppressLint("CustomViewStyleable", "UseCompatLoadingForDrawables")
    private fun initDotty(context: Context, attrs: AttributeSet?) {

        val attributeArray = context.obtainStyledAttributes(attrs, R.styleable.DottyLayout)

        dottyCount = attributeArray.getInt(R.styleable.DottyLayout_dottyCount, defaultDotCount)

        dottySpaceBetween =
            attributeArray.getDimension(
                R.styleable.DottyLayout_dottySpaceBetweenSize,
                defaultDotSpaceBetween
            )

        dottySize =
            attributeArray.getDimension(R.styleable.DottyLayout_dottySize, defaultDotSize)

        selectedPosition = attributeArray.getInt(
            R.styleable.DottyLayout_dottyStartPosition,
            defaultSelectedPosition
        )

        dottySelectedDrawable =
            attributeArray.getDrawable(R.styleable.DottyLayout_dottySelected)
                ?: context.resources.getDrawable(R.drawable.default_selected_drawable, null)

        dottyUnSelectedDrawable =
            attributeArray.getDrawable(R.styleable.DottyLayout_dottyUnSelected)
                ?: context.resources.getDrawable(R.drawable.default_drawable, null)


        attributeArray.recycle()

        updateIndicators()

    }


    @SuppressLint("ResourceType")
    private fun updateIndicators() {
        removeAllViews()
        for (i in 0 until dottyCount) {
            val indicator = View(context)
            // setting indicator layout margin
            val layoutParams = LayoutParams(dottySize.toPx(context), dottySize.toPx(context))
            layoutParams.setMargins(
                dottySpaceBetween.toPx(context), //Left
                0f.toPx(context), //Top
                dottySpaceBetween.toPx(context), //Right
                0f.toPx(context)  //Bottom
            )
            indicator.layoutParams = layoutParams
            indicator.background = dottyUnSelectedDrawable
            // add the view to indicator layout
            addView(indicator)
        }

        selectPosition()
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
                    indicator.background = dottySelectedDrawable
                } else {
//                    indicator.setBackgroundResource(R.drawable.default_drawable)
                    indicator.background = dottyUnSelectedDrawable
                }
            }
        }
    }

    @SuppressLint("ResourceType")
    fun selectPosition() {
        if (selectedPosition in 0 until dottyCount) {
            val indicator = getChildAt(selectedPosition)
            indicator.background = (dottySelectedDrawable)
        } else {
            val indicator = getChildAt(dottyCount - 1)
            indicator.background = (dottySelectedDrawable)
        }
    }
}