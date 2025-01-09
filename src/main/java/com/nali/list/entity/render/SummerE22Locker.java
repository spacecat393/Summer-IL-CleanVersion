package com.nali.list.entity.render;

import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerE22Locker
<
	E extends com.nali.list.entity.SummerE22Locker
> extends FRenderSeInv<E>
{
	public SummerE22Locker(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
