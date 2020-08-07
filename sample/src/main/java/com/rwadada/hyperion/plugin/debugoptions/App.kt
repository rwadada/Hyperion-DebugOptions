package com.rwadada.hyperion.plugin.debugoptions

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DebugMenu.items.add(
            object : MenuItem {
                override val title: String
                    get() = "Test"

                override fun onClickItem() {
                    println("Hoge")
                }
            }
        )
    }
}
