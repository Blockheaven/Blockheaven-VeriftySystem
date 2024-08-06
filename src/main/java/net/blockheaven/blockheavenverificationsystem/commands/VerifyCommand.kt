package net.blockheaven.blockheavenverificationsystem.commands

import net.blockheaven.blockheavenverificationsystem.dcapi.DiscordBotApiFecther
import net.blockheaven.blockheavenverificationsystem.lp.LPServiceWorker
import net.blockheaven.blockheavenverificationsystem.utils.Settings
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class VerifyCommand : CommandExecutor{
    override fun onCommand(commandseneder: CommandSender, command: Command, string: String, strings: Array<out String>?): Boolean {

        if (!(commandseneder is Player)) return true;
        val player = commandseneder
        if (strings!!.size != 1) {
            Settings().send("Verwende /verifiy <code>", player)
            return true
        }
        val code = strings[0]
        val group_name = LPServiceWorker().group_name(player)
        DiscordBotApiFecther("", "", code, group_name).sendVerifyRequest()
        return true
    }
}