package com.nali.list.render;

import com.nali.list.da.BothDaSeaHouse;
import com.nali.render.RenderS;
import com.nali.small.render.IRenderS;
import com.nali.summer.render.SummerRenderS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderSeaHouse
<
	BD extends BothDaSeaHouse,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends SummerRenderS<BD, R>
{
	public byte[] model_byte_array;

	public RenderSeaHouse()
	{
		super((BD)BothDaSeaHouse.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaSeaHouse.IDA.O_EndPart() - BothDaSeaHouse.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 32;
//		this.texture_index_int_array[1] = 32;
//		this.texture_index_int_array[2] = 31;
		Arrays.fill(this.model_byte_array, (byte)255);
	}

//	@Override
//	public void draw()
//	{
//		int i = this.i - BothDaSeaHouse.IDA.O_StartPart();
//		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
//		{
//			super.draw();
//		}
//	}

	@Override
	public void drawLater()
	{
		int i = this.i - BothDaSeaHouse.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater();
		}
	}
}
