package com.nali.summer.entity.memo.client.natsu;

import com.nali.list.da.BothDaNatsu;
import com.nali.list.render.RenderNatsu;
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
public class MixCINatsu
<
	IE extends InvLe,
	BD extends BothDaNatsu,
	R extends RenderNatsu<IE, E, I, ?, MB, MR, C, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BD, R, E, I, ?, MR, C>,
	MR extends MixRenderNatsu<IE, BD, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BD, R, E, I, ?, MB, MR>
> extends MixCIE<BD, R, E, I, MB, MR, C>
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

		short key = r.key_short_array[0];

		if (key > 224)
		{
			r.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
			r.model_byte_array[10 / 8] |= 4;//Math.pow(2, 10 % 8)
		}
		else
		{
			r.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
			r.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
		}

//		r.model_byte_array[8 / 8] = (byte)((key > 313 && key < 338) || (key > 341 && key < 383) || (key > 827 && key < 850)
//			? r.model_byte_array[8 / 8] | 1//Math.pow(2, 8 % 8)
//			: r.model_byte_array[8 / 8] & 254);//255 - Math.pow(2, 8 % 8)
		r.model_byte_array[8 / 8] = (byte)((key > 598 && key < 619)
			? r.model_byte_array[8 / 8] | 1//Math.pow(2, 8 % 8)
			: r.model_byte_array[8 / 8] & 254);//255 - Math.pow(2, 8 % 8)
//		r.model_byte_array[9 / 8] = (byte)((key > -1 && key < 226) || (key > 306 && key < 388) || (key > 868 && key < 1029)
//			? r.model_byte_array[9 / 8] | 2//Math.pow(2, 9 % 8)
//			: r.model_byte_array[9 / 8] & 253);//255 - Math.pow(2, 9 % 8)
		r.model_byte_array[9 / 8] = (byte)(key < 225
			? r.model_byte_array[9 / 8] | 2//Math.pow(2, 9 % 8)
			: r.model_byte_array[9 / 8] & 253);//255 - Math.pow(2, 9 % 8)

		float scale = r.scale;
		E e = i.getE();
		if (key > 536 && key < 593)
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
