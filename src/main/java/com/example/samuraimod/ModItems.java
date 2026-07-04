package com.example.samuraimod;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SamuraiMod.MODID);

    // Katana: dùng Tier NETHERITE-like sát thương cao, tốc độ vung nhanh hơn kiếm thường.
    // attackDamageModifier: sát thương cộng thêm so với tay không (kiếm sắt vanilla = 3.0f)
    // attackSpeedModifier: kiếm vanilla mặc định -2.4f (tốc độ ~1.6). Katana nhanh hơn: -1.8f (~2.2 tốc độ)
    public static final RegistryObject<Item> SAMURAI_KATANA = ITEMS.register("samurai_katana",
            () -> new SwordItem(Tiers.DIAMOND, 4, -1.8f,
                    new Item.Properties()));

    public static final RegistryObject<Item> SAMURAI_HELMET = ITEMS.register("samurai_helmet",
            () -> new ArmorItem(SamuraiArmorMaterial.SAMURAI, ArmorItem.Type.HELMET,
                    new Item.Properties()));

    public static final RegistryObject<Item> SAMURAI_CHESTPLATE = ITEMS.register("samurai_chestplate",
            () -> new ArmorItem(SamuraiArmorMaterial.SAMURAI, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));

    public static final RegistryObject<Item> SAMURAI_LEGGINGS = ITEMS.register("samurai_leggings",
            () -> new ArmorItem(SamuraiArmorMaterial.SAMURAI, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));

    public static final RegistryObject<Item> SAMURAI_BOOTS = ITEMS.register("samurai_boots",
            () -> new ArmorItem(SamuraiArmorMaterial.SAMURAI, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
}
