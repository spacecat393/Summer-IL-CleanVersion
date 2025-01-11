package com.nali.summer.entity.memo.client.reisa;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;
import com.nali.render.RenderS;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.small.render.IRenderS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixRenderReisa
<
	IE extends InvLe,
	BD extends IBothDaS & IBothDaE & IBothDaO,
	R extends RenderS<BD> & IRenderS<BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, R, E, I, MB, ?, C>,
	MB extends MixBoxSleInv<BD, R, E, I, MC, ?, C>,
	C extends ClientLeInv<IE, BD, R, E, I, MC, MB, ?>
> extends MixRenderSleInv<IE, BD, R, E, I, MC, MB, C>
{
	public MixRenderReisa(C c)
	{
		super(c);
		this.shadow_opaque = 0.5F;
		this.shadow_size = 0.25F;
	}
}
