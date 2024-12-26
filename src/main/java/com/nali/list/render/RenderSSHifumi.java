package com.nali.list.render;

import com.nali.list.da.BothDaSSHifumi;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderSSHifumi
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaSSHifumi, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSSHifumi, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaSSHifumi, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaSSHifumi, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaSSHifumi, ?, E, I, MC, MB, MR>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BothDaSSHifumi>
{
	public byte[] model_byte_array;

	public RenderSSHifumi()
	{
		super(BothDaSSHifumi.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaSSHifumi.IDA.O_EndPart() - BothDaSSHifumi.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 1;
//		this.texture_index_int_array[1] = 2;
//		this.texture_index_int_array[2] = 6;
//		this.texture_index_int_array[3] = 3;
//		this.texture_index_int_array[4] = 4;
//		this.texture_index_int_array[5] = 8;
//		this.texture_index_int_array[6] = 7;
//		this.texture_index_int_array[7] = 5;
//		this.texture_index_int_array[8] = 0;
//		this.texture_index_int_array[9] = 0;
//		this.texture_index_int_array[10] = 0;
//		this.texture_index_int_array[11] = 9;
//		this.texture_index_int_array[12] = 0;
		Arrays.fill(this.model_byte_array, (byte)255);
		this.model_byte_array[5 / 8] &= 255-32;//255 - Math.pow(2, 5 % 8)
	}

	@Override
	public void draw(int index)
	{
		int i = index - BothDaSSHifumi.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.draw(index);
		}
	}

	@Override
	public void drawLater(int index)
	{
		int i = index - BothDaSSHifumi.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater(index);
		}
	}

//	@Override
//	public void setGlow()
//	{
////		this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
//		super.setGlow();
//	}

//	public static float block(int i)
//	{
//		return i & 0xFFFF;
//	}
//
//	public static float sky(int i)
//	{
//		return (i >> 16) & 0xFFFF;
//	}

//	@Override
//	public void setTextureUniform(OpenGLObjectMemory openglobjectmemory, OpenGLObjectShaderMemory openglobjectshadermemory, int index)
//	{
//		GL20.glUniform1i(openglobjectshadermemory.uniformlocation_int_array[0], 0);
//		GL13.glActiveTexture(33984);
//		OpenGLBuffer.setTextureBuffer(Minecraft.getMinecraft().getFramebuffer().framebufferTexture, openglobjectmemory.texture_state);
//	}

//	@Override
//	public void setLightMapUniform(OpenGLObjectShaderMemory openglobjectshadermemory)
//	{
//		GL20.glUniform1i(openglobjectshadermemory.uniformlocation_int_array[1], 1);
//		GL13.glActiveTexture(33985);
//		OpenGLBuffer.setLightMapBuffer(Minecraft.getMinecraft().getFramebuffer().framebufferTexture);
//	}

//	@Override
//	public void updateLightCoord()
//	{
//		super.updateLightCoord();
//
//		int brightness = this.skinningentities.getBrightnessForRender();
//		this.lig_b = brightness & 0xFFFF;
//		this.lig_s = (brightness >> 16) & 0xFFFF;
//	}
}
