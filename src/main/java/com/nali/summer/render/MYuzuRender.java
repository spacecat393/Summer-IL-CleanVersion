package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MYuzuRender extends SkinningEntitiesRender
{
    public MYuzuRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(entitiesrendermemory, bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 54;
        this.texture_index_int_array[1] = 55;
        this.texture_index_int_array[2] = 56;
        this.texture_index_int_array[3] = 56;
        this.texture_index_int_array[4] = 57;
        this.texture_index_int_array[5] = 58;
        this.texture_index_int_array[6] = 59;
        this.texture_index_int_array[7] = 60;
        this.texture_index_int_array[8] = 9;
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
        super.setGlow();
    }
}
