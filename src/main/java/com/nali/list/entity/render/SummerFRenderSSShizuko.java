package com.nali.list.entity.render;

import com.nali.list.entity.SummerSSShizuko;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderSSShizuko
<
	E extends SummerSSShizuko
> extends FRenderSeInv<E>
{
	public SummerFRenderSSShizuko(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
