package net.blockheaven.blockheavenverificationsystem.lp

import net.luckperms.api.LuckPerms
import net.luckperms.api.LuckPermsProvider
import net.luckperms.api.model.group.Group
import org.bukkit.entity.Player

class LPServiceWorker() {

    private val luckperms : LuckPerms

    init {
        luckperms = LuckPermsProvider.get()
    }

    fun group_name(player : Player) : String {
        if (primary_group(player) == null) return "spieler"
        return primary_group(player)!!.name
    }

    fun primary_group(player: Player) : Group? {
        return luckperms.userManager.getUser(player.uniqueId)?.let { luckperms.groupManager.getGroup(it.primaryGroup) }
    }

}