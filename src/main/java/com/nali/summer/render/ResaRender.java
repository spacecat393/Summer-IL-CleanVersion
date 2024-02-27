package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ResaRender extends SkinningEntitiesRender
{
    public ResaRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(entitiesrendermemory, bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 41;
        this.texture_index_int_array[1] = 40;
        this.texture_index_int_array[2] = 41;
        this.texture_index_int_array[3] = 9;
        this.texture_index_int_array[4] = 42;
        this.texture_index_int_array[5] = 43;
        this.texture_index_int_array[6] = 44;
        this.texture_index_int_array[7] = 41;
        this.texture_index_int_array[8] = 45;
        this.texture_index_int_array[9] = 44;
        this.texture_index_int_array[10] = 46;
    }

    @Override
    public void setGlow()
    {
        this.glow_boolean_array[10] = true;
        super.setGlow();
    }
}
