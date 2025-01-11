package com.nali.summer.render.entity;

import com.nali.list.da.BothDaSSHoshino;
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
public class RenderSSHoshino
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaSSHoshino, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSSHoshino, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaSSHoshino, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaSSHoshino, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaSSHoshino, ?, E, I, MC, MB, MR>
> extends com.nali.list.render.RenderSSHoshino<IE, E, I, MC, MB, MR, C> implements IRenderS<BothDaSSHoshino, RenderSSHoshino<IE, E, I, MC, MB, MR, C>>
{
	@Override
	public void drawLater(RenderSSHoshino<IE, E, I, MC, MB, MR, C> r, int index)
	{
		int i = index - BothDaSSHoshino.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			IRenderS.super.drawLater(r, index);
		}
	}
}
