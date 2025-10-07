package com.pedrorok.chairlift.mixin;

import com.pedrorok.chairlift.registry.ModItems;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorPackage;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorRidingHandler;
import com.simibubi.create.content.kinetics.chainConveyor.ChainPackageInteractionPacket;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

/**
 * @author Rok, Pedro Lucas nmm. Created on 07/10/2025
 * @project CreateChairlift
 */
@Mixin(ChainPackageInteractionPacket.class)
public abstract class ChainPackageInteractionPacketMixin {

    @Inject(
            method = "applySettings*",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ServerPlayer;getMainHandItem()Lnet/minecraft/world/item/ItemStack;",
                    ordinal = 0,
                    shift = At.Shift.BEFORE
            ),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILSOFT,
            require = 0
    )
    private void beforeRemovePackage(
            ServerPlayer player,
            ChainConveyorBlockEntity be,
            CallbackInfo ci,
            float bestDiff,
            ChainConveyorPackage best,
            List<ChainConveyorPackage> list
    ) {
        if (!best.item.getItemHolder().is(ModItems.CHAIR_LIFT.getKey())) return;
        ci.cancel();
        ChainConveyorRidingHandler.embark(be.getBlockPos(), bestDiff, be.connections.iterator().next());
    }

}