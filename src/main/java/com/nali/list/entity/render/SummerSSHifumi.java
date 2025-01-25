package com.nali.list.entity.render;

import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.render.RenderO;
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
		IMixE imixe = (IMixE)e;
		ClientE c = (ClientE)imixe.getB();

		//s0-test
		RenderS r = (RenderS)c.r;
		IBothDaS s_bd = (IBothDaS)imixe.getBD();
		IBothDaO o_bd = (IBothDaO)imixe.getBD();

		GL11.glPointSize(3.0F);

//					float epsilon = 0.00001F;
		MemoF2 f2 = BothLoader.F2_LIST.get(s_bd.S_FrameID());

		f2.initSkinning(s_bd, r.skinning_float_array);
		f2.setSkinning(s_bd, r.skinning_float_array, r.key_short_array);
//		{
//			{
//				int max_frame = s_bd.S_MaxFrame();
//				short max_key = f2.max_key;
//
//				for (int i = 0; i < f2.bone; ++i)
//				{
//					for (int l = 0; l < max_frame; ++l)
//					{
//						M4x4.multiply(f2.transforms_float_array, r.skinning_float_array, (r.key_short_array[l] + max_key * i) * 16, i * 16);
//					}
//
//					M4x4.inverse(r.skinning_float_array, i * 16);
//				}
//			}
//		}
//		SummerSSHifumi.multiplyVec4Mat4();

		RenderO.take();
		GL11.glPushMatrix();
		GL11.glTranslated(ox, oy, oz);
		GL11.glRotatef(-90, 1, 0, 0);
		GL11.glScalef(r.scale, r.scale, r.scale);
		r.draw(o_bd);
		GL11.glPopMatrix();
		RenderO.free();
//		super.doRender(e, ox, oy, oz, entityYaw, partialTicks);

//		GL11.glPushMatrix();
//		GL11.glTranslated(ox, oy, oz);
//		GL11.glRotatef(-90, 1, 0, 0);
//		GL11.glScalef(r.scale, r.scale, r.scale);

//		for (int i = 0; i < r.skinning_float_array.length / 16; ++i)
//		{
//			M4x4.inverse(r.skinning_float_array, i);
//		}

		GlStateManager.disableTexture2D();
		GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);
		GL11.glBegin(GL11.GL_POINTS);
//		GL11.glBegin(GL11.GL_LINES);

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

				float[] pos_vec4 = this.getScale3DSkinning(f2, r.scale, r.skinning_float_array, (float)ox, (float)oy, (float)oz, 0, 0, 0, o, i);

				double x = pos_vec4[0] / pos_vec4[3];
				double y = pos_vec4[1] / pos_vec4[3];
				double z = pos_vec4[2] / pos_vec4[3];

				GL11.glVertex3d(x, y, z);
//				GL11.glVertex4d(pos_vec4[0], pos_vec4[1], pos_vec4[2], pos_vec4[3]);
			}
		}

//		GL11.glVertex3d((float)ox, (float)oy, (float)oz);
		GL11.glEnd();
		GlStateManager.enableTexture2D();
		//e0-test

