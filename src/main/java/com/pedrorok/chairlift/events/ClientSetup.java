package com.pedrorok.chairlift.events;

import com.pedrorok.chairlift.entities.ChairliftRenderer;
import com.pedrorok.chairlift.registry.ModEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * @author Rok, Pedro Lucas nmm. Created on 07/10/2025
 * @project CreateChairlift
 */
@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.CHAIR_LIFT.get(), ChairliftRenderer::new);
    }
}