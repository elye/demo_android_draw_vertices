package com.elyeproj.demoandroiddrawvertices

import android.content.Intent
import android.graphics.Canvas
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_triangles.setOnClickListener {
            val mode = Canvas.VertexMode.TRIANGLES
            openDrawVerticesActivity(mode)
        }
        btn_triangle_fan.setOnClickListener {
            val mode = Canvas.VertexMode.TRIANGLE_FAN
            openDrawVerticesActivity(mode)
        }
        btn_triangle_strip.setOnClickListener {
            val mode = Canvas.VertexMode.TRIANGLE_STRIP
            openDrawVerticesActivity(mode)
        }
    }

    private fun openDrawVerticesActivity(mode: Canvas.VertexMode) {
        val intent = Intent(this, DrawVerticesActivity::class.java)
        intent.putExtra(DrawVerticesActivity.TRIANGLE_MODE_KEY, mode)
        startActivity(intent)
    }
}
