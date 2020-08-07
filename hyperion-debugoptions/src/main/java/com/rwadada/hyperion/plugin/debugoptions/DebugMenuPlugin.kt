package com.rwadada.hyperion.plugin.debugoptions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.auto.service.AutoService
import com.willowtreeapps.hyperion.plugin.v1.Plugin
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

@Suppress("unused")
@AutoService(Plugin::class)
class DebugMenuPlugin : Plugin() {
    override fun createPluginModule(): PluginModule? {
        return DebugMenuPluginModule()
    }
}

class DebugMenuPluginModule : PluginModule() {
    override fun createPluginView(layoutInflater: LayoutInflater, parent: ViewGroup): View? =
        layoutInflater.inflate(R.layout.layout_debug_menu_button, parent, false).also {
            it.setOnClickListener {
                context.startActivity(DebugMenuActivity.intent(context))
            }
        }
}
