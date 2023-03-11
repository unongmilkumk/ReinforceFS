package com.unongmilk.reinforce.util

import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

fun makeItem(material : Material, name : String, vararg description : String) : ItemStack {
    return ItemStack(material).setName(name).setDescription(*description).noDamage()
}

fun ItemStack.noDamage(): ItemStack {
    val i = this
    val im = i.itemMeta
    im.isUnbreakable = true
    im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
    i.itemMeta = im
    return i
}

fun ItemStack.setName(name: String): ItemStack {
    val i = this
    val im = this.itemMeta
    im.displayName = name
    i.itemMeta = im
    return i
}

fun ItemStack.setDescription(vararg description : String) : ItemStack {
    val i = this.itemMeta
    i.lore = description.toMutableList()
    this.itemMeta = i
    return this
}

fun ItemStack.setDescription(place: Int, string: String) : ItemStack {
    val i = this.itemMeta
    i.lore[place] = string
    this.itemMeta = i
    return this
}

fun getAir() : ItemStack {
    return ItemStack(Material.IRON_AXE, 1, 64.toShort()).noDamage()
}

fun ItemStack.setDamage(damage : Int) : ItemStack {
    this.durability = damage.toShort()
    return this
}

fun ItemStack.getName() : String {
    return this.itemMeta.displayName
}