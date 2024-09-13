package com.nali.list.entity.render;

import com.nali.list.entity.SummerSSHoshino;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderSSHoshino<E extends SummerSSHoshino> extends FRenderSeInv<E>
{
	public SummerFRenderSSHoshino(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
