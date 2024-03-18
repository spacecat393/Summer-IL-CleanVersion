package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SSUnaRender extends SkinningEntitiesRender
{
    public SSUnaRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(entitiesrendermemory, bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 33;
        this.texture_index_int_array[1] = 34;
        this.texture_index_int_array[2] = 35;
        this.texture_index_int_array[3] = 34;
        this.texture_index_int_array[4] = 36;
        this.texture_index_int_array[5] = 37;
        this.texture_index_int_array[6] = 38;
        this.texture_index_int_array[7] = 9;
        this.texture_index_int_array[8] = 39;
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
        super.setGlow();
    }
}