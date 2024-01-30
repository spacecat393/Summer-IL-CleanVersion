package com.nali.summer.render;

import com.nali.system.DataLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHelper
{
    @SideOnly(Side.CLIENT)
    public static DataLoader DATALOADER = new DataLoader();
}
