package com.nali.list.entity.render;

import com.nali.list.entity.SummerSSHimi;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerFRenderSSHimi<E extends SummerSSHimi> extends FRenderSeInv<E>
{
    public SummerFRenderSSHimi(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
