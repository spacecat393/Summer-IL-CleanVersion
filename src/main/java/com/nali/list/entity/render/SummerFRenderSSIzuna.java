package com.nali.list.entity.render;

import com.nali.list.entity.SummerSSIzuna;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderSSIzuna<E extends SummerSSIzuna> extends FRenderSeInv<E>
{
    public SummerFRenderSSIzuna(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
