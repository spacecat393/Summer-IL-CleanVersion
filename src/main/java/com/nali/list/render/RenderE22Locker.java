package com.nali.list.render;

import com.nali.list.da.BothDaE22Locker;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.inv.InvE;
import com.nali.small.entity.memo.IBothEInv;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderE22Locker
<
	IE extends InvE,
	E extends Entity,
	I extends IMixE<BothDaE22Locker, E> & IMixES,
	MC extends MixCIE<BothDaE22Locker, ?, E, I, MB, MR, C>,
	MB extends MixBoxE<BothDaE22Locker, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaE22Locker, ?, E, I, MC, MB, C>,
	C extends ClientE<BothDaE22Locker, ?, E, I, MC, MB, MR> & IBothEInv<IE>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BothDaE22Locker>
{
	public RenderE22Locker()
	{
		super(BothDaE22Locker.IDA);
	}
}
