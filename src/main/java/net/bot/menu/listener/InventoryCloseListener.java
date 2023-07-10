package net.bot.menu.listener;

import lombok.AllArgsConstructor;
import net.bot.menu.Menu;
import net.bot.menu.MenuHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class InventoryCloseListener implements Listener {

    private final MenuHandler menuHandler;

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        UUID id = event.getPlayer().getUniqueId();

        Optional<Menu> optionalMenu = menuHandler.getOptionalMenu(id);
        if (!optionalMenu.isPresent()) return;

        Menu menu = optionalMenu.get();

        if (!event.getInventory().getTitle().equals(menu.getInventory().getTitle())) return;
        menu.getMenuData().getCloseAction().ifPresent(consumer -> consumer.accept(event));
        menuHandler.unregister(id);
    }
}
