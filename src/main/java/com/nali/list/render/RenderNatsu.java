package com.nali.list.render;

import com.nali.list.da.BothDaNatsu;
import com.nali.render.RenderS;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.client.ClientLe;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.IRenderS;
import com.nali.summer.render.SummerRenderSe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderNatsu
<
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BD, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BD, ?, E, I, MC, MB, C>,
	C extends ClientLe<BD, ?, E, I, MC, MB, MR>,
	BD extends BothDaNatsu,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BD, R>
{
	public byte[] model_byte_array;

	public RenderNatsu()
	{
		super((BD)BothDaNatsu.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaNatsu.IDA.O_EndPart() - BothDaNatsu.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 10;
//		this.texture_index_int_array[1] = 11;
//		this.texture_index_int_array[2] = 12;
//		this.texture_index_int_array[3] = 12;
//		this.texture_index_int_array[4] = 13;
//		this.texture_index_int_array[5] = 14;
//		this.texture_index_int_array[6] = 18;
//		this.texture_index_int_array[7] = 16;
//		this.texture_index_int_array[8] = 11;
//		this.texture_index_int_array[9] = 17;
//		this.texture_index_int_array[10] = 15;
//		this.texture_index_int_array[11] = 9;
		Arrays.fill(this.model_byte_array, (byte)255);
	}

	@Override
	public void drawLater()
	{
		int i = this.i - BothDaNatsu.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater();
		}
	}

//	@Override
//	public void draw()
//	{
//		int i = this.i - BothDaNatsu.IDA.O_StartPart();
//		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
//		{
//			super.draw();
//		}
//	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
//		super.setGlow();
//	}
}
