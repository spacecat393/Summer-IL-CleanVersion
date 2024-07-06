package com.nali.list.entity.render;

import com.nali.list.entity.SummerIbuki;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderIbuki<E extends SummerIbuki> extends FRenderSeInv<E>
{
    public SummerFRenderIbuki(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
