package net.bot.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public interface Menu {

    void openInventory(@NotNull Player player);

    Inventory getInventory();

    MenuData getMenuData();
}
