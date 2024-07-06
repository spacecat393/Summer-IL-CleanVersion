package com.nali.list.entity.render;

import com.nali.list.entity.SummerSSUna;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderSSUna<E extends SummerSSUna> extends FRenderSeInv<E>
{
    public SummerFRenderSSUna(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
