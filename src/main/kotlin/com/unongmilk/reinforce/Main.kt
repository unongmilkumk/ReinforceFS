package com.unongmilk.reinforce

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        logger.info("Reinfoce Sucess +10")
    }

    override fun onDisable() {
        logger.info("Reinforce Failed -Broken-")
    }
}