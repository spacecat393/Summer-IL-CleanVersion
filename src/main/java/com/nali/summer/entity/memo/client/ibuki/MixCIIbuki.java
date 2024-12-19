package com.nali.summer.entity.memo.client.ibuki;

import com.nali.list.da.BothDaIbuki;
import com.nali.list.render.RenderIbuki;
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
public class MixCIIbuki
<
	IE extends InvLe,
	R extends RenderIbuki<IE, E, I, ?, MB, MR, C>,
	E extends EntityLivingBase,
	I extends IMixE<BothDaIbuki, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaIbuki, R, E, I, ?, MR, C>,
	MR extends MixRenderIbuki<IE, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaIbuki, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaIbuki, R, E, I, MB, MR, C>
{
	public int eyes_tick;

	public MixCIIbuki(C c)
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
//			skinningrender.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
//			skinningrender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
			r.model_byte_array[0] &= 254 & 253;
			r.model_byte_array[2 / 8] |= 4;//Math.pow(2, 2 % 8)
			r.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
			r.model_byte_array[12 / 8] |= 16;//Math.pow(2, 12 % 8)
			this.eyes_tick = 20;
		}
		else if (--this.eyes_tick <= 0)
		{
//			skinningrender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
//			skinningrender.model_byte_array[1 / 8] |= 2;//Math.pow(2, 1 % 8)
			r.model_byte_array[0] |= 1 | 2;
			r.model_byte_array[2 / 8] &= 251;//255 - Math.pow(2, 2 % 8)
			r.model_byte_array[11 / 8] |= 8;//Math.pow(2, 11 % 8)
			r.model_byte_array[12 / 8] &= 239;//255 - Math.pow(2, 12 % 8)
		}

		float scale = r.scale;

		if (key > 296 && key < 348)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = BothDaIbuki.IDA.E_Width() * scale;
			e.height = BothDaIbuki.IDA.E_Height() * scale;
		}
	}
//	@Override
//	public void updateClientObject()
//	{
//		super.updateClientObject();
//		r.iroharender.frame_int_array[0] = this.i.getE().getDataManager().get(this.i.getIntegerDataParameterArray()[1]);
//	}

	@Override
	public void onReadNBT()
	{
		R r = this.c.r;
//		skinningrender.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
//		skinningrender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
		r.model_byte_array[0] &= 254 & 253;
		r.model_byte_array[2 / 8] |= 4;//Math.pow(2, 2 % 8)
		r.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
		r.model_byte_array[12 / 8] |= 16;//Math.pow(2, 12 % 8)
		super.onReadNBT();
	}
}
