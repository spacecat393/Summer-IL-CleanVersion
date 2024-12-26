package com.nali.summer.entity.memo.client.myuzu;

import com.nali.list.da.BothDaMYuzu;
import com.nali.list.render.RenderMYuzu;
import com.nali.small.entity.EntityLe;
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
public class MixCIMYuzu
<
	IE extends InvLe,
	R extends RenderMYuzu<IE, E, I, ?, MB, MR, C>,
	E extends EntityLe,
	I extends IMixE<BothDaMYuzu, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaMYuzu, R, E, I, ?, MR, C>,
	MR extends MixRenderMYuzu<IE, BothDaMYuzu, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaMYuzu, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaMYuzu, R, E, I, MB, MR, C>
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

		short key = r.key_short_array[0];

		float scale = r.scale;
		E e = i.getE();
		if (key < 513)
		{
			e.width = BothDaMYuzu.IDA.E_Width() * scale;
			e.height = 0.65F * scale;
		}
		else if (/*frame > 512 && */key < 564)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = BothDaMYuzu.IDA.E_Width() * scale;
			e.height = BothDaMYuzu.IDA.E_Height() * scale;
		}
	}

	@Override
	public void onReadNBT()
	{
		this.c.r.key_short_array[0] = 110;
		super.onReadNBT();
	}
}
