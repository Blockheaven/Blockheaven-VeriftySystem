package net.blockheaven.blockheavenverificationsystem

import net.blockheaven.blockheavenverificationsystem.commands.VerifyCommand
import org.bukkit.plugin.java.JavaPlugin

class Blockheaven_VerificationSystem : JavaPlugin() {

    override fun onEnable() {
        getCommand("verfiy")?.setExecutor(VerifyCommand())
    }

    override fun onDisable() {

    }
}
