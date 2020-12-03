package org.yacks.util;

import org.yacks.blocks.LifeBlock;
import org.yacks.items.SharpSoft;
import org.yacks.items.SolidifiedFire;
import org.yacks.materials.ModArmorMaterial;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.item.BlockItem;
/**
 * This is where we tell forge the items exist and add them to the registry of all blocks/items.
 */
public class RegistryHandler {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "whosidea");
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "whosidea");
    /**
     * This function initalizes all the blocks and items by adding them to the event bus.
     * @see org.yacks.WhosIdea
     */
    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    
    //Blocks
    public static final RegistryObject<Block> LIFE_BLOCK = BLOCKS.register("life_adder", LifeBlock::new);

    // Items
    public static final RegistryObject<Item> SOLID_FIRE = ITEMS.register("solid_fire", SolidifiedFire::new);
    public static final RegistryObject<Item> SOFT_SHARP = ITEMS.register("sharp_soft", SharpSoft::new);
    public static final RegistryObject<Item>  LIFE_BLOCK_ITEM = ITEMS.register("life_adder", () -> new BlockItem(LIFE_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    // Armor
    public static final RegistryObject<ArmorItem> SOLID_FIRE_HELMET = ITEMS.register("solid_fire_helmet",
    () -> new ArmorItem(ModArmorMaterial.HELL_CRYSTAL, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> SOLID_FIRE_CHESTPLATE = ITEMS.register("solid_fire_chestplate",
    () -> new ArmorItem(ModArmorMaterial.HELL_CRYSTAL, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> SOLID_FIRE_LEGGINGS = ITEMS.register("solid_fire_leggings",
    () -> new ArmorItem(ModArmorMaterial.HELL_CRYSTAL, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> SOLID_FIRE_BOOTS = ITEMS.register("solid_fire_boots",
    () -> new ArmorItem(ModArmorMaterial.HELL_CRYSTAL, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));

}
