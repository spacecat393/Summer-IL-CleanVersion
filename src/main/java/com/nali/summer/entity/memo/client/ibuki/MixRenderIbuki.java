package com.nali.summer.entity.memo.client.ibuki;

import com.nali.list.da.BothDaIbuki;
import com.nali.list.render.RenderIbuki;
import com.nali.small.entity.*;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixRenderIbuki
<
	IE extends InvLe,
	R extends RenderIbuki<IE, E, I, MC, MB, ?, C>,
	E extends EntityLe,
	I extends IMixE<BothDaIbuki, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaIbuki, R, E, I, MB, ?, C>,
	MB extends MixBoxSleInv<BothDaIbuki, R, E, I, MC, ?, C>,
	C extends ClientLeInv<IE, BothDaIbuki, R, E, I, MC, MB, ?>
> extends MixRenderSleInv<IE, BothDaIbuki, R, E, I, MC, MB, C>
{
	public MixRenderIbuki(C c)
	{
		super(c);
		this.shadow_opaque = 0.5F;
		this.shadow_size = 0.25F;
	}

//	@Override
//	public boolean shouldRender(T skinningentities, ICamera camera, double camX, double camY, double camZ)
//	{
//		ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)skinningentities.bothentitiesmemory;
//		SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
//
//		if ((cliententitiesmemory.sync_byte_array[0] & 128) == 128)
//		{
//			skinningrender.entitiesrendermemory.should_render = true;
//			return skinningrender.entitiesrendermemory.should_render;
//		}
//		else
//		{
//			return super.shouldRender(skinningentities, camera, camX, camY, camZ);
//		}
//	}

	//sync 3d skinning on server
//	@Override
//	public void doRender(FRenderE<E> rendere, double ox, double oy, double oz, float partialTicks)
//	{
//		GL11.glPushMatrix();
//
//		if ((this.c.sync_byte_array[0] & 128) == 128)
//		{
//			R r = this.c.r;
//			GL11.glTranslated(ox, oy, oz);
//			float s = this.c.i.getE().getDataManager().get(this.c.i.getFloatDataParameterArray()[1]);
//			GL11.glScalef(s, s, s);
//			GL11.glTranslated(-ox, -oy, -oz);
////			OpenGLAnimationMemory openglanimationmemory = ibukirender.dataloader.openglanimationmemory_list.get(((SkinningClientData)ibukirender.iroharender.clientdata).FrameID());
////			OpenGLAnimationMemory openglanimationmemory = (OpenGLAnimationMemory)ibukirender.dataloader.object_array[((SkinningClientData)ibukirender.iroharender.clientdata).FrameID()];
////			OpenGLAnimationMemory openglanimationmemory = (OpenGLAnimationMemory)OBJECT_LIST.get(((SkinningClientData)ibukirender.iroharender.clientdata).FrameID());
//			r.iroharender.initSkinning(BothDaIroha.IDA/*openglanimationmemory*/);
//			//s0-a
//			E e = this.c.i.getE();
//			float head_rot = (float)Math.toRadians(EntityMath.interpolateRotation(e.prevRotationYawHead, e.rotationYawHead, partialTicks));
//			float head_pitch = (float)Math.toRadians(e.prevRotationPitch + (e.rotationPitch - e.prevRotationPitch) * partialTicks);
//			float body_rot = (float)Math.toRadians(EntityMath.interpolateRotation(e.prevRotationYaw, e.rotationYaw, partialTicks));
//			float net_head_yaw = head_rot - body_rot;
//
//			if (head_pitch > 1.04719755119659774615F)
//			{
//				head_pitch = 1.04719755119659774615F;
//			}
//			else if (head_pitch < -1.04719755119659774615F)
//			{
//				head_pitch = -1.04719755119659774615F;
//			}
//
//			SummerIroha.setAnimation(r.iroharender.skinning_float_array, r.iroharender.frame_int_array, head_pitch, head_rot, net_head_yaw);
//			//e0-a
//			r.iroharender.setSkinning(BothDaIroha.IDA/*openglanimationmemory*/);
////			MemoA2 a2 = A2_MAP.get();
//			MemoF2 f2 = F2_LIST.get(BothDaIroha.IDA.S_FrameID());
//			float[] c_vec4 = f2.get3DSkinning(r.iroharender.skinning_float_array, (float)ox, (float)oy, (float)oz, 0.168471F, -0.111817F, -0.35F / (s / 1.5F), SummerIroha.IV_INT_ARRAY[12], SummerIroha.IV_INT_ARRAY[13]);
//			r.apply3DSkinningVec4(c_vec4);
////			GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
//
//			float[] c_mat4 = f2.getMat43DSkinning(r.iroharender.skinning_float_array, SummerIroha.IV_INT_ARRAY[12], SummerIroha.IV_INT_ARRAY[13]);
//			float[] mat4 = new float[]
//			{
//				c_mat4[0], c_mat4[4], c_mat4[8], 0,
//				c_mat4[1], c_mat4[5], c_mat4[9], 0,
//				c_mat4[2], c_mat4[6], c_mat4[10], 0,
//				0, 0, 0, 1.0F
//			};
//			RenderS.setFloatBuffer(mat4);
////			GL11.glTranslated(-0.25F, -0.5F, -0.5F);
////			GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
////			GL11.glMultMatrix(OpenGLCurrentMemory.OPENGL_FLOATBUFFER);
//			GL11.glScalef(1.0F / s, 1.0F / s, 1.0F / s);
//			GL11.glTranslated(-ox, -oy, -oz);
//		}
//
//		super.doRender(rendere, ox, oy, oz, partialTicks);
//		GL11.glPopMatrix();
//	}
}
