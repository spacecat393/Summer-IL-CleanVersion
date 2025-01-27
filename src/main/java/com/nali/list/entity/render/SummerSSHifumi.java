package com.nali.list.entity.render;

import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerSSHifumi
<
	E extends com.nali.list.entity.SummerSSHifumi
> extends FRenderSeInv<E>
{
	public SummerSSHifumi(RenderManager rendermanager)
	{
		super(rendermanager);
	}

//	@Override
//	public void doRender(E e, double ox, double oy, double oz, float entityYaw, float partialTicks)
//	{
////		super.doRender(e, ox, oy, oz, entityYaw, partialTicks);
//
//		//s0-test
//		ClientE c = (ClientE)e.getB();
//
//		RenderS r = (RenderS)c.r;
//		IBothDaS s_bd = (IBothDaS)e.getBD();
//		IBothDaO o_bd = (IBothDaO)e.getBD();
//
//		GL11.glPointSize(3.0F);
//
//		MemoF2 f2 = BothLoader.F2_LIST.get(s_bd.S_FrameID());
//
//		f2.initS(s_bd, r.skinning_float_array);
//		e.mulFrame(r.skinning_float_array, r.key_short_array, partialTicks);
//		f2.setS(s_bd, r.skinning_float_array, r.key_short_array);
//
//		RenderO.take();
//		GL11.glPushMatrix();
//		GL11.glTranslated(ox, oy, oz);
//		GL11.glRotatef(-90, 1, 0, 0);
//		GL11.glScalef(r.scale, r.scale, r.scale);
//		r.draw(o_bd);
//		GL11.glPopMatrix();
//		RenderO.free();
//
//		GlStateManager.disableTexture2D();
//		GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);
//		GL11.glBegin(GL11.GL_POINTS);
//
//		float epsilon = 0.00001F;
//		for (int o = o_bd.O_StartPart(); o < o_bd.O_EndPart(); ++o)
//		{
//			MemoA2 ra2 = BothLoader.A2_MAP.get(o);
//
//			int[] index_int_array = ra2.index_int_array;
//			float[] vertex_float_array = ra2.vertex_float_array;
//
//			for (int i = 0; i < index_int_array.length; ++i)
//			{
//				int iv = index_int_array[i] * 3;
//				float ix = vertex_float_array[iv];
//				float iy = vertex_float_array[iv + 1];
//				float iz = vertex_float_array[iv + 2];
//
//				float ax = Math.abs(ix - 0.000026F);
//				float ay = Math.abs(iy - -0.101241F);
//				float az = Math.abs(iz - 0.671901F);
//				if
//				(
//					ax < epsilon &&
//					ay < epsilon &&
//					az < epsilon
//				)
//				{
//					Nali.warn("I " + i);
//					Nali.warn("X " + ax + "   " + ix);
//					Nali.warn("Y " + ay + "   " + iy);
//					Nali.warn("Z " + az + "   " + iz);
//
//					float[] pos_vec4 = f2.getSV4FloatArray(r.scale, r.skinning_float_array, (float)ox, (float)oy, (float)oz, 0, 0, 0, o, i);
//
//					double x = pos_vec4[0] / pos_vec4[3];
//					double y = pos_vec4[1] / pos_vec4[3];
//					double z = pos_vec4[2] / pos_vec4[3];
//
//					GL11.glVertex3d(x, y, z);
//				}
//			}
//		}
//
//		GL11.glEnd();
//		GlStateManager.enableTexture2D();
//		//e0-test
//	}
}
