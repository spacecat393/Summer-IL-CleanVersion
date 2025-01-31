package com.nali.summer.render.entity;

import com.nali.list.da.BothDaYuzu;
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
public class RenderYuzu
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaYuzu, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaYuzu, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaYuzu, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaYuzu, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaYuzu, ?, E, I, MC, MB, MR>
> extends com.nali.list.render.RenderYuzu<IE, E, I, MC, MB, MR, C> implements IRenderS<BothDaYuzu, RenderYuzu<IE, E, I, MC, MB, MR, C>>
{
}
