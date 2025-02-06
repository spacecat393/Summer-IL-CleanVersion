package com.nali.list.render;

import com.nali.list.da.BothDaIbuki;
import com.nali.render.RenderS;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.IRenderS;
import com.nali.summer.render.SummerRenderSe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderIbuki
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BD, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BD, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BD, ?, E, I, MC, MB, MR>,
	BD extends BothDaIbuki,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BD, R>
{
	public RenderIroha iroharender;
	public byte[] model_byte_array;

	public RenderIbuki()
	{
		super((BD)BothDaIbuki.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaIbuki.IDA.O_EndPart() - BothDaIbuki.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 76;
//		this.texture_index_int_array[1] = 77;
//		this.texture_index_int_array[2] = 77;
//		this.texture_index_int_array[3] = 77;
//		this.texture_index_int_array[4] = 78;
//		this.texture_index_int_array[5] = 79;
//		this.texture_index_int_array[6] = 80;
//		this.texture_index_int_array[7] = 80;
//		this.texture_index_int_array[8] = 80;
//		this.texture_index_int_array[9] = 81;
//		this.texture_index_int_array[10] = 82;
//		this.texture_index_int_array[11] = 81;
//		this.texture_index_int_array[12] = 81;
//		this.texture_index_int_array[13] = 83;
//		this.texture_index_int_array[14] = 9;
		this.iroharender = new RenderIroha();
		Arrays.fill(this.model_byte_array, (byte)255);
	}

	@Override
	public void drawLater()
	{
		int i = this.i - BothDaIbuki.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater();
		}
	}

//	@Override
//	public void draw()
//	{
//		int i = this.i - BothDaIbuki.IDA.O_StartPart();
//		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
//		{
//			super.draw();
//		}
//	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[13 / 8] ^= 32;//Math.pow(2, 13 % 8)
//		super.setGlow();
//	}
}
