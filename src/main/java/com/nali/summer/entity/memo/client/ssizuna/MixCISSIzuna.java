package com.nali.summer.entity.memo.client.ssizuna;

import com.nali.list.da.BothDaSSIzuna;
import com.nali.list.render.RenderSSIzuna;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixCISSIzuna
<
	IE extends InvLe,
	BD extends BothDaSSIzuna,
	R extends RenderSSIzuna<IE, E, I, ?, MB, MR, C, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BD, R, E, I, ?, MR, C>,
	MR extends MixRenderSSIzuna<IE, BD, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BD, R, E, I, ?, MB, MR>
> extends MixCIE<BD, R, E, I, MB, MR, C>
{
	public MixCISSIzuna(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		R r = this.c.r;
		I i = this.c.i;

		short key = r.key_short_array[0];

		if (key < 264 || (key > 562 && key < 612))
		{
			r.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
		}
		else
		{
			r.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
		}

		float scale = r.scale;
		E e = i.getE();
		if (key > 314 && key < 351)
		{
			e.width = BothDaSSIzuna.IDA.E_Width() * scale;
			e.height = 0.65F * scale;
		}
		else if (key > 263 && key < 315)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = BothDaSSIzuna.IDA.E_Width() * scale;
			e.height = BothDaSSIzuna.IDA.E_Height() * scale;
		}
	}
}
