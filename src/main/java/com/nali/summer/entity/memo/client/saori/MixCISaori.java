package com.nali.summer.entity.memo.client.saori;

import com.nali.list.da.BothDaSaori;
import com.nali.list.render.RenderSaori;
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
public class MixCISaori
<
	BD extends BothDaSaori,
	R extends RenderSaori<E, I, ?, MB, MR, C, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MB extends MixBoxSle<BD, R, E, I, ?, MR, C>,
	MR extends MixRenderSle<BD, R, E, I, ?, MB, C>,
	C extends ClientLe<BD, R, E, I, ?, MB, MR>
> extends MixCIE<BD, R, E, I, MB, MR, C>
{
	public MixCISaori(C c)
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
//		if (key > 889 && key < 943)
//		{
//			e.width = 1.5F * scale;
//			e.height = 0.2F * scale;
//		}
//		else
//		{
//			e.width = BothDaSaori.IDA.E_Width() * scale;
//			e.height = BothDaSaori.IDA.E_Height() * scale;
//		}
//	}
}
