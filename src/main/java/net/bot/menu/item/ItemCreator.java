package net.bot.menu.item;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ItemCreator | vLib
 * Author: @bot.java | ItemBuilder Fork
 */
@Getter @Setter
public class ItemCreator {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    private Material material;

    public ItemCreator(Material material){
        this(material, 1, (short) 0);
    }

    public ItemCreator(Material material, int amount){
        this(new ItemStack(material, amount, (short) 0));
    }

    public ItemCreator(Material material, short data){
        this(new ItemStack(material, 1, data));
    }

    public ItemCreator(Material material, String amount, short data){
        this(new ItemStack(material, Integer.parseInt(amount), data));
    }

    public ItemCreator(Material material, int amount, short data){
        this(new ItemStack(material, amount, data));
    }

    public ItemCreator(@NotNull ItemStack itemStack){
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
        this.material = itemStack.getType();
    }

    public ItemCreator setMaterial(Material material){
        itemStack = new ItemStack(material);
        return this;
    }

    public ItemCreator setAmount(int amount){
        itemStack.setAmount(amount);
        return this;
    }

    public ItemCreator setData(int data){
        itemStack.setData(new MaterialData((byte) data));
        return this;
    }

    public ItemCreator setDisplayName(String displayName){
        itemMeta.setDisplayName(translate(displayName));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator setLore(@NotNull List<String> lore){
        ItemMeta itemMeta = itemStack.getItemMeta();
        
        itemMeta.setLore(lore.stream().map(this::translate).collect(Collectors.toList()));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator setLore(String... lore){
        setLore(Arrays.asList(lore));
        return this;
    }

    public ItemCreator setColor(Color color){
        if (material == Material.LEATHER_BOOTS || material == Material.LEATHER_CHESTPLATE || material == Material.LEATHER_LEGGINGS || material == Material.LEATHER_HELMET) {
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
            leatherArmorMeta.setColor(color);
            itemStack.setItemMeta(leatherArmorMeta);
        }
        return this;
    }

    public ItemCreator setDurability(int durability){
        itemStack.setDurability((short) durability);
        return this;
    }

    public ItemCreator setUnbreakable(boolean unbreakable) {
        itemMeta.spigot().setUnbreakable(unbreakable);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator setSkullOwner(String skullOwner) {
        if (material == Material.SKULL_ITEM) {
            SkullMeta skullMeta = (SkullMeta) itemMeta;
            skullMeta.setOwner(skullOwner);
            itemStack.setItemMeta(skullMeta);
        }
        return this;
    }

    public ItemCreator addEnchant(Enchantment enchantment, int level){
        itemMeta.addEnchant(enchantment, level, true);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator getEnchantedBook(Enchantment enchantment, int level){
        if (material == Material.ENCHANTED_BOOK) {
            EnchantmentStorageMeta storageMeta = (EnchantmentStorageMeta) itemMeta;
            storageMeta.addStoredEnchant(enchantment, level, true);
            itemStack.setItemMeta(storageMeta);
        }
        return this;
    }

    public ItemCreator setGlow() {
        itemMeta.addEnchant(new Glow(), 1, true);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    @Contract("_ -> new")
    private @NotNull String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public ItemStack create(){
        return itemStack;
    }

    public static class Glow extends Enchantment {
        public Glow() {
            super(25);
        }

        @Override
        public boolean canEnchantItem(ItemStack arg0) {
            return false;
        }

        @Override
        public boolean conflictsWith(Enchantment arg0) {
            return false;
        }

        @Override
        public EnchantmentTarget getItemTarget() {
            return null;
        }

        @Override
        public int getMaxLevel() {
            return 2;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public int getStartLevel() {
            return 1;
        }
    }
}
