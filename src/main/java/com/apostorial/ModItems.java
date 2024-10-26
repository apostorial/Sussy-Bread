package com.apostorial;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item EXPLOSIVE_BREAD = registerExplosiveBread();

    private static Item registerExplosiveBread() {
        Identifier itemID = Identifier.of("sussy-bread", "explosive_bread");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemID);

        Item.Settings settings = new Item.Settings().registryKey(key);
        Item explosiveBreadItem = new Item(settings);

        Registry.register(Registries.ITEM, key, explosiveBreadItem);

        return explosiveBreadItem;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(EXPLOSIVE_BREAD));

        SussyBread.LOGGER.info("Registering SussyBread items");
    }
}