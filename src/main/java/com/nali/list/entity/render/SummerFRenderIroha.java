package com.nali.list.entity.render;

import com.nali.list.entity.SummerIroha;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderIroha<E extends SummerIroha> extends FRenderSeInv<E>
{
	public SummerFRenderIroha(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
