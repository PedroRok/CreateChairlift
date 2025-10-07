package com.pedrorok.chairlift.registry;

import com.pedrorok.chairlift.ChairliftMod;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.minecraft.resources.ResourceLocation;

/**
 * @author Rok, Pedro Lucas nmm. Created on 07/10/2025
 * @project CreateChairlift
 */
public class MyPartialModels {
    public static final PartialModel CHAIRLIFT = PartialModel.of(
       ResourceLocation.fromNamespaceAndPath(ChairliftMod.MOD_ID, "entity/chairlift")
    );

    public static void register() {
    }
}
