package net.bot.menu.filling.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bot.menu.filling.FillData;
import net.bot.menu.filling.FillType;
import org.bukkit.inventory.ItemStack;

@Data @NoArgsConstructor @AllArgsConstructor
public class FillDataImpl implements FillData {

    private FillType fillType;
    private ItemStack fillItem;
}
