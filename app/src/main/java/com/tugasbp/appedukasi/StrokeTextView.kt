package com.tugasbp.appedukasi

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class StrokeTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val strokePaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        strokeWidth = 6f // Stroke weight (3dp -> 6f because it's in pixels)
        color = Color. #83822C // Stroke color
    }

    private val textPaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL
        color = Color.YELLOW // Fill color for the text
    }

    override fun onDraw(canvas: Canvas) {
        val text = text.toString()
        val x = (width - textPaint.measureText(text)) / 2
        val y = (height - textPaint.descent() - textPaint.ascent()) / 2

        // Draw stroke first (outside effect achieved by increasing stroke width)
        canvas.drawText(text, x, y, strokePaint)

        // Draw the main text (fill)
        canvas.drawText(text, x, y, textPaint)
    }
}
