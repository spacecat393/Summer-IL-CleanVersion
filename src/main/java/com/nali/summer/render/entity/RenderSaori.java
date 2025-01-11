package com.nali.summer.render.entity;

import com.nali.list.da.BothDaSaori;
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
public class RenderSaori
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaSaori, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSaori, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaSaori, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaSaori, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaSaori, ?, E, I, MC, MB, MR>
> extends com.nali.list.render.RenderSaori<IE, E, I, MC, MB, MR, C> implements IRenderS<BothDaSaori, RenderSaori<IE, E, I, MC, MB, MR, C>>
{
}
