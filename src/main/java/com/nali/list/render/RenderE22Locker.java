package com.nali.list.render;

import com.nali.list.da.BothDaE22Locker;
import com.nali.render.RenderS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.IRenderS;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderE22Locker
<
	E extends Entity,
	I extends IMixE<BD, E> & IMixES,
	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
	MB extends MixBoxE<BD, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BD, ?, E, I, MC, MB, C>,
	C extends ClientE<BD, ?, E, I, MC, MB, MR>,
	BD extends BothDaE22Locker,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BD, R>
{
	public RenderE22Locker()
	{
		super((BD)BothDaE22Locker.IDA);
	}
}
