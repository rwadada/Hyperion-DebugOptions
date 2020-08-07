package com.rwadada.hyperion.plugin.debugoptions

interface ItemRow {
    val title: String
}

interface SectioningItem : ItemRow

interface MenuItem : ItemRow {
    fun onClickItem()
}
