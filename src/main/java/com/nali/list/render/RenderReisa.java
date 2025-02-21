package com.nali.list.render;

import com.nali.list.da.BothDaReisa;
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
public class RenderReisa
<
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BD, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BD, ?, E, I, MC, MB, C>,
	C extends ClientLe<BD, ?, E, I, MC, MB, MR>,
	BD extends BothDaReisa,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BD, R>
{
	public byte[] model_byte_array;

	public RenderReisa()
	{
		super((BD)BothDaReisa.IDA);
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
	public void drawLater()
	{
		int i = this.i - BothDaReisa.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater();
		}
	}

//	@Override
//	public void draw()
//	{
//		int i = this.i - BothDaReisa.IDA.O_StartPart();
//		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
//		{
//			super.draw();
//		}
//	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[9 / 8] ^= 2;//Math.pow(2, 9 % 8)
//		super.setGlow();
//	}
}
