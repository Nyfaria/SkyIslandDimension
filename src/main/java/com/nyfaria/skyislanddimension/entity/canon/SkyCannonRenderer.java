package com.nyfaria.skyislanddimension.entity.canon;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.nyfaria.skyislanddimension.SkyIslandDimension;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class SkyCannonRenderer extends EntityRenderer<SkyCannonEntity> {
    private static final ResourceLocation DARK_LOCATION = new ResourceLocation(SkyIslandDimension.MOD_ID, "textures/entity/sky_cannon.png");
    private SkyCannonModel model = new SkyCannonModel();
    public SkyCannonRenderer(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }

    @Override
    public void render(SkyCannonEntity pEntity, float pEntityYaw, float pPartialTicks, MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight) {



        pMatrixStack.pushPose();
        pMatrixStack.translate(0,1.5,0);
        pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(180));
        IVertexBuilder ivertexbuilder = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        this.model.renderToBuffer(pMatrixStack,ivertexbuilder,pPackedLight, OverlayTexture.NO_OVERLAY,1,1,1,1);
        this.model.setupAnim(pEntity,0,0,0,0,0);
        pMatrixStack.popPose();


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SkyCannonEntity pEntity) {
        return DARK_LOCATION;
    }
}