//		GL11.glPopMatrix();
	}

	public float[] getScale3DSkinning(MemoF2 f2, float scale, float[] skinning_float_array, float x, float y, float z, float x0, float y0, float z0, int o, int i)
	{
		MemoA2 ra2 = BothLoader.A2_MAP.get(o);

		int[] index_int_array = ra2.index_int_array;
		float[] vertex_float_array = ra2.vertex_float_array;

		int n = index_int_array[i];
		int vi = n * 3;

		byte max_joint = ra2.max_joint;
		float[] main_vec4_float_array = new float[4];
		float[] temp_vec4_float_array = new float[4];

		//remove texture state later memog
//		float weights_debug = 0;
		max_joint = 4;//array leak should get w & j first bc mix 4
		int nj = n * max_joint;
		for (int j = 0; j < max_joint; ++j)
		{
			int ji = nj + j;
			float weights = ra2.weight_float_array[ji];

			if (weights != 0)
			{
				short joint = ra2.joint_short_array[ji];

				temp_vec4_float_array[0] = vertex_float_array[vi] + x0;
				temp_vec4_float_array[1] = vertex_float_array[vi + 1] + y0;
				temp_vec4_float_array[2] = vertex_float_array[vi + 2] + z0;
				temp_vec4_float_array[3] = 1.0F;

				byte[] bone_byte_array = f2.bone_2d_byte_array[joint];
				//				for (int b = f2.bone_2d_byte_array[joint].length - 1; b > -1; --b)
				for (byte b : bone_byte_array)
				{
					int index = (b & 0xFF) * 16;
//					float[] bindpose_mat4 = new float[16], skinning_mat4 = new float[16];
//					System.arraycopy(f2.bind_pose_float_array, index, bindpose_mat4, 0, 16);
//					System.arraycopy(skinning_float_array, index, skinning_mat4, 0, 16);

//					M4x4.inverse(bindpose_mat4, 0);
					//start with inv should check server and client same values
					temp_vec4_float_array = multiplyVec4Mat4(temp_vec4_float_array, f2.inv_bind_pose_float_array, index);

//					M4x4.inverse(skinning_mat4, 0);
					temp_vec4_float_array = multiplyVec4Mat4(temp_vec4_float_array, skinning_float_array, index);

//					M4x4.inverse(bindpose_mat4, 0);
					temp_vec4_float_array = multiplyVec4Mat4(temp_vec4_float_array, f2.bind_pose_float_array, index);
				}

				temp_vec4_float_array[0] *= weights;
				temp_vec4_float_array[1] *= weights;
				temp_vec4_float_array[2] *= weights;
				temp_vec4_float_array[3] *= weights;
//				weights_debug += weights;

				main_vec4_float_array[0] += temp_vec4_float_array[0];
				main_vec4_float_array[1] += temp_vec4_float_array[1];
				main_vec4_float_array[2] += temp_vec4_float_array[2];
				main_vec4_float_array[3] += temp_vec4_float_array[3];

//				{
//					float ix = main_vec4_float_array[0];
//					float iy = main_vec4_float_array[1];
//					float iz = main_vec4_float_array[2];
//					float iw = main_vec4_float_array[3];
//					main_vec4_float_array[0] = (ix != 0) ? 1 / ix : Float.POSITIVE_INFINITY;
//					main_vec4_float_array[1] = (iy != 0) ? 1 / iy : Float.POSITIVE_INFINITY;
//					main_vec4_float_array[2] = (iz != 0) ? 1 / iz : Float.POSITIVE_INFINITY;
//					main_vec4_float_array[3] = (iw != 0) ? 1 / iw : Float.POSITIVE_INFINITY;
//				}
//				break;
			}
			else
			{
				break;
			}
		}
//		if (weights_debug < 1)
//		{
//			Nali.warn("weights_debug < 1");
//		}
//		if (weights_debug > 1)
//		{
//			Nali.warn("weights_debug > 1");
//		}

		main_vec4_float_array = M4x4.multiplyVec4Mat4(main_vec4_float_array, new float[]
		{
			scale, 0.0F, 0.0F, 0.0F,
			0.0F, scale, 0.0F, 0.0F,
			0.0F, 0.0F, scale, 0.0F,
			0.0F, 0.0F, 0.0F, 1.0F,
		});
		main_vec4_float_array = M4x4.multiplyVec4Mat4(main_vec4_float_array, new Quaternion(-1.571F, 0.0F, 0.0F).getM4x4().mat);
		main_vec4_float_array[0] += x;
		main_vec4_float_array[1] += y;
		main_vec4_float_array[2] += z;

		return main_vec4_float_array;
	}

	public static float[] multiplyVec4Mat4(float[] vec4, float[] mat4, int index)
	{
		float[] result = new float[4];
		for (int i = 0; i < 4; i++)
		{
			float sum = 0.0F;
			for (int j = 0; j < 4; j++)
			{
				sum += vec4[j] * mat4[index + i * 4 + j];
			}
			result[i] = sum;
		}
		return result;
	}
}
