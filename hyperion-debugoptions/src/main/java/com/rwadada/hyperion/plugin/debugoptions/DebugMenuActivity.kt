package com.rwadada.hyperion.plugin.debugoptions

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class DebugMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug_menu)

        val adapter = DebugMenuAdapter()
        findViewById<RecyclerView>(R.id.recycler).adapter = adapter
    }

    companion object {
        fun intent(context: Context) = Intent(context, DebugMenuActivity::class.java)
    }
}
