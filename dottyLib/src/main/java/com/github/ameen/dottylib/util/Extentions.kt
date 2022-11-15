package com.github.ameen.dottylib.util

import android.content.Context

/**
 * Convert Float Value to Pixels.
 * @param context current view Context.
 * @return floatPx.
 */
fun Float.toPx(context: Context): Int {
    return (this * context.resources.displayMetrics.density).toInt()
}