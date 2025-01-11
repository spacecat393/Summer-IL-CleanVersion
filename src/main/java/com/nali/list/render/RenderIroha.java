package com.nali.list.render;

import com.nali.list.da.BothDaIroha;
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
public class RenderIroha
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaIroha, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaIroha, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaIroha, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaIroha, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaIroha, ?, E, I, MC, MB, MR>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BothDaIroha>
{
	public byte[] model_byte_array;

	public RenderIroha()
	{
		super(BothDaIroha.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaIroha.IDA.O_EndPart() - BothDaIroha.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 84;
//		this.texture_index_int_array[1] = 85;
//		this.texture_index_int_array[2] = 85;
//		this.texture_index_int_array[3] = 86;
//		this.texture_index_int_array[4] = 87;
//		this.texture_index_int_array[5] = 88;
//		this.texture_index_int_array[6] = 89;
//		this.texture_index_int_array[7] = 90;
//		this.texture_index_int_array[8] = 91;
//		this.texture_index_int_array[9] = 92;
//		this.texture_index_int_array[10] = 9;
		Arrays.fill(this.model_byte_array, (byte)255);
	}

	@Override
	public void draw(int index)
	{
		int i = index - BothDaIroha.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.draw(index);
		}
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[9 / 8] ^= 2;//Math.pow(2, 9 % 8)
//		super.setGlow();
//	}
}
