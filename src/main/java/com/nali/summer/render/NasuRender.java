package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class NasuRender extends SkinningEntitiesRender
{
    public NasuRender(BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 10;
        this.texture_index_int_array[1] = 9;
        this.texture_index_int_array[2] = 11;
        this.texture_index_int_array[3] = 12;
        this.texture_index_int_array[4] = 12;
        this.texture_index_int_array[5] = 13;
        this.texture_index_int_array[6] = 14;
        this.texture_index_int_array[7] = 18;
        this.texture_index_int_array[8] = 16;
        this.texture_index_int_array[9] = 11;
        this.texture_index_int_array[10] = 17;
        this.texture_index_int_array[11] = 15;
    }

    @Override
    public void setGlow()
    {
        this.glow_boolean_array[7] = true;
        super.setGlow();
    }
}
