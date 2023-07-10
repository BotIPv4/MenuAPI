package net.bot.menu.button;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

@NoArgsConstructor
@AllArgsConstructor
@Data @Accessors(chain = true)
public class Button {

    @NotNull
    private ItemStack itemStack;
    private Consumer<InventoryClickEvent> action;
}