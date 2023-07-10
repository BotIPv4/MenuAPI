package net.bot.menu;

import net.bot.menu.button.Button;
import net.bot.menu.filling.FillData;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public interface MenuData {

    String getTitle();

    int getSlots();

    boolean isClickable();

    Optional<Consumer<InventoryOpenEvent>> getOpenAction();

    Optional<Consumer<InventoryCloseEvent>> getCloseAction();

    MenuType getMenuType();

    Optional<FillData> getFillData();

    MenuData addButton(int slot, Button button);

    MenuData removeButton(int slot);

    Map<Integer, Button> getButtonMap();
}
