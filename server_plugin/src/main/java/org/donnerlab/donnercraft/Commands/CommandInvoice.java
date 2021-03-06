package org.donnerlab.donnercraft.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.donnerlab.donnercraft.DonnerCraftPlugin;

public class CommandInvoice implements CommandExecutor {

    DonnerCraftPlugin server;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args != null) {
                if(args.length != 2) {
                    player.sendMessage(ChatColor.RED + "wrond Command: use /invoice memo amt");
                } else {
                    String payReq = server.lndRpc.getPaymentRequest(args[1], Integer.parseInt(args[0]));
                    player.sendMessage(payReq);
                }
            }
        }
        return true;
    }

    public CommandInvoice(DonnerCraftPlugin server) {
        this.server = server;
    }

}
