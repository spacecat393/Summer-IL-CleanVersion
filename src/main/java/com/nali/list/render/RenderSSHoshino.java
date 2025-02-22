package com.nali.list.render;

import com.nali.list.da.BothDaSSHoshino;
import com.nali.render.RenderS;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.client.ClientLe;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.IRenderS;
import com.nali.summer.render.SummerRenderSe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderSSHoshino
<
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
	MB extends MixBoxSle<BD, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BD, ?, E, I, MC, MB, C>,
	C extends ClientLe<BD, ?, E, I, MC, MB, MR>,
	BD extends BothDaSSHoshino,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BD, R>
{
	public byte[] model_byte_array;

	public RenderSSHoshino()
	{
		super((BD)BothDaSSHoshino.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaSSHoshino.IDA.O_EndPart() - BothDaSSHoshino.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 47;
//		this.texture_index_int_array[1] = 48;
//		this.texture_index_int_array[2] = 49;
//		this.texture_index_int_array[3] = 47;
//		this.texture_index_int_array[4] = 50;
//		this.texture_index_int_array[5] = 51;
//		this.texture_index_int_array[6] = 52;
//		this.texture_index_int_array[7] = 52;
//		this.texture_index_int_array[8] = 52;
//		this.texture_index_int_array[9] = 53;
//		this.texture_index_int_array[10] = 9;
//		this.texture_index_int_array[11] = 50;
		Arrays.fill(this.model_byte_array, (byte)255);
	}

	@Override
	public void drawLater()
	{
		int i = this.i - BothDaSSHoshino.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater();
		}
	}

//	@Override
//	public void draw()
//	{
//		int i = this.i - BothDaSSHoshino.IDA.O_StartPart();
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
