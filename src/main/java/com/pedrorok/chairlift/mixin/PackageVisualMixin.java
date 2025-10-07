package com.pedrorok.chairlift.mixin;

import com.pedrorok.chairlift.entities.ChairLiftEntity;
import com.pedrorok.chairlift.registry.MyPartialModels;
import com.simibubi.create.content.logistics.box.PackageEntity;
import com.simibubi.create.content.logistics.box.PackageVisual;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * @author Rok, Pedro Lucas nmm. Created on 07/10/2025
 * @project CreateChairlift
 */
@Mixin(PackageVisual.class)
public class PackageVisualMixin {

    @ModifyVariable(
            method = "<init>",
            at = @At(
                    value = "STORE",
                    ordinal = 0
            ),
            ordinal = 0
    )
    private PartialModel modificarModel(PartialModel original, VisualizationContext ctx, PackageEntity entity, float partialTick) {
        if (entity instanceof ChairLiftEntity) {
            return MyPartialModels.CHAIRLIFT;
        }
        return original;
    }
}