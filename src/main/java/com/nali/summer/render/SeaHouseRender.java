package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.system.DataLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SeaHouseRender extends SkinningRender
{
    public SeaHouseRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, DataLoader dataloader)
    {
        super(entitiesrendermemory, bothdata, dataloader);
        this.texture_index_int_array[0] = 32;
        this.texture_index_int_array[1] = 32;
        this.texture_index_int_array[2] = 31;
    }
}
