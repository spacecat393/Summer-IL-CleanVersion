package com.nali.list.entity.render;

import com.nali.list.entity.SummerMYuzu;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderMYuzu
<
	E extends SummerMYuzu
> extends FRenderSeInv<E>
{
	public SummerFRenderMYuzu(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
