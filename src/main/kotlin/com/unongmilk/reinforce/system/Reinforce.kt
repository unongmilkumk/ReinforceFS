package com.unongmilk.reinforce.system

import com.unongmilk.reinforce.util.getName
import com.unongmilk.reinforce.util.random
import com.unongmilk.reinforce.util.setDescription
import com.unongmilk.reinforce.util.setName
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

fun ItemStack.findLevel() : Int {
    val a = this.itemMeta.displayName.split("+")
    return Integer.parseInt(a[a.size - 1])
}

fun ItemStack.findPercentage() : Double {
    return 100.0 - ( this.findLevel().toDouble() * 3.3 )
}

fun rf(itemStack: ItemStack, player: Player?) : ItemStack {
    if (random(0.0, 100.0) <= itemStack.findPercentage()) {
        itemStack.setDescription(4, (itemStack.itemMeta.lore[4].split(" ")[0]
            .toDouble() * 1.2).toString() + " 공격력").setName(itemStack.getName().split("+")[0] + " +" + itemStack.findLevel() + 1)
        player?.playSound(player.location, Sound.BLOCK_ENCHANTMENT_TABLE_USE, 2f, 1f)
    } else if (random(0.0, 100.0) <= 1.0 && itemStack.findLevel() >= 20 ) {
        itemStack.type = Material.AIR
        player?.playSound(player.location, Sound.BLOCK_ENCHANTMENT_TABLE_USE, 2f, 1f)
    } else {
        player?.playSound(player.location, Sound.ENTITY_ZOMBIE_BREAK_DOOR_WOOD, 2f, 1f)
    }
    return itemStack
}