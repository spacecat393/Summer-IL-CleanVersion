package com.nali.summer.entity.memo.client.natsu;

import com.nali.list.da.BothDaNatsu;
import com.nali.list.render.RenderNatsu;
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
public class MixCINatsu
<
	IE extends InvLe,
	R extends RenderNatsu<IE, E, I, ?, MB, MR, C>,
	E extends EntityLivingBase,
	I extends IMixE<BothDaNatsu, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaNatsu, R, E, I, ?, MR, C>,
	MR extends MixRenderNatsu<IE, BothDaNatsu, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaNatsu, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaNatsu, R, E, I, MB, MR, C>
{
	public MixCINatsu(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		R r = this.c.r;
		I i = this.c.i;

		int frame = r.frame_int_array[0];

		if (frame > 255)
		{
			r.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
			r.model_byte_array[10 / 8] |= 4;//Math.pow(2, 10 % 8)
		}
		else
		{
			r.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
			r.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
		}

		r.model_byte_array[8 / 8] = (byte)((frame > 313 && frame < 338) || (frame > 341 && frame < 383) || (frame > 827 && frame < 850)
			? r.model_byte_array[8 / 8] | 1//Math.pow(2, 8 % 8)
			: r.model_byte_array[8 / 8] & 254);//255 - Math.pow(2, 8 % 8)
		r.model_byte_array[9 / 8] = (byte)((frame > -1 && frame < 226) || (frame > 306 && frame < 388) || (frame > 868 && frame < 1029)
			? r.model_byte_array[9 / 8] | 2//Math.pow(2, 9 % 8)
			: r.model_byte_array[9 / 8] & 253);//255 - Math.pow(2, 9 % 8)

		float scale = r.scale;
		E e = i.getE();
		if (frame > 765 && frame < 823)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = BothDaNatsu.IDA.E_Width() * scale;
			e.height = BothDaNatsu.IDA.E_Height() * scale;
		}
	}
}
