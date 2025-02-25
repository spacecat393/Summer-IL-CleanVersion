package com.nali.summer.entity.memo.client.iroha;

import com.nali.list.da.BothDaIroha;
import com.nali.list.render.RenderIroha;
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
public class MixCIIroha
<
	BD extends BothDaIroha,
	R extends RenderIroha<E, I, ?, MB, MR, C, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MB extends MixBoxSle<BD, R, E, I, ?, MR, C>,
	MR extends MixRenderSle<BD, R, E, I, ?, MB, C>,
	C extends ClientLe<BD, R, E, I, ?, MB, MR>
> extends MixCIE<BD, R, E, I, MB, MR, C>
{
	public MixCIIroha(C c)
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
//		float scale = r.scale;
//		E e = i.getE();
//		if (key > 257)
//		{
//			e.width = 1.7F * scale;
//			e.height = 1.5F * scale;
////			skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
////			skinningrender.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
//			r.model_byte_array[0] |= 16 | 32;
//		}
//		else
//		{
//			e.width = BothDaIroha.IDA.E_Width() * scale;
//			e.height = BothDaIroha.IDA.E_Height() * scale;
////			skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
////			skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
//			r.model_byte_array[0] &= 239 & 223;
//		}
//	}
}
