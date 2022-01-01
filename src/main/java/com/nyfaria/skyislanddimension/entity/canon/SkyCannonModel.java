package com.nyfaria.skyislanddimension.entity.canon;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;


public class SkyCannonModel extends EntityModel<SkyCannonEntity> {
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer neck;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer head;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer head_band;
	private final ModelRenderer cube_r14;
	private final ModelRenderer uper_left_leg;
	private final ModelRenderer cube_r15;
	private final ModelRenderer left_leg;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer left_foot;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer uper_right_leg;
	private final ModelRenderer cube_r20;
	private final ModelRenderer right_leg;
	private final ModelRenderer cube_r21;
	private final ModelRenderer right_foot;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;

	public SkyCannonModel() {
		texWidth = 256;
		texHeight = 256;

		body = new ModelRenderer(this);
		body.setPos(0.0F, 14.0F, 8.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, -1.0F, -2.0F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3491F, 0.0F, 0.0F);
		cube_r1.texOffs(106, 94).addBox(-2.0F, -1.0F, -7.0F, 4.0F, 7.0F, 14.0F, 0.0F, false);
		cube_r1.texOffs(0, 78).addBox(2.0F, -6.0F, -7.0F, 8.0F, 12.0F, 14.0F, 0.0F, false);
		cube_r1.texOffs(18, 11).addBox(10.0F, 0.0F, -9.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(110, 17).addBox(-11.0F, 0.0F, -10.0F, 22.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(44, 80).addBox(-10.0F, -6.0F, -7.0F, 8.0F, 12.0F, 14.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.05F, -1.0F, -2.0F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.1309F, 0.0F, 0.0F);
		cube_r2.texOffs(68, 0).addBox(9.951F, 3.0F, -9.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r2.texOffs(110, 13).addBox(-11.05F, 3.0F, -10.0F, 22.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.05F, 6.793F, -9.0548F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.7854F, 0.0F, 0.0F);
		cube_r3.texOffs(18, 110).addBox(9.951F, -1.5F, -0.25F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		cube_r3.texOffs(110, 9).addBox(-11.05F, -1.5F, -1.25F, 22.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, -20.0F, -2.0F);
		body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.7854F, 0.0F, 0.0F);
		cube_r4.texOffs(96, 16).addBox(-11.001F, 12.457F, -24.184F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, -20.0F, -2.0F);
		body.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.1309F, 0.0F, 0.0F);
		cube_r5.texOffs(0, 0).addBox(-11.001F, 21.8375F, -6.52F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, -20.0F, -2.0F);
		body.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.3491F, 0.0F, 0.0F);
		cube_r6.texOffs(18, 6).addBox(-11.0F, 17.8542F, -2.5016F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setPos(0.0F, 10.0F, -8.0F);
		body.addChild(neck);
		

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, -30.0F, 6.0F);
		neck.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.3491F, 0.0F, 0.0F);
		cube_r7.texOffs(62, 106).addBox(-11.0F, 10.8542F, -0.5016F, 1.0F, 14.0F, 14.0F, 0.0F, false);
		cube_r7.texOffs(0, 46).addBox(-13.0F, 7.8542F, 3.4984F, 1.0F, 6.0F, 6.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(0.0F, -11.0F, 6.0F);
		neck.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.3491F, 0.0F, 0.0F);
		cube_r8.texOffs(32, 106).addBox(10.0F, -7.0F, -7.0F, 1.0F, 14.0F, 14.0F, 0.0F, false);
		cube_r8.texOffs(92, 108).addBox(11.0F, -27.0F, -5.0F, 1.0F, 24.0F, 10.0F, 0.0F, false);
		cube_r8.texOffs(46, 46).addBox(12.0F, -10.0F, -3.0F, 1.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r8.texOffs(114, 27).addBox(-12.0F, -27.0F, -5.0F, 1.0F, 24.0F, 10.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0147F, -31.6926F, 14.562F);
		neck.addChild(head);
		

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(-0.0147F, -0.3074F, -2.562F);
		head.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.3491F, 0.0F, 0.0F);
		cube_r9.texOffs(0, 130).addBox(12.0F, -7.2143F, -4.4557F, 1.0F, 12.0F, 12.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(-0.0147F, 1.6926F, -8.562F);
		head.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.3491F, 0.0F, 0.0F);
		cube_r10.texOffs(124, 49).addBox(-13.0F, -11.1458F, 0.4984F, 1.0F, 12.0F, 12.0F, 0.0F, false);
		cube_r10.texOffs(46, 48).addBox(-8.0F, -14.2458F, -32.5016F, 16.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r10.texOffs(0, 62).addBox(-8.0F, -13.2458F, -18.5016F, 16.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r10.texOffs(0, 46).addBox(-8.0F, 1.7542F, -32.5016F, 16.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r10.texOffs(46, 64).addBox(-8.0F, 0.7542F, -18.5016F, 16.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r10.texOffs(92, 50).addBox(-8.0F, -11.2458F, -18.5016F, 2.0F, 12.0F, 14.0F, 0.0F, false);
		cube_r10.texOffs(88, 80).addBox(-9.0F, -12.2458F, -32.5016F, 2.0F, 14.0F, 14.0F, 0.0F, false);
		cube_r10.texOffs(92, 9).addBox(7.0F, -12.2458F, -32.5016F, 2.0F, 14.0F, 14.0F, 0.0F, false);
		cube_r10.texOffs(0, 104).addBox(6.0F, -11.2458F, -18.5016F, 2.0F, 12.0F, 14.0F, 0.0F, false);
		cube_r10.texOffs(126, 21).addBox(-4.0F, -9.1458F, 19.4984F, 9.0F, 9.0F, 7.0F, 0.0F, false);
		cube_r10.texOffs(0, 0).addBox(-11.0F, -16.1458F, -4.5016F, 22.0F, 22.0F, 24.0F, 0.0F, false);
		cube_r10.texOffs(104, 45).addBox(-2.0F, 12.8542F, 8.4984F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r10.texOffs(64, 106).addBox(-2.0F, 12.8542F, 5.4984F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r10.texOffs(110, 61).addBox(-2.0F, 12.8542F, 2.4984F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r10.texOffs(36, 112).addBox(-2.0F, 12.8542F, -0.5016F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r10.texOffs(0, 114).addBox(-2.0F, 12.8542F, -3.5016F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r10.texOffs(74, 89).addBox(-2.0F, 5.8542F, -1.5016F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r10.texOffs(106, 76).addBox(-2.0F, 8.8542F, -4.5016F, 4.0F, 4.0F, 14.0F, 0.0F, false);
		cube_r10.texOffs(86, 9).addBox(-2.0F, 1.8542F, -2.5016F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(-0.0147F, 1.6926F, -8.562F);
		head.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.4363F, 0.0F, 0.0F);
		cube_r11.texOffs(30, 106).addBox(-2.0F, 15.7821F, 5.6119F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cube_r11.texOffs(0, 88).addBox(-2.0F, 15.7821F, 2.6119F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r11.texOffs(30, 89).addBox(-2.0F, 15.7821F, -0.3881F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r11.texOffs(68, 9).addBox(-2.001F, 11.7821F, -2.3881F, 4.0F, 4.0F, 10.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(-0.0147F, 1.6926F, -8.562F);
		head.addChild(cube_r12);
		setRotationAngle(cube_r12, -1.1345F, 0.0F, 0.0F);
		cube_r12.texOffs(56, 115).addBox(-2.0F, 12.1545F, 3.9223F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r12.texOffs(66, 115).addBox(-2.0F, 12.1545F, 0.9223F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r12.texOffs(104, 115).addBox(-2.0F, 12.1545F, -2.0777F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r12.texOffs(18, 104).addBox(-2.0F, 12.1545F, -11.0777F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cube_r12.texOffs(114, 115).addBox(-2.0F, 12.1545F, -5.0777F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r12.texOffs(114, 115).addBox(-2.002F, 8.1545F, -7.0777F, 4.0F, 4.0F, 13.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(-0.0147F, 1.6926F, -8.562F);
		head.addChild(cube_r13);
		setRotationAngle(cube_r13, -1.9199F, 0.0F, 0.0F);
		cube_r13.texOffs(86, 16).addBox(-1.998F, 12.6689F, 2.5524F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		head_band = new ModelRenderer(this);
		head_band.setPos(-0.0147F, -1.9699F, -3.042F);
		head.addChild(head_band);
		

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(0.0F, 2.6625F, -7.52F);
		head_band.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.1309F, 0.0F, 0.0F);
		cube_r14.texOffs(68, 0).addBox(-12.0F, -18.1625F, 6.52F, 24.0F, 1.0F, 8.0F, 0.0F, false);
		cube_r14.texOffs(26, 134).addBox(-12.0F, -17.1625F, 6.52F, 1.0F, 14.0F, 8.0F, 0.0F, false);
		cube_r14.texOffs(0, 0).addBox(11.0F, -17.1625F, 6.52F, 1.0F, 14.0F, 8.0F, 0.0F, false);

		uper_left_leg = new ModelRenderer(this);
		uper_left_leg.setPos(14.0F, 6.5723F, -10.1973F);
		

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(-30.0F, 0.0F, 0.0F);
		uper_left_leg.addChild(cube_r15);
		setRotationAngle(cube_r15, -1.9635F, 0.0F, 0.0F);
		cube_r15.texOffs(0, 62).addBox(27.0F, -19.6156F, -3.1217F, 1.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r15.texOffs(114, 132).addBox(28.0F, -18.6156F, -2.1217F, 4.0F, 21.0F, 4.0F, 0.0F, false);
		cube_r15.texOffs(46, 64).addBox(32.0F, -19.6156F, -3.1217F, 1.0F, 5.0F, 5.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setPos(0.0F, 0.0F, 0.0F);
		uper_left_leg.addChild(left_leg);
		left_leg.texOffs(58, 106).addBox(-4.0F, 9.4277F, -5.8027F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		left_leg.texOffs(106, 76).addBox(3.0F, 9.4277F, -5.8027F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		left_leg.texOffs(78, 106).addBox(-4.0F, -2.5723F, -2.5527F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		left_leg.texOffs(88, 108).addBox(3.0F, -2.5723F, -2.5527F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(0.0F, 17.4277F, -4.3027F);
		left_leg.addChild(cube_r16);
		setRotationAngle(cube_r16, -0.2618F, 0.0F, 0.0F);
		cube_r16.texOffs(56, 134).addBox(-3.0F, -20.5631F, -3.4762F, 1.0F, 20.0F, 5.0F, 0.0F, false);
		cube_r16.texOffs(68, 134).addBox(2.0F, -20.5631F, -3.4762F, 1.0F, 20.0F, 5.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(0.0F, -0.5792F, -0.3999F);
		left_leg.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.2618F, 0.0F, 0.0F);
		cube_r17.texOffs(80, 139).addBox(-2.0F, -1.1596F, -1.5854F, 4.0F, 19.0F, 3.0F, 0.0F, false);

		left_foot = new ModelRenderer(this);
		left_foot.setPos(0.03F, 15.7277F, -4.5527F);
		left_leg.addChild(left_foot);
		left_foot.texOffs(30, 80).addBox(-4.03F, -1.3F, -3.25F, 8.0F, 3.0F, 6.0F, 0.0F, false);
		left_foot.texOffs(48, 114).addBox(-1.03F, 0.7F, -7.25F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		left_foot.texOffs(44, 89).addBox(-1.03F, 0.7F, 2.75F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(-3.53F, 1.2F, -4.5F);
		left_foot.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.3491F, 0.0F);
		cube_r18.texOffs(78, 114).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(3.62F, 1.2F, -4.75F);
		left_foot.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, -0.3491F, 0.0F);
		cube_r19.texOffs(28, 112).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		uper_right_leg = new ModelRenderer(this);
		uper_right_leg.setPos(-14.0F, 6.4567F, -10.4856F);
		

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(0.0F, 0.1156F, 0.2883F);
		uper_right_leg.addChild(cube_r20);
		setRotationAngle(cube_r20, -1.9635F, 0.0F, 0.0F);
		cube_r20.texOffs(130, 132).addBox(-2.0F, -18.6156F, -2.1217F, 4.0F, 21.0F, 4.0F, 0.0F, false);
		cube_r20.texOffs(0, 104).addBox(2.0F, -19.6156F, -2.8717F, 1.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r20.texOffs(0, 78).addBox(-3.0F, -19.6156F, -2.8717F, 1.0F, 5.0F, 5.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setPos(0.0F, 0.0F, 0.0F);
		uper_right_leg.addChild(right_leg);
		right_leg.texOffs(48, 106).addBox(-4.0F, 9.5433F, -5.5144F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		right_leg.texOffs(104, 37).addBox(3.0F, 9.5433F, -5.5144F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		right_leg.texOffs(68, 9).addBox(-4.0F, -2.4567F, -2.2644F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		right_leg.texOffs(10, 0).addBox(3.0F, -2.4567F, -2.2644F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(0.0F, 17.5433F, -4.0144F);
		right_leg.addChild(cube_r21);
		setRotationAngle(cube_r21, -0.2618F, 0.0F, 0.0F);
		cube_r21.texOffs(92, 37).addBox(-3.0F, -20.5631F, -3.4762F, 1.0F, 20.0F, 5.0F, 0.0F, false);
		cube_r21.texOffs(138, 37).addBox(-2.0F, -19.5631F, -2.4762F, 4.0F, 19.0F, 3.0F, 0.0F, false);
		cube_r21.texOffs(44, 134).addBox(2.0F, -20.5631F, -3.4762F, 1.0F, 20.0F, 5.0F, 0.0F, false);

		right_foot = new ModelRenderer(this);
		right_foot.setPos(0.03F, 16.8433F, -4.3644F);
		right_leg.addChild(right_foot);
		right_foot.texOffs(106, 84).addBox(-1.03F, -0.3F, -7.15F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		right_foot.texOffs(74, 80).addBox(-4.03F, -2.3F, -3.15F, 8.0F, 3.0F, 6.0F, 0.0F, false);
		right_foot.texOffs(0, 72).addBox(-1.03F, -0.3F, 2.85F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(3.62F, 0.2F, -4.65F);
		right_foot.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, -0.3491F, 0.0F);
		cube_r22.texOffs(86, 89).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(-3.53F, 0.2F, -4.4F);
		right_foot.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.3491F, 0.0F);
		cube_r23.texOffs(64, 110).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(SkyCannonEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		if(!pEntity.getPassengers().isEmpty())
		{
			LivingEntity livingEntity = (LivingEntity) pEntity.getPassengers().get(0);
			this.head.xRot = livingEntity.getViewXRot(pAgeInTicks) * ((float)Math.PI / 180F);
		}
	}


	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		uper_left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		uper_right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}