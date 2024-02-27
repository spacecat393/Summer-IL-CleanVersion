package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ArisRender extends SkinningEntitiesRender
{
    public ArisRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(entitiesrendermemory, bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 9;
        this.texture_index_int_array[1] = 19;
        this.texture_index_int_array[2] = 20;
        this.texture_index_int_array[3] = 21;
        this.texture_index_int_array[4] = 20;
        this.texture_index_int_array[5] = 22;
        this.texture_index_int_array[6] = 23;
        this.texture_index_int_array[7] = 22;
        this.texture_index_int_array[8] = 24;
    }

    @Override
    public void setGlow()
    {
        this.glow_boolean_array[5] = true;
        this.glow_boolean_array[8] = true;
        super.setGlow();
    }
}
