package net.bot.menu.filling;

import net.bot.menu.Menu;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public enum FillType {

    BORDERS {
        @Override
        public void applyFill(Menu menu, ItemStack itemStack) {
            Inventory inventory = menu.getInventory();
            int size = inventory.getSize();

            for (int i = 0; i < size; i++) {
                if (i < 9 || i >= size - 9 || i % 9 == 0 || i % 9 == 8) {
                    if (inventory.getItem(i) == null) inventory.setItem(i, itemStack);
                }
            }
        }
    },

    EMPTY_SLOTS {
        @Override
        public void applyFill(Menu menu, ItemStack itemStack) {
            Inventory inventory = menu.getInventory();

            for (int i = 0; i < inventory.getSize(); i++) {
                if (inventory.getItem(i) == null) inventory.setItem(i, itemStack);
            }
        }
    };

    public abstract void applyFill(Menu menu, ItemStack itemStack);
}
