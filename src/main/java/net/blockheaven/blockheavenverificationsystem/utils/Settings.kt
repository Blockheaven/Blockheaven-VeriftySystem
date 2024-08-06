package net.blockheaven.blockheavenverificationsystem.utils

import org.bukkit.entity.Player

class Settings {

    val prefix = "§9§lBlockHeaven §8 • §7"

    fun send(msg: String, player: Player) {
        player.sendMessage("$prefix$msg")
    }

}