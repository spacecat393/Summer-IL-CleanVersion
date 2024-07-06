package com.nali.list.entity.render;

import com.nali.list.entity.SummerSaori;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderSaori<E extends SummerSaori> extends FRenderSeInv<E>
{
    public SummerFRenderSaori(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
