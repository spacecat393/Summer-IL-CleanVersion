package com.nali.list.entity.render;

import com.nali.list.entity.SummerNasu;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderNasu<E extends SummerNasu> extends FRenderSeInv<E>
{
    public SummerFRenderNasu(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
