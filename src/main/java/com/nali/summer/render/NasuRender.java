package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class NasuRender extends SkinningEntitiesRender
{
    public NasuRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(entitiesrendermemory, bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 10;
        this.texture_index_int_array[1] = 11;
        this.texture_index_int_array[2] = 12;
        this.texture_index_int_array[3] = 12;
        this.texture_index_int_array[4] = 13;
        this.texture_index_int_array[5] = 14;
        this.texture_index_int_array[6] = 18;
        this.texture_index_int_array[7] = 16;
        this.texture_index_int_array[8] = 11;
        this.texture_index_int_array[9] = 17;
        this.texture_index_int_array[10] = 15;
        this.texture_index_int_array[11] = 9;
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
        super.setGlow();
    }
}
