package com.nali.list.entity.render;

import com.nali.list.entity.SummerSSZuko;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderSSZuko<E extends SummerSSZuko> extends FRenderSeInv<E>
{
    public SummerFRenderSSZuko(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
