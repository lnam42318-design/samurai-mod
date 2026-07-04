package com.example.samuraimod;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

@Mod(SamuraiMod.MODID)
public class SamuraiMod {

    public static final String MODID = "samuraimod";

    public SamuraiMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register our deferred registers
        ModItems.ITEMS.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    // Add our items to the Combat creative tab so they show up in the inventory
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.SAMURAI_KATANA);
            event.accept(ModItems.SAMURAI_HELMET);
            event.accept(ModItems.SAMURAI_CHESTPLATE);
            event.accept(ModItems.SAMURAI_LEGGINGS);
            event.accept(ModItems.SAMURAI_BOOTS);
        }
    }
}
