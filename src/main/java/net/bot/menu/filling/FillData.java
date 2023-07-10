package net.bot.menu.filling;

import org.bukkit.inventory.ItemStack;

public interface FillData {

    ItemStack getFillItem();

    FillType getFillType();
}
