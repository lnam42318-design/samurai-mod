package com.example.samuraimod;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum SamuraiArmorMaterial implements ArmorMaterial {

    SAMURAI("samurai", 22,
            new EnumMap<>(java.util.Map.of(
                    ArmorItem.Type.BOOTS, 3,
                    ArmorItem.Type.LEGGINGS, 5,
                    ArmorItem.Type.CHESTPLATE, 7,
                    ArmorItem.Type.HELMET, 3
            )),
            18,
            SoundEvents.ARMOR_EQUIP_IRON,
            2.5f,
            0.1f,
            () -> Ingredient.of(Items.IRON_INGOT));

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionValues;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    SamuraiArmorMaterial(String name, int durabilityMultiplier,
                          EnumMap<ArmorItem.Type, Integer> protectionValues,
                          int enchantmentValue, SoundEvent sound,
                          float toughness, float knockbackResistance,
                          Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionValues = protectionValues;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return switch (type) {
            case HELMET -> 11 * durabilityMultiplier;
            case CHESTPLATE -> 16 * durabilityMultiplier;
            case LEGGINGS -> 15 * durabilityMultiplier;
            case BOOTS -> 13 * durabilityMultiplier;
        };
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return protectionValues.get(type);
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public String getName() {
        return SamuraiMod.MODID + ":" + name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
