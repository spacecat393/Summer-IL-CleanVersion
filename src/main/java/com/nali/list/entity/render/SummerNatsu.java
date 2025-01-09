package com.nali.list.entity.render;

import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerNatsu
<
	E extends com.nali.list.entity.SummerNatsu
> extends FRenderSeInv<E>
{
	public SummerNatsu(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
