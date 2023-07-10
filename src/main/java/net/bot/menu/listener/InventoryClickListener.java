package net.bot.menu.listener;

import lombok.AllArgsConstructor;
import net.bot.menu.Menu;
import net.bot.menu.MenuData;
import net.bot.menu.button.Button;
import net.bot.menu.MenuHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Optional;

@AllArgsConstructor
public class InventoryClickListener implements Listener {

    private final MenuHandler menuHandler;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Optional<Menu> optionalMenu = menuHandler.getOptionalMenu(event.getWhoClicked().getUniqueId());
        if (!optionalMenu.isPresent()) return;

        Menu menu = optionalMenu.get();

        if (!event.getInventory().getTitle().equals(menu.getInventory().getTitle())) return;

        MenuData menuData = menu.getMenuData();
        Button button = menuData.getButtonMap().get(event.getSlot());

        if (button != null) button.getAction().accept(event);
        if (!menuData.isClickable()) event.setCancelled(true);
    }
}
