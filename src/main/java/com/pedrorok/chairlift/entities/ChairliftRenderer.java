package com.pedrorok.chairlift.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/**
 * @author Rok, Pedro Lucas nmm. Created on 07/10/2025
 * @project CreateChairlift
 */
public class ChairliftRenderer extends EntityRenderer<ChairLiftEntity> {

	private static final ResourceLocation TEXTURE =
			ResourceLocation.fromNamespaceAndPath("chairlift", "textures/entity/chairlift.png");

	private final ModelPart base;
	private final ModelPart back;

	public ChairliftRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.shadowRadius = 0.5f;

		// Criar o modelo diretamente no código (baseado no seu JSON do Blockbench)
		ModelPart root = createModel();
		this.base = root.getChild("base");
		this.back = root.getChild("back");
	}

	private static ModelPart createModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		// Base (assento) - from: [0, 0, 0], to: [16, 2, 16]
		root.addOrReplaceChild("base",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F),
				PartPose.ZERO);

		// Encosto - from: [0, 2, 14], to: [16, 17, 16]
		root.addOrReplaceChild("back",
				CubeListBuilder.create()
						.texOffs(0, 18)
						.addBox(-8.0F, 0.0F, 6.0F, 16.0F, 15.0F, 2.0F),
				PartPose.ZERO);

		return LayerDefinition.create(mesh, 64, 64).bakeRoot();
	}

	@Override
	public void render(ChairLiftEntity entity, float entityYaw, float partialTicks,
					   PoseStack poseStack, MultiBufferSource buffer, int light) {

		poseStack.pushPose();

		// Ajustar posição e rotação
		poseStack.translate(0, 1.5, 0);
		poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(-entityYaw));

		// Renderizar o modelo
		VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutout(TEXTURE));

		base.render(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
		back.render(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);

		poseStack.popPose();

		super.render(entity, entityYaw, partialTicks, poseStack, buffer, light);
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(ChairLiftEntity entity) {
		return TEXTURE;
	}
}