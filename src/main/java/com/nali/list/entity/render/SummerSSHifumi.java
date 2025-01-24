package com.nali.list.entity.render;

import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;
import com.nali.render.RenderS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import com.nali.system.BothLoader;
import com.nali.system.opengl.memo.MemoA2;
import com.nali.system.opengl.memo.MemoF2;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

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

	@Override
	public void doRender(E e, double ox, double oy, double oz, float entityYaw, float partialTicks)
	{
//		super.doRender(e, ox, oy, oz, entityYaw, partialTicks);
		IMixE imixe = (IMixE)e;
		ClientE c = (ClientE)imixe.getB();

		//s0-test
		RenderS r = (RenderS)c.r;
		IBothDaS s_bd = (IBothDaS)imixe.getBD();
		IBothDaO o_bd = (IBothDaO)imixe.getBD();

		GL11.glPointSize(10.0F);

//					float epsilon = 0.00001F;
		MemoF2 f2 = BothLoader.F2_LIST.get(s_bd.S_FrameID());
		for (int o = o_bd.O_StartPart(); o < o_bd.O_EndPart(); ++o)
		{
			MemoA2 ra2 = BothLoader.A2_MAP.get(o);

			int[] index_int_array = ra2.index_int_array;
//						float[] vertex_float_array = ra2.vertex_float_array;

//						for (int i = 0; i < vertex_float_array.length; i += 3)
			for (int i = 0; i < index_int_array.length; ++i)
			{
//							float ix = vertex_float_array[i];
//							float iy = vertex_float_array[i + 1];
//							float iz = vertex_float_array[i + 2];
//
//							float ax = Math.abs(ix - 0.000026F);
//							float ay = Math.abs(iy - -0.101241F);
//							float az = Math.abs(iz - 0.671901F);
//							if
//							(
//								ax < epsilon &&
//								ay < epsilon &&
//								az < epsilon
//							)
//							{
//								Nali.warn("I " + i);
//								Nali.warn("X " + ax + "   " + ix);
//								Nali.warn("Y " + ay + "   " + iy);
//								Nali.warn("Z " + az + "   " + iz);
//							}

				float[] pos_vec4 = f2.getScale3DSkinning(r.scale, r.skinning_float_array, (float)e.posX, (float)e.posY, (float)e.posZ, 0, 0, 0, o, i);

				double x = pos_vec4[0] / pos_vec4[3];
				double y = pos_vec4[1] / pos_vec4[3];
				double z = pos_vec4[2] / pos_vec4[3];

				GlStateManager.disableTexture2D();
				GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);
				GL11.glBegin(GL11.GL_POINTS);
				GL11.glVertex3d(x, y, z);
				GL11.glEnd();
				GlStateManager.enableTexture2D();
			}
		}
		//e0-test
	}
}
