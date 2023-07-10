package net.bot.menu.button.impl;

import net.bot.menu.button.Button;
import net.bot.menu.item.ItemCreator;
import org.bukkit.Material;

public class CloseButton extends Button {

    public CloseButton() {
        setItemStack(new ItemCreator(Material.REDSTONE)
                .setDisplayName("&cClose")
                .create());
        setAction(event -> event.getWhoClicked().closeInventory());
    }
}
