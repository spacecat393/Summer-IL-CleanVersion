package com.nali.summer.entity.memo.client.reisa;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderReisa;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixCIReisa
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderReisa<IE, E, I, ?, MB, MR, C, BD, RC>,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E>,
	MB extends MixBoxSleInv<RC, R, BD, E, I, ?, MR, C>,
	MR extends MixRenderReisa<IE, RC, R, BD, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, RC, R, BD, E, I, ?, MB, MR> & IClientERsInv
> extends MixCIE<RC, R, BD, E, I, MB, MR, C>
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

		int frame = r.frame_int_array[0];

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

		if (frame > 125 && frame < 227)
		{
			r.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
		}
		else
		{
			r.model_byte_array[6 / 8] &= 255-64;//255 - Math.pow(2, 6 % 8)
		}

		float scale = r.scale;
		if (frame > 600 && frame < 652)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			BD bd = i.getBD();
			e.width = bd.Width() * scale;
			e.height = bd.Height() * scale;
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
