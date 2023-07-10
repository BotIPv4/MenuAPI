package net.bot.menu.button.impl;

import net.bot.menu.button.Button;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class AirButton extends Button {
    
    public AirButton() {
        setItemStack(new ItemStack(Material.AIR));
        setAction(event -> {});
    }
}
