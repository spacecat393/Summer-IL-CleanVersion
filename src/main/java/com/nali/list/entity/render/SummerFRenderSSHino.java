package com.nali.list.entity.render;

import com.nali.list.entity.SummerSSHino;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderSSHino<E extends SummerSSHino> extends FRenderSeInv<E>
{
    public SummerFRenderSSHino(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
