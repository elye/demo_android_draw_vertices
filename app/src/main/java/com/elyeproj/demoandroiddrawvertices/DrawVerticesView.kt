package com.elyeproj.demoandroiddrawvertices

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class DrawVerticesView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val paint = Paint()

    var triangleMode = Canvas.VertexMode.TRIANGLES

    private val verts = mutableListOf<Float>()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)

        val vColor = listOf(
            0xFF080000, 0xFF0F0000, 0xFF180000, 0xFF1F0000, 0xFF280000, 0xFF2F0000, 0xFF380000, 0xFF3F0000,
            0xFF480000, 0xFF4F0000, 0xFF580000, 0xFF5F0000, 0xFF680000, 0xFF6F0000, 0xFF780000, 0xFF7F0000,
            0xFF880000, 0xFF8F0000, 0xFF980000, 0xFF9F0000, 0xFFA80000, 0xFFAF0000, 0xFFB80000, 0xFFBF0000,
            0xFFC80000, 0xFFCF0000, 0xFFD80000, 0xFFDF0000, 0xFFE80000, 0xFFEF0000, 0xFFF80000, 0xFFFF0000,
            -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000,
            -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000,
            -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000,
            -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000,
            -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000, -0x1000000
        )

        canvas.drawVertices(
            triangleMode,
            verts.size, verts.toFloatArray(), 0,
            null, 0, vColor.map { it.toInt() }.toIntArray(), 0,
            null, 0, 0,
            paint
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val pointerIndex = event.actionIndex

        if (verts.size >= 64) {
            Toast.makeText(context, "Hit maximum 64 coordinates", Toast.LENGTH_SHORT).show()
            return false
        }

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_POINTER_DOWN -> return true
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_POINTER_UP -> {
                verts.add(event.getX(pointerIndex))
                verts.add(event.getY(pointerIndex))
                invalidate()
                return true
            }
        }
        return super.onTouchEvent(event)
    }
}
