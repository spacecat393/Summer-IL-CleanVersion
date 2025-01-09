package com.nali.list.entity.render;

import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerSSShizuko
<
	E extends com.nali.list.entity.SummerSSShizuko
> extends FRenderSeInv<E>
{
	public SummerSSShizuko(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
