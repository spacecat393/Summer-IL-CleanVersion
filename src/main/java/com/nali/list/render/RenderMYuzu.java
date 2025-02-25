package com.nali.list.render;

import com.nali.list.da.BothDaMYuzu;
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

@SideOnly(Side.CLIENT)
public class RenderMYuzu
<
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
	MB extends MixBoxSle<BD, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BD, ?, E, I, MC, MB, C>,
	C extends ClientLe<BD, ?, E, I, MC, MB, MR>,
	BD extends BothDaMYuzu,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BD, R>
{
	public RenderMYuzu()
	{
		super((BD)BothDaMYuzu.IDA);
//		this.texture_index_int_array[0] = 54;
//		this.texture_index_int_array[1] = 55;
//		this.texture_index_int_array[2] = 56;
//		this.texture_index_int_array[3] = 56;
//		this.texture_index_int_array[4] = 57;
//		this.texture_index_int_array[5] = 58;
//		this.texture_index_int_array[6] = 59;
//		this.texture_index_int_array[7] = 60;
//		this.texture_index_int_array[8] = 9;
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//		super.setGlow();
//	}
}
