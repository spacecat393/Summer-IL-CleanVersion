package com.nali.list.render;

import com.nali.list.da.BothDaReisa;
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
public class RenderReisa
<
	IE extends InvLe,
	E extends EntityLivingBase,
	I extends IMixE<BothDaReisa, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaReisa, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaReisa, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaReisa, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaReisa, ?, E, I, MC, MB, MR>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BothDaReisa>
{
	public byte[] model_byte_array;

	public RenderReisa()
	{
		super(BothDaReisa.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaReisa.IDA.O_EndPart() - BothDaReisa.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 41;
//		this.texture_index_int_array[1] = 40;
//		this.texture_index_int_array[2] = 41;
//		this.texture_index_int_array[3] = 42;
//		this.texture_index_int_array[4] = 43;
//		this.texture_index_int_array[5] = 44;
//		this.texture_index_int_array[6] = 41;
//		this.texture_index_int_array[7] = 45;
//		this.texture_index_int_array[8] = 44;
//		this.texture_index_int_array[9] = 46;
//		this.texture_index_int_array[10] = 9;
		Arrays.fill(this.model_byte_array, (byte)255);
		this.model_byte_array[3 / 8] &= 255-8;
	}

	@Override
	public void draw(int index)
	{
		int i = index - BothDaReisa.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.draw(index);
		}
	}

	@Override
	public void drawLater(int index)
	{
		int i = index - BothDaReisa.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater(index);
		}
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[9 / 8] ^= 2;//Math.pow(2, 9 % 8)
//		super.setGlow();
//	}
}
