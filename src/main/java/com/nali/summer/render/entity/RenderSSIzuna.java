package com.nali.summer.render.entity;

import com.nali.list.da.BothDaSSIzuna;
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
public class RenderSSIzuna
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaSSIzuna, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSSIzuna, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaSSIzuna, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaSSIzuna, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaSSIzuna, ?, E, I, MC, MB, MR>
> extends com.nali.list.render.RenderSSIzuna<IE, E, I, MC, MB, MR, C> implements IRenderS<BothDaSSIzuna, RenderSSIzuna<IE, E, I, MC, MB, MR, C>>
{
	@Override
	public void drawLater(RenderSSIzuna<IE, E, I, MC, MB, MR, C> r, int index)
	{
		int i = index - BothDaSSIzuna.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			IRenderS.super.drawLater(r, index);
		}
	}
}
