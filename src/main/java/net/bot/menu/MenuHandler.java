package net.bot.menu;

import net.bot.menu.item.ItemCreator;
import net.bot.menu.listener.InventoryClickListener;
import net.bot.menu.listener.InventoryCloseListener;
import net.bot.menu.listener.InventoryOpenListener;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.*;

public class MenuHandler {

    private final Map<UUID, Menu> menuMap;

    public MenuHandler(JavaPlugin plugin) {
        menuMap = new HashMap<>();

        registerGlowEnchant();
        Arrays.asList(
                new InventoryClickListener(this),
                new InventoryCloseListener(this),
                new InventoryOpenListener(this)
        ).forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, plugin));
    }

    private void registerGlowEnchant() {
        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");

            field.setAccessible(true);
            field.set(null, true);

            Enchantment.registerEnchantment(new ItemCreator.Glow());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Menu register(UUID id, Menu menu) {
        getOptionalMenu(id).ifPresent(oldMenu -> unregister(id));
        menuMap.put(id, menu);
        return menu;
    }

    public void unregister(UUID id) {
        if (!getOptionalMenu(id).isPresent()) return;
        menuMap.remove(id);
    }

    public Optional<Menu> getOptionalMenu(UUID id) {
        return Optional.ofNullable(menuMap.get(id));
    }
}
