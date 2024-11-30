package com.nali.summer.entity.memo.client.arisu;

import com.nali.list.da.BothDaArisu;
import com.nali.list.render.RenderArisu;
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
public class MixCIArisu
<
	IE extends InvLe,
	R extends RenderArisu<IE, E, I, ?, MB, MR, C>,
	E extends EntityLivingBase,
	I extends IMixE<BothDaArisu, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaArisu, R, E, I, ?, MR, C>,
	MR extends MixRenderArisu<IE, BothDaArisu, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaArisu, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaArisu, R, E, I, MB, MR, C>
{
	public MixCIArisu(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		R r = this.c.r;
		I i = this.c.i;

		int frame = r.frame_int_array[0];

		if (frame < 205)
		{
//			skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
			r.model_byte_array[0] &= 239 & 191;
		}
		else
		{
//			skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
			r.model_byte_array[0] |= 16 | 64;
		}

		float scale = r.scale;
		E e = i.getE();
		if (frame > 834 && frame < 861)
		{
			e.width = BothDaArisu.IDA.E_Width() * scale;
			e.height = 0.65F * scale;
		}
		else if (frame > 737 && frame < 784)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = BothDaArisu.IDA.E_Width() * scale;
			e.height = BothDaArisu.IDA.E_Height() * scale;
		}
	}
}