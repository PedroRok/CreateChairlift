package com.pedrorok.chairlift.registry;

import com.pedrorok.chairlift.ChairliftMod;
import com.pedrorok.chairlift.entities.ChairLiftEntity;
import com.pedrorok.chairlift.entities.ChairliftRenderer;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateEntityBuilder;
import com.tterrag.registrate.util.entry.EntityEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.createmod.catnip.lang.Lang;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

/**
 * @author Rok, Pedro Lucas nmm. Created on 08/09/2025
 * @project CreateChairlift
 */
public class ModEntities {


    public static final EntityEntry<ChairLiftEntity> CHAIR_LIFT = register("chair_lift", ChairLiftEntity::new,
            () -> ChairliftRenderer::new,
            MobCategory.MISC, 5, 20, true, false,
            ChairLiftEntity::build)
            .register();

    private static <T extends Entity> CreateEntityBuilder<T, ?> register(String name, EntityType.EntityFactory<T> factory,
                                                                         NonNullSupplier<NonNullFunction<EntityRendererProvider.Context, EntityRenderer<? super T>>> renderer,
                                                                         MobCategory group, int range, int updateFrequency, boolean sendVelocity, boolean immuneToFire,
                                                                         NonNullConsumer<EntityType.Builder<T>> propertyBuilder) {
        String id = Lang.asId(name);
        return (CreateEntityBuilder<T, ?>) ChairliftMod.get()
                .entity(id, factory, group)
                .properties(b -> b.setTrackingRange(range)
                        .setUpdateInterval(updateFrequency)
                        .setShouldReceiveVelocityUpdates(sendVelocity))
                .properties(propertyBuilder)
                .properties(b -> {
                    if (immuneToFire)
                        b.fireImmune();
                })
                .renderer(renderer);
    }

    public static void register() {

    }
}
