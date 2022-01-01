package com.nyfaria.skyislanddimension.init;

import com.nyfaria.skyislanddimension.SkyIslandDimension;
import com.nyfaria.skyislanddimension.item.CannonItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SkyIslandDimension.MOD_ID);
    public static final RegistryObject<Item> CANNON_ITEM = ITEMS.register("cannon_item", () -> new CannonItem((new Item.Properties()).tab(ItemGroup.TAB_TOOLS).fireResistant()));

}