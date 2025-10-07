package com.pedrorok.chairlift.events;

import com.pedrorok.chairlift.ChairliftMod;
import com.pedrorok.chairlift.registry.MyPartialModels;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * @author Rok, Pedro Lucas nmm. Created on 07/10/2025
 * @project CreateChairlift
 */
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ChairliftMod.MOD_ID)
public class ModSetup {

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        MyPartialModels.register();
    }
}
