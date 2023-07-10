package net.bot.menu.impl;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.bot.menu.MenuData;
import net.bot.menu.MenuType;
import net.bot.menu.button.Button;
import net.bot.menu.filling.FillData;
import org.bukkit.ChatColor;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

@Data @Accessors(chain = true)
public class MenuDataImpl implements MenuData {

    private String title;
    private int slots;
    private boolean clickable;

    private MenuType menuType;

    @Getter(AccessLevel.NONE)
    private FillData fillData;

    @Getter(AccessLevel.NONE)
    private Consumer<InventoryOpenEvent> openAction;

    @Getter(AccessLevel.NONE)
    private Consumer<InventoryCloseEvent> closeAction;

    private Map<Integer, Button> buttonMap;

    public MenuDataImpl() {
        menuType = MenuType.DEFAULT;
        buttonMap = new HashMap<>();
    }

    public MenuDataImpl setTitle(@NotNull String title) {
        if (title.length() > 32) title = title.substring(0, 16);

        this.title = ChatColor.translateAlternateColorCodes('&', title);
        return this;
    }

    @Override
    public MenuData addButton(int slot, Button button) {
        buttonMap.put(slot - 1, button);
        return this;
    }

    @Override
    public MenuData removeButton(int slot) {
        buttonMap.remove(slot);
        return this;
    }

    @Override
    public Optional<FillData> getFillData() {
        return Optional.ofNullable(fillData);
    }

    @Override
    public Optional<Consumer<InventoryOpenEvent>> getOpenAction() {
        return Optional.ofNullable(openAction);
    }

    @Override
    public Optional<Consumer<InventoryCloseEvent>> getCloseAction() {
        return Optional.ofNullable(closeAction);
    }
}
