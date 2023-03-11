package com.unongmilk.reinforce.gui

import com.unongmilk.reinforce.system.rf
import com.unongmilk.reinforce.util.*
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

object Gui : Listener {
    fun getInventory() : Inventory {
        return makeInventory("강화하기 Reinforcing").setAir(4, 40).set(53, ItemStack(Material.IRON_AXE).setDamage(9).noDamage())
    }

    @EventHandler
    fun onClick(event : InventoryClickEvent) {
        val p = event.whoClicked as Player
        if (event.clickedInventory != null) {
            val inv = event.clickedInventory
            val slot = event.slot
            if (inv.title == "강화하기 Reinforcing") {
                if (slot == 22) {
                    event.isCancelled = true
                    inv.setItem(22, rf(inv.getItem(22), p))
                } else if (!arrayListOf(4, 22, 40).contains(slot)) {
                    event.isCancelled = true
                }
            }
        }
    }
}