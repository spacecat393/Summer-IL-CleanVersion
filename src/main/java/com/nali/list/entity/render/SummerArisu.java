package com.nali.list.entity.render;

import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerArisu
<
	E extends com.nali.list.entity.SummerArisu
> extends FRenderSeInv<E>
{
	public SummerArisu(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
