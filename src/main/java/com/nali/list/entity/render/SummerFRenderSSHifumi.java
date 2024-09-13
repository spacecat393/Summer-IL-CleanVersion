package com.nali.list.entity.render;

import com.nali.list.entity.SummerSSHifumi;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderSSHifumi<E extends SummerSSHifumi> extends FRenderSeInv<E>
{
	public SummerFRenderSSHifumi(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
