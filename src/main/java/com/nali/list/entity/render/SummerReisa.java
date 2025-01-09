package com.nali.list.entity.render;

import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerReisa
<
	E extends com.nali.list.entity.SummerReisa
> extends FRenderSeInv<E>
{
	public SummerReisa(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
