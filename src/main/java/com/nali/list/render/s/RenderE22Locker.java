package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvE;
import com.nali.small.entity.memo.IBothNInv;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.IClientRsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.summer.da.both.BothDaE22Locker;
import com.nali.summer.da.client.ClientDaE22Locker;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderE22Locker
<
	IE extends InvE,
	E extends Entity,
	I extends IMixE<SD, BD, E>,
	MC extends MixCIE<RC, ?, SD, BD, E, I, MB, MR, C>,
	MB extends MixBoxE<RC, ?, SD, BD, E, I, MC, MR, C>,
	MR extends MixRenderSe<RC, ?, SD, BD, E, I, MC, MB, C>,
	C extends ClientE<RC, ?, SD, BD, E, I, MC, MB, MR> & IBothNInv<IE> & IClientRsInv,
	SD,
	BD extends IBothDaNe & IBothDaSn,
	RC extends IClientDaS
> extends SummerRenderSe<E, I, MC, MB, MR, C, SD, BD, RC>
{
	public static IClientDaS ICLIENTDAS = new ClientDaE22Locker();
	public static IBothDaSn IBOTHDASN = BothDaE22Locker.IBOTHDASN;

	public RenderE22Locker(RC rc, BD bd)
	{
		super(rc, bd);
	}
}
