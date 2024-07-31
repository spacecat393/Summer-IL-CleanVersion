package com.nali.list.entity.render;

import com.nali.list.entity.SummerReisa;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderReisa<E extends SummerReisa> extends FRenderSeInv<E>
{
    public SummerFRenderReisa(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
