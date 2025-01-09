package com.nali.list.entity.render;

import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerMYuzu
<
	E extends com.nali.list.entity.SummerMYuzu
> extends FRenderSeInv<E>
{
	public SummerMYuzu(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
