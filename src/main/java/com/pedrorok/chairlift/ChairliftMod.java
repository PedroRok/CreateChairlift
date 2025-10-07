package com.pedrorok.chairlift;

import com.pedrorok.chairlift.registry.ModEntities;
import com.pedrorok.chairlift.registry.ModItems;
import com.pedrorok.chairlift.registry.MyPartialModels;
import com.simibubi.create.CreateClient;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Rok, Pedro Lucas nmm. Created on 17/04/2025
 * @project Create Hypertube
 */
@Mod(ChairliftMod.MOD_ID)
public class ChairliftMod {
    public static final String MOD_ID = "create_chairlift";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ChairliftMod.MOD_ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    public ChairliftMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        //modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC, MOD_ID + "-client.toml");
        //modContainer.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC, MOD_ID + "-server.toml");

        REGISTRATE.registerEventListeners(modEventBus);

        ModEntities.register();
        ModItems.register();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    public static CreateRegistrate get() {
        return REGISTRATE;
    }
}
