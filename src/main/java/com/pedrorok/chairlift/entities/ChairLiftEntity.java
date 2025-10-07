package com.pedrorok.chairlift.entities;

import com.pedrorok.chairlift.registry.ModEntities;
import com.simibubi.create.content.logistics.box.PackageEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;


/**
 * @author Rok, Pedro Lucas nmm. Created on 08/09/2025
 * @project CreateChairlift
 */
public class ChairLiftEntity extends PackageEntity {

    public ChairLiftEntity(EntityType<?> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public ChairLiftEntity(Level worldIn, double x, double y, double z) {
        this(ModEntities.CHAIR_LIFT.get(), worldIn);
        this.setPos(x, y, z);
        this.refreshDimensions();
    }


    public static EntityType.Builder<?> build(EntityType.Builder<?> builder) {
        @SuppressWarnings("unchecked")
        EntityType.Builder<ChairLiftEntity> entityBuilder = (EntityType.Builder<ChairLiftEntity>) builder;
        return entityBuilder
                .sized(0.8F, 1.2F) // Tamanho ajustado para caber melhor na corrente
                .clientTrackingRange(10)
                .updateInterval(3);
    }
}