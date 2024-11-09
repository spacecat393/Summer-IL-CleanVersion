package com.nali.summer.entity.memo.client.myuzu;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderMYuzu;
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
public class MixCIMYuzu
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderMYuzu<IE, E, I, ?, MB, MR, C, BD, RC>,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E>,
	MB extends MixBoxSleInv<RC, R, BD, E, I, ?, MR, C>,
	MR extends MixRenderMYuzu<IE, RC, R, BD, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, RC, R, BD, E, I, ?, MB, MR> & IClientERsInv
> extends MixCIE<RC, R, BD, E, I, MB, MR, C>
{
	public MixCIMYuzu(C c)
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
		BD bd = i.getBD();
		E e = i.getE();
		if (frame < 513)
		{
			e.width = bd.Width() * scale;
			e.height = 0.65F * scale;
		}
		else if (/*frame > 512 && */frame < 564)
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

	@Override
	public void onReadNBT()
	{
		this.c.r.frame_int_array[0] = 110;
		super.onReadNBT();
	}
}
