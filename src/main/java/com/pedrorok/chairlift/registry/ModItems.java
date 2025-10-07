package com.pedrorok.chairlift.registry;

import com.pedrorok.chairlift.ChairliftMod;
import com.pedrorok.chairlift.item.ChairliftItem;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.logistics.box.PackageStyles;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

/**
 * @author Rok, Pedro Lucas nmm. Created on 06/10/2025
 * @project CreateChairlift
 */
public class ModItems {

    public static final ItemEntry<ChairliftItem> CHAIR_LIFT = ChairliftMod.get().item("chair_lift", (properties) -> new ChairliftItem(properties, PackageStyles.STYLES.getFirst()))
            .tag(AllTags.AllItemTags.PACKAGES.tag)
            .lang("ChairLift")
            .register();

    public static void register() {

    }
}
