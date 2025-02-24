package com.nali.summer.entity.memo.client.arisu;

import com.nali.list.da.BothDaArisu;
import com.nali.list.render.RenderArisu;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.client.ClientLe;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSle;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixCIArisu
<
	BD extends BothDaArisu,
	R extends RenderArisu<E, I, ?, MB, MR, C, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MB extends MixBoxSle<BD, R, E, I, ?, MR, C>,
	MR extends MixRenderSle<BD, R, E, I, ?, MB, C>,
	C extends ClientLe<BD, R, E, I, ?, MB, MR>
> extends MixCIE<BD, R, E, I, MB, MR, C>
{
	public MixCIArisu(C c)
	{
		super(c);
	}

	//!frame
//	@Override
//	public void updateBox()
//	{
//		R r = this.c.r;
//		I i = this.c.i;
//
//		short key = r.key_short_array[0];
//
//		if (key < 205)
//		{
////			skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
////			skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
//			r.model_byte_array[0] &= 239 & 191;
//		}
//		else
//		{
////			skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
////			skinningrender.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
//			r.model_byte_array[0] |= 16 | 64;
//		}
//
//		float scale = r.scale;
//		E e = i.getE();
//		if (key > 583 && key < 615)
//		{
////			e.width = BothDaArisu.IDA.E_Width() * scale;
//			e.height = 0.65F * scale;
//		}
////		else if (key > 737 && key < 784)
////		{
////			e.width = 1.5F * scale;
////			e.height = 0.2F * scale;
////		}
//		else
//		{
////			e.width = BothDaArisu.IDA.E_Width() * scale;
//			e.height = BothDaArisu.IDA.E_Height() * scale;
//		}
//		e.width = BothDaArisu.IDA.E_Width() * scale;
//	}
}
