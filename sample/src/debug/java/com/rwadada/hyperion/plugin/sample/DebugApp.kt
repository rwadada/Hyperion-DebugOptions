package com.rwadada.hyperion.plugin.sample

import com.rwadada.hyperion.plugin.debugoptions.DebugMenu
import com.rwadada.hyperion.plugin.debugoptions.MenuItem
import com.rwadada.hyperion.plugin.debugoptions.SectioningItem

class DebugApp : App() {
    override fun onCreate() {
        super.onCreate()

        DebugMenu.items.addAll(listOf(
            object : SectioningItem {
                override val title: String
                    get() = "Section"
            },
            object : MenuItem {
                override val title: String
                    get() = "Test1"

                override fun onClickItem() {
                    println("Hoge")
                }
            },
            object : MenuItem {
                override val title: String
                    get() = "Test2"

                override fun onClickItem() {
                    println("Hoge")
                }
            },
            object : MenuItem {
                override val title: String
                    get() = "Test3"

                override fun onClickItem() {
                    println("Hoge")
                }
            },
            object : MenuItem {
                override val title: String
                    get() = "Test4"

                override fun onClickItem() {
                    println("Hoge")
                }
            }
        ))
    }
}
