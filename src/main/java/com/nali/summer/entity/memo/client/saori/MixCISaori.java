package com.nali.summer.entity.memo.client.saori;

import com.nali.list.da.BothDaSaori;
import com.nali.list.render.RenderSaori;
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
public class MixCISaori
<
	IE extends InvLe,
	R extends RenderSaori<IE, E, I, ?, MB, MR, C>,
	E extends EntityLivingBase,
	I extends IMixE<BothDaSaori, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaSaori, R, E, I, ?, MR, C>,
	MR extends MixRenderSaori<IE, BothDaSaori, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaSaori, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaSaori, R, E, I, MB, MR, C>
{
	public MixCISaori(C c)
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
		if (frame > 889 && frame < 943)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = BothDaSaori.IDA.E_Width() * scale;
			e.height = BothDaSaori.IDA.E_Height() * scale;
		}
	}
}
