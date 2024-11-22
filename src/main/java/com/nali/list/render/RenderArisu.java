package com.nali.list.render;

import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.list.da.BothDaArisu;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderArisu
<
	IE extends InvLe,
	E extends EntityLivingBase,
	I extends IMixE<BothDaArisu, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaArisu, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaArisu, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaArisu, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaArisu, ?, E, I, MC, MB, MR>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BothDaArisu>
{
	public byte[] model_byte_array;

	public RenderArisu()
	{
		super(BothDaArisu.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaArisu.IDA.O_EndPart() - BothDaArisu.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 19;
//		this.texture_index_int_array[1] = 20;
//		this.texture_index_int_array[2] = 21;
//		this.texture_index_int_array[3] = 20;
//		this.texture_index_int_array[4] = 22;
//		this.texture_index_int_array[5] = 23;
//		this.texture_index_int_array[6] = 22;
//		this.texture_index_int_array[7] = 24;
//		this.texture_index_int_array[8] = 9;
		Arrays.fill(this.model_byte_array, (byte)255);
	}

	@Override
	public void draw(int index)
	{
		int i = index - BothDaArisu.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.draw(index);
		}
	}

	@Override
	public void drawLater(int index)
	{
		int i = index - BothDaArisu.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater(index);
		}
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[4 / 8] ^= 16;//Math.pow(2, 4 % 8)
//		this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//		super.setGlow();
//	}
}
