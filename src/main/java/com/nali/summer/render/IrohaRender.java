package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class IrohaRender extends SkinningEntitiesRender
{
    public IrohaRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(entitiesrendermemory, bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 84;
        this.texture_index_int_array[1] = 85;
        this.texture_index_int_array[2] = 85;
        this.texture_index_int_array[3] = 86;
        this.texture_index_int_array[4] = 87;
        this.texture_index_int_array[5] = 88;
        this.texture_index_int_array[6] = 89;
        this.texture_index_int_array[7] = 90;
        this.texture_index_int_array[8] = 91;
        this.texture_index_int_array[9] = 92;
        this.texture_index_int_array[10] = 9;
    }

    @Override
    public void setGlow()
    {
        this.glow_boolean_array[9] = true;
        super.setGlow();
    }
}
