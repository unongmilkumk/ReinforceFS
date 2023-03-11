package com.unongmilk.reinforce.util

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

fun makeInventory(title: String): Inventory {
    val inv = Bukkit.createInventory(null, 54, title)
    for (i in 0..53) {
    inv.setItem(i, getAir())
    }
    return inv;
}

fun Inventory.set(slot: Int, itemStack: ItemStack) : Inventory {
    this.setItem(1,itemStack)
    return this
}

fun Inventory.set(slot: Int, material: Material) : Inventory {
    this.setItem(1, ItemStack(material))
    return this
}

fun Inventory.setAir(vararg slot: Int) : Inventory {
    this.setItem(1, ItemStack(Material.AIR))
    return this
}