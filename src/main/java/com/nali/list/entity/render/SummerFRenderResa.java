package com.nali.list.entity.render;

import com.nali.list.entity.SummerResa;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderResa<E extends SummerResa> extends FRenderSeInv<E>
{
    public SummerFRenderResa(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
