package com.rwadada.hyperion.plugin.debugoptions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rwadada.hyperion.plugin.debugoptions.databinding.LayoutDebugMenuItemBinding
import com.rwadada.hyperion.plugin.debugoptions.databinding.LayoutDebugMenuSectioningBinding

class DebugMenuAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int = DebugMenu.items.size

    override fun getItemViewType(position: Int): Int {
        return when (DebugMenu.items[position]) {
            is SectioningItem -> ItemType.SECTIONING.type
            is MenuItem -> ItemType.DEBUG_MENU.type
            else -> throw IllegalArgumentException()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ItemType.resolve(viewType)) {
            ItemType.SECTIONING -> SectionVH.newInstance(parent)
            ItemType.DEBUG_MENU -> DebugMenuVH.newInstance(parent)
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val debugMenuItem = DebugMenu.items[position]
        when (ItemType.resolve(holder.itemViewType)) {
            ItemType.SECTIONING -> {
                if (debugMenuItem is SectioningItem && holder is SectionVH) {
                    holder.binding.title.text = debugMenuItem.title
                }
            }
            ItemType.DEBUG_MENU -> {
                if (debugMenuItem is MenuItem && holder is DebugMenuVH) {
                    holder.binding.title.text = debugMenuItem.title
                    holder.binding.base.setOnClickListener {
                        debugMenuItem.onClickItem()
                    }
                }
            }
        }
    }

    enum class ItemType(val type: Int) {
        SECTIONING(0),
        DEBUG_MENU(1);

        companion object {
            fun resolve(type: Int) = values().find { it.type == type }
        }
    }

    class SectionVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: LayoutDebugMenuSectioningBinding =
            LayoutDebugMenuSectioningBinding.bind(itemView)

        companion object {
            fun newInstance(parent: ViewGroup): SectionVH {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.layout_debug_menu_sectioning, parent, false)
                return SectionVH(view)
            }
        }
    }

    class DebugMenuVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: LayoutDebugMenuItemBinding = LayoutDebugMenuItemBinding.bind(itemView)

        companion object {
            fun newInstance(parent: ViewGroup): DebugMenuVH {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.layout_debug_menu_item, parent, false)
                return DebugMenuVH(view)
            }
        }
    }
}
