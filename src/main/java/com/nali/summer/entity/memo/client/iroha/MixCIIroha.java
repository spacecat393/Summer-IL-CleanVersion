package com.nali.summer.entity.memo.client.iroha;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderIroha;
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
public class MixCIIroha
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderIroha<IE, E, I, ?, MB, MR, C, BD, RC>,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E>,
	MB extends MixBoxSleInv<RC, R, BD, E, I, ?, MR, C>,
	MR extends MixRenderIroha<IE, RC, R, BD, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, RC, R, BD, E, I, ?, MB, MR> & IClientERsInv
> extends MixCIE<RC, R, BD, E, I, MB, MR, C>
{
	public MixCIIroha(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		R r = this.c.r;
		I i = this.c.i;

		int frame = r.frame_int_array[0];

		float scale = r.scale;
		E e = i.getE();
		if (frame > 257)
		{
			e.width = 1.7F * scale;
			e.height = 1.5F * scale;
//			skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
			r.model_byte_array[0] |= 16 | 32;
		}
		else
		{
			BD bd = i.getBD();
			e.width = bd.Width() * scale;
			e.height = bd.Height() * scale;
//			skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
			r.model_byte_array[0] &= 239 & 223;
		}
	}
}
