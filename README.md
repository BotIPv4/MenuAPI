# MenuAPI
**This is a MenuAPI made for Minecraft using the SpigotAPI.**

* Before you start creating menus you will need to register MenuHandler in the class that is extending JavaPlugin class.

```java
import net.bot.menu.MenuHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {

    private MenuHandler menuHandler;

    @Override
    public void onEnable() {
        menuHandler = new MenuHandler(this);
    }
}
```

* The easiest way to make a menu is shown in this example:**
```java
public void openExampleMenu(Player player) {
    Location location = player.getLocation();
    Menu menu = new MenuImpl(new MenuDataImpl()
        .setTitle("&bExample Menu")
        .setSlots(3)
        //.setMenuType(MenuType.<TYPE>) (this has MenuType#DEFAULT as default)
        .setOpenAction(event -> player.playSound(location, Sound.CHEST_OPEN, 10.0f, 10.0f))
        .setCloseAction(event -> player.playSound(location, Sound.CHEST_CLOSE, 10.0f, 10.0f))
        .setFillData(new FillDataImpl(FillType.BORDERS, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14)))
        //.setClickable(false) (this has false boolean as default)
        .addButton(14, new Button()
        .setItemStack(new ItemCreator(Material.REDSTONE).setDisplayName("&bButton Test").create())
        .setAction(event -> player.sendMessage("Hello world!")))
        );

    menuHandler.register(player.getUniqueId(), menu);
    menu.openInventory(player);
}
```

##### If you need help or have any suggestion you can write me through my discord _**@bot.java**_