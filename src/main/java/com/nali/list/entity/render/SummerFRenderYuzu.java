package com.nali.list.entity.render;

import com.nali.list.entity.SummerYuzu;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderYuzu
<
	E extends SummerYuzu
> extends FRenderSeInv<E>
{
	public SummerFRenderYuzu(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
