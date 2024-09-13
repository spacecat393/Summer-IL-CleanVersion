package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.IClientS;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.summer.da.both.BothDaE22Locker;
import com.nali.summer.da.client.ClientDaE22Locker;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderE22Locker<E extends Entity, I extends IMixE<SD, BD, E>, MB extends MixBoxE<RC, ?, SD, BD, E, I, MR, C>, MR extends MixRenderSe<RC, ?, SD, BD, E, I, MB, C>, C extends ClientE<RC, ?, SD, BD, E, I, MB, MR> & IClientS<RC, ?, SD, BD, E, I, MR>, SD, BD extends IBothDaNe & IBothDaSn, RC extends IClientDaS> extends SummerRenderSe<E, I, MB, MR, C, SD, BD, RC>
{
	public static IClientDaS ICLIENTDAS = new ClientDaE22Locker();
	public static IBothDaSn IBOTHDASN = BothDaE22Locker.IBOTHDASN;

	public RenderE22Locker(RC rc, BD bd)
	{
		super(rc, bd);
	}
}
