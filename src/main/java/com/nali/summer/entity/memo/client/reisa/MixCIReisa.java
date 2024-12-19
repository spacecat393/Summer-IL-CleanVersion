package com.nali.summer.entity.memo.client.reisa;

import com.nali.list.da.BothDaReisa;
import com.nali.list.render.RenderReisa;
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
public class MixCIReisa
<
	IE extends InvLe,
	R extends RenderReisa<IE, E, I, ?, MB, MR, C>,
	E extends EntityLivingBase,
	I extends IMixE<BothDaReisa, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaReisa, R, E, I, ?, MR, C>,
	MR extends MixRenderReisa<IE, BothDaReisa, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaReisa, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaReisa, R, E, I, MB, MR, C>
{
	public int eyes_tick;

	public MixCIReisa(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		R r = this.c.r;
		I i = this.c.i;

		short key = r.key_short_array[0];

		E e = i.getE();
		if (e.ticksExisted % 200 == 0)
		{
			r.model_byte_array[0 / 8] &= 255-1;//255 - Math.pow(2, 0 % 8)
			r.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
			r.model_byte_array[8 / 8] &= 255-1;//255 - Math.pow(2, 8 % 8)
			this.eyes_tick = 20;
		}
		else if (--this.eyes_tick <= 0)
		{
			r.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
			r.model_byte_array[5 / 8] &= 255-32;//255 - Math.pow(2, 5 % 8)
			r.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
		}

		if (key > 125 && key < 227)
		{
			r.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
		}
		else
		{
			r.model_byte_array[6 / 8] &= 255-64;//255 - Math.pow(2, 6 % 8)
		}

		float scale = r.scale;
		if (key > 600 && key < 652)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = BothDaReisa.IDA.E_Width() * scale;
			e.height = BothDaReisa.IDA.E_Height() * scale;
		}

//		skinningrender.model_byte_array[3 / 8] &= 255-8;//255 - Math.pow(2, 3 % 8)
	}

	@Override
	public void onReadNBT()
	{
		R r = this.c.r;
		r.model_byte_array[0 / 8] &= 255-1;//255 - Math.pow(2, 0 % 8)
//		skinningrender.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
		r.model_byte_array[8 / 8] &= 255-1;//255 - Math.pow(2, 8 % 8)
		super.onReadNBT();
	}
}
