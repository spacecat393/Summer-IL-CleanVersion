package com.nali.list.entity.render;

import com.nali.list.entity.SummerNatsu;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderNatsu<E extends SummerNatsu> extends FRenderSeInv<E>
{
    public SummerFRenderNatsu(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
