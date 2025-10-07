package com.pedrorok.chairlift.mixin;

import com.pedrorok.chairlift.registry.MyPartialModels;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorVisual;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

/**
 * @author Rok, Pedro Lucas nmm. Created on 07/10/2025
 * @project CreateChairlift
 */
@Mixin(ChainConveyorVisual.class)
public class ChainConveyorVisualMixin {

    @Redirect(
            method = "lambda$new$1",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;",
                    remap = false
            ),
            remap = false,
            require = 0  // Não falhar se não encontrar
    )
    private Object redirectRiggingInLambda(Map<ResourceLocation, PartialModel> map, Object key) {
        PartialModel partialModel = map.get(key);

        if (partialModel == null) {
            return MyPartialModels.CHAIRLIFT;
        }
        return partialModel;
    }

    @Redirect(
            method = "lambda$new$0",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;",
                    remap = false
            ),
            remap = false,
            require = 0  // Não falhar se não encontrar
    )
    private Object redirectRiggingInLambda0(Map<ResourceLocation, PartialModel> map, Object key) {
        PartialModel partialModel = map.get(key);

        if (partialModel == null) {
            return MyPartialModels.CHAIRLIFT;
        }
        return partialModel;
    }
}
