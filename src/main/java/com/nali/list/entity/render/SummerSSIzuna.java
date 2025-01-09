package com.nali.list.entity.render;

import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerSSIzuna
<
	E extends com.nali.list.entity.SummerSSIzuna
> extends FRenderSeInv<E>
{
	public SummerSSIzuna(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
