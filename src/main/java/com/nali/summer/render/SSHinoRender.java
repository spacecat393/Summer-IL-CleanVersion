package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SSHinoRender extends SkinningEntitiesRender
{
    public SSHinoRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(entitiesrendermemory, bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 47;
        this.texture_index_int_array[1] = 48;
        this.texture_index_int_array[2] = 49;
        this.texture_index_int_array[3] = 47;
        this.texture_index_int_array[4] = 50;
        this.texture_index_int_array[5] = 51;
        this.texture_index_int_array[6] = 52;
        this.texture_index_int_array[7] = 52;
        this.texture_index_int_array[8] = 52;
        this.texture_index_int_array[9] = 53;
        this.texture_index_int_array[10] = 9;
        this.texture_index_int_array[11] = 50;
    }

    @Override
    public void setGlow()
    {
        this.glow_boolean_array[9] = true;
        super.setGlow();
    }
}
