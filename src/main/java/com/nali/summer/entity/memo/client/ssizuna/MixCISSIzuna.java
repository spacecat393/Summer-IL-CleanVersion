package com.nali.summer.entity.memo.client.ssizuna;

import com.nali.list.da.BothDaSSIzuna;
import com.nali.list.render.RenderSSIzuna;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixCISSIzuna
<
	IE extends InvLe,
	R extends RenderSSIzuna<IE, E, I, ?, MB, MR, C>,
	E extends EntityLivingBase,
	I extends IMixE<BothDaSSIzuna, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaSSIzuna, R, E, I, ?, MR, C>,
	MR extends MixRenderSSIzuna<IE, BothDaSSIzuna, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaSSIzuna, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaSSIzuna, R, E, I, MB, MR, C>
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

		int frame = r.frame_int_array[0];

		if (frame < 264 || (frame > 562 && frame < 612))
		{
			r.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
		}
		else
		{
			r.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
		}

		float scale = r.scale;
		E e = i.getE();
		if (frame > 314 && frame < 351)
		{
			e.width = BothDaSSIzuna.IDA.E_Width() * scale;
			e.height = 0.65F * scale;
		}
		else if (frame > 263 && frame < 315)
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
