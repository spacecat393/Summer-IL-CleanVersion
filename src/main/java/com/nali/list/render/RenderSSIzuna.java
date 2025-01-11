package com.nali.list.render;

import com.nali.list.da.BothDaSSIzuna;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderSSIzuna
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaSSIzuna, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSSIzuna, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaSSIzuna, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaSSIzuna, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaSSIzuna, ?, E, I, MC, MB, MR>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BothDaSSIzuna>
{
	public byte[] model_byte_array;

	public RenderSSIzuna()
	{
		super(BothDaSSIzuna.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaSSIzuna.IDA.O_EndPart() - BothDaSSIzuna.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 33;
//		this.texture_index_int_array[1] = 34;
//		this.texture_index_int_array[2] = 35;
//		this.texture_index_int_array[3] = 34;
//		this.texture_index_int_array[4] = 36;
//		this.texture_index_int_array[5] = 37;
//		this.texture_index_int_array[6] = 38;
//		this.texture_index_int_array[7] = 9;
//		this.texture_index_int_array[8] = 39;
		Arrays.fill(this.model_byte_array, (byte)255);
	}

	@Override
	public void draw(int index)
	{
		int i = index - BothDaSSIzuna.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.draw(index);
		}
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
//		super.setGlow();
//	}
}
