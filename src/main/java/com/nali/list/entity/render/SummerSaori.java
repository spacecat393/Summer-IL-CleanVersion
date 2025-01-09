package com.nali.list.entity.render;

import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerSaori
<
	E extends com.nali.list.entity.SummerSaori
> extends FRenderSeInv<E>
{
	public SummerSaori(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
