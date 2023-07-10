package net.bot.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

@Getter @AllArgsConstructor
public enum MenuType {

    DEFAULT(null) {
        @Override
        public Inventory createMenu(@NotNull MenuData menuData) {
            return Bukkit.createInventory(null, menuData.getSlots() * 9, menuData.getTitle());
        }
    },
    DROPPER(InventoryType.DROPPER),
    CHEST(InventoryType.CHEST),
    HOPPER(InventoryType.HOPPER),
    FURNACE(InventoryType.FURNACE),
    CRAFTING(InventoryType.CRAFTING),
    WORKBENCH(InventoryType.WORKBENCH);

    private final InventoryType inventoryType;

    public Inventory createMenu(@NotNull MenuData menuData) {
        return Bukkit.createInventory(null, inventoryType, menuData.getTitle());
    }
}
