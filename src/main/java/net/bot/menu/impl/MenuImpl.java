package net.bot.menu.impl;

import lombok.Getter;
import net.bot.menu.Menu;
import net.bot.menu.MenuData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

@Getter
public class MenuImpl implements Menu {

    private final MenuData menuData;
    private final Inventory inventory;

    public MenuImpl(@NotNull MenuData data) {
        menuData = data;
        inventory = data.getMenuType().createMenu(data);
    }

    @Override
    public void openInventory(@NotNull Player player) {
        menuData.getButtonMap().forEach((slot, button) -> inventory.setItem(slot, button.getItemStack()));
        menuData.getFillData().ifPresent(fillData -> fillData.getFillType().applyFill(this, fillData.getFillItem()));

        player.openInventory(inventory);
    }
}
