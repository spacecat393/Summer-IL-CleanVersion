package com.nali.list.entity.render;

import com.nali.list.entity.SummerAris;
import com.nali.small.entity.memo.client.render.RenderSleInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerArisRender<E extends SummerAris> extends RenderSleInv<E>
{
    public SummerArisRender(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
