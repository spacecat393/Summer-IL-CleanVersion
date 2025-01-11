package com.nali.summer.entity.memo.client.e22locker;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;
import com.nali.render.RenderS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.IRenderS;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixRenderE22Locker
<
	R extends RenderS<BD> & IRenderS<BD, R>,
	BD extends IBothDaE & IBothDaO & IBothDaS,
	E extends Entity,
	I extends IMixE<BD, E> & IMixES,
	MC extends MixCIE<BD, R, E, I, MB, ?, C>,
	MB extends MixBoxE<BD, R, E, I, MC, ?, C>,
	C extends ClientE<BD, R, E, I, MC, MB, ?>
> extends MixRenderSe<BD, R, E, I, MC, MB, C>
{
	public MixRenderE22Locker(C c)
	{
		super(c);
		this.shadow_opaque = 0.5F;
		this.shadow_size = 0.25F;
	}
}
