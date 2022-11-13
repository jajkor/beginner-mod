package com.marvin.newmod.init;

import com.marvin.newmod.FirstModMain;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FirstModMain.MOD_ID);

    public static final RegistryObject<Item> TF = ITEMS.register("tf_logo",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SANDVICH = ITEMS.register("sandvich",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance).food(new FoodProperties.Builder().nutrition(1).saturationMod(2)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 200, 0), 1.0F).build())));

    public static final RegistryObject<Item> BONK = ITEMS.register("bonk",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance).food(new FoodProperties.Builder().nutrition(0).saturationMod(0)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 160, 0), 1.0F).build())));

    public static class ModCreativeTab extends CreativeModeTab {
        private ModCreativeTab (int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TF.get());
        }

        public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "newmod");
    }

}
