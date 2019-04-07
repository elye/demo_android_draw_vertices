package com.elyeproj.demoandroiddrawvertices

import android.graphics.Canvas
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_draw_vertices.*

class DrawVerticesActivity : AppCompatActivity() {

    companion object {
        const val TRIANGLE_MODE_KEY = "TriangleModeKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_vertices)
        with (intent.getSerializableExtra(TRIANGLE_MODE_KEY) as Canvas.VertexMode) {
            view_draw_vertices.triangleMode = this
            title = name
        }
    }
}
