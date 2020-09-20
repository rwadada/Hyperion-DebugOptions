package com.rwadada.hyperion.plugin.debugoptions

import android.content.Context

interface ItemRow {
    val title: String
}

interface SectioningItem : ItemRow

interface MenuItem : ItemRow {
    fun onClickItem(context: Context)
}
