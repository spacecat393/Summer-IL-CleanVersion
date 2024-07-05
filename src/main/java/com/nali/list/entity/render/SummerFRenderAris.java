package com.nali.list.entity.render;

import com.nali.list.entity.SummerAris;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderAris<E extends SummerAris> extends FRenderSeInv<E>
{
    public SummerFRenderAris(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
