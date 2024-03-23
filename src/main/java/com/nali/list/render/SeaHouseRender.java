package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.summer.data.SeaHouseData;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SeaHouseRender extends SkinningRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = new SeaHouseData();

    public SeaHouseRender(EntitiesRenderMemory entitiesrendermemory)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, ID);
        this.texture_index_int_array[0] = 32;
        this.texture_index_int_array[1] = 32;
        this.texture_index_int_array[2] = 31;
    }
}
