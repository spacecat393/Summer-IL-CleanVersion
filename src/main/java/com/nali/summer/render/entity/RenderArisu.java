package com.nali.summer.render.entity;

import com.nali.list.da.BothDaArisu;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.IRenderS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArisu
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaArisu, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaArisu, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaArisu, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaArisu, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaArisu, ?, E, I, MC, MB, MR>
> extends com.nali.list.render.RenderArisu<IE, E, I, MC, MB, MR, C> implements IRenderS<BothDaArisu, RenderArisu<IE, E, I, MC, MB, MR, C>>
{
	@Override
	public void drawLater(RenderArisu<IE, E, I, MC, MB, MR, C> r, int index)
	{
		int i = index - BothDaArisu.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			IRenderS.super.drawLater(r, index);
		}
	}
}
