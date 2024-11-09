package com.nali.summer.entity.memo.client.ibuki;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderIbuki;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.render.RenderS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.FRenderE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.summer.entity.memo.client.iroha.ClientIroha;
import com.nali.summer.entity.memo.client.iroha.MixRenderIroha;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class MixRenderIbuki
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderIbuki<IE, E, I, MC, MB, ?, C, BD, RC>,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E>,
	MC extends MixCIE<RC, R, BD, E, I, MB, ?, C>,
	MB extends MixBoxSleInv<RC, R, BD, E, I, MC, ?, C>,
	C extends ClientLeInv<IE, RC, R, BD, E, I, MC, MB, ?> & IClientERsInv
> extends MixRenderSleInv<IE, RC, R, BD, E, I, MC, MB, C>
{
	public MixRenderIbuki(C c)
	{
		super(c);
		this.shadow_opaque = 0.5F;
		this.shadow_size = 0.25F;
	}

	@Override
	public void multiplyAnimation()
	{
		float head_pitch = this.head_pitch;
		if (this.head_pitch > 1.04719755119659774615F)
		{
			head_pitch = 1.04719755119659774615F;
		}
		else if (this.head_pitch < -1.04719755119659774615F)
		{
			head_pitch = -1.04719755119659774615F;
		}
		M4x4 body_m4x4 = new Quaternion(0.0F, 0.0F, this.body_rot).getM4x4();
		M4x4 head_m4x4 = new Quaternion(-head_pitch, 0, this.net_head_yaw).getM4x4();

		R r = this.c.r;
		head_m4x4.multiply(r.skinning_float_array, 39*16);

		body_m4x4.multiply(r.skinning_float_array, 0);
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


	@Override
	public void doRender(FRenderE<E> rendere, double ox, double oy, double oz, float partialTicks)
	{
		GL11.glPushMatrix();

		if ((this.c.sync_byte_array[0] & 128) == 128)
		{
			R r = this.c.r;
			GL11.glTranslated(ox, oy, oz);
			float s = this.c.i.getE().getDataManager().get(this.c.i.getFloatDataParameterArray()[1]);
			GL11.glScalef(s, s, s);
			GL11.glTranslated(-ox, -oy, -oz);
//			OpenGLAnimationMemory openglanimationmemory = ibukirender.dataloader.openglanimationmemory_list.get(((SkinningClientData)ibukirender.iroharender.clientdata).FrameID());
//			OpenGLAnimationMemory openglanimationmemory = (OpenGLAnimationMemory)ibukirender.dataloader.object_array[((SkinningClientData)ibukirender.iroharender.clientdata).FrameID()];
//			OpenGLAnimationMemory openglanimationmemory = (OpenGLAnimationMemory)OBJECT_LIST.get(((SkinningClientData)ibukirender.iroharender.clientdata).FrameID());
			r.iroharender.initSkinning(/*openglanimationmemory*/);
			MixRenderIroha.setAnimation(this, r.iroharender);
			r.iroharender.setSkinning(/*openglanimationmemory*/);
			float[] c_vec4 = r.iroharender.get3DSkinning((float)ox, (float)oy, (float)oz, 0.168471F, -0.111817F, -0.35F / (s / 1.5F), ClientIroha.IV_INT_ARRAY[12], ClientIroha.IV_INT_ARRAY[13]);
			r.apply3DSkinningVec4(c_vec4);
//			GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);

			float[] c_mat4 = r.iroharender.getMat43DSkinning(ClientIroha.IV_INT_ARRAY[12], ClientIroha.IV_INT_ARRAY[13]);
			float[] mat4 = new float[]
			{
				c_mat4[0], c_mat4[4], c_mat4[8], 0,
				c_mat4[1], c_mat4[5], c_mat4[9], 0,
				c_mat4[2], c_mat4[6], c_mat4[10], 0,
				0, 0, 0, 1.0F
			};
			RenderS.setFloatBuffer(mat4);
//			GL11.glTranslated(-0.25F, -0.5F, -0.5F);
//			GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
//			GL11.glMultMatrix(OpenGLCurrentMemory.OPENGL_FLOATBUFFER);
			GL11.glScalef(1.0F / s, 1.0F / s, 1.0F / s);
			GL11.glTranslated(-ox, -oy, -oz);
		}

		super.doRender(rendere, ox, oy, oz, partialTicks);
		GL11.glPopMatrix();
	}
}
