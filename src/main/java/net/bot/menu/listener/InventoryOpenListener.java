package net.bot.menu.listener;

import lombok.AllArgsConstructor;
import net.bot.menu.MenuHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

@AllArgsConstructor
public class InventoryOpenListener implements Listener {

    private final MenuHandler menuHandler;

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        menuHandler.getOptionalMenu(event.getPlayer().getUniqueId())
                .flatMap(menu -> menu.getMenuData().getOpenAction())
                .ifPresent(consumer -> consumer.accept(event));
    }
}
