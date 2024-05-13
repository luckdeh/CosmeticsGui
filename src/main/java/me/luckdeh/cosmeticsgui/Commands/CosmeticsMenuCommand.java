package me.luckdeh.cosmeticsgui.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CosmeticsMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (sender instanceof Player p){
            Inventory cosmetics = Bukkit.createInventory(p, 27, ChatColor.AQUA + "Cosmetics Menu");

            ItemStack red = new ItemStack(Material.RED_DYE);
            ItemStack black = new ItemStack(Material.BLACK_DYE);
            ItemStack purple = new ItemStack(Material.PURPLE_DYE);
            ItemStack blue = new ItemStack(Material.BLUE_DYE);
            ItemStack aqua = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack green = new ItemStack(Material.GREEN_DYE);


            cosmetics.setItem(2, aqua);
            cosmetics.setItem(0, blue);
            cosmetics.setItem(12, red);
            cosmetics.setItem(14, black);
            cosmetics.setItem(10, purple);
            cosmetics.setItem(16, green);

            p.openInventory(cosmetics);


        }


        return true;
    }
}
