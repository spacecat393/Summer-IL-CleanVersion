package com.nali.summer.entity.memo.client.arisu;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderArisu;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.sound.ISoundDaLe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixCIArisu
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderArisu<IE, E, I, ?, MB, MR, C, SD, BD, RC>,
	SD extends ISoundDaLe,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	MB extends MixBoxSleInv<RC, R, SD, BD, E, I, ?, MR, C>,
	MR extends MixRenderArisu<IE, RC, R, SD, BD, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, RC, R, SD, BD, E, I, ?, MB, MR> & IClientERsInv
> extends MixCIE<RC, R, BD, E, I, MB, MR, C>
{
	public MixCIArisu(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		int frame = this.c.r.frame_int_array[0];

		if (frame < 205)
		{
//			skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
			this.c.r.model_byte_array[0] &= 239 & 191;
		}
		else
		{
//			skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
			this.c.r.model_byte_array[0] |= 16 | 64;
		}

		float scale = this.c.r.scale;
		BD bd = this.c.i.getBD();
		E e = this.c.i.getE();
		if (frame > 834 && frame < 861)
		{
			e.width = bd.Width() * scale;
			e.height = 0.65F * scale;
		}
		else if (frame > 737 && frame < 784)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = bd.Width() * scale;
			e.height = bd.Height() * scale;
		}
	}
}
