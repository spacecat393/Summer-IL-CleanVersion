package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class IbukiRender extends SkinningEntitiesRender
{
    public IbukiRender(BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 81;
        this.texture_index_int_array[1] = 81;
        this.texture_index_int_array[2] = 81;
        this.texture_index_int_array[3] = 81;
        this.texture_index_int_array[4] = 81;
        this.texture_index_int_array[5] = 78;
        this.texture_index_int_array[6] = 76;
        this.texture_index_int_array[7] = 77;
        this.texture_index_int_array[8] = 77;
        this.texture_index_int_array[9] = 77;
        this.texture_index_int_array[10] = 78;
        this.texture_index_int_array[11] = 79;
        this.texture_index_int_array[12] = 80;
        this.texture_index_int_array[13] = 80;
        this.texture_index_int_array[14] = 80;
        this.texture_index_int_array[15] = 81;
        this.texture_index_int_array[16] = 82;
        this.texture_index_int_array[17] = 81;
        this.texture_index_int_array[18] = 81;
        this.texture_index_int_array[19] = 83;
        this.texture_index_int_array[20] = 9;
    }

    @Override
    public void setGlow()
    {
        this.glow_boolean_array[19] = true;
        super.setGlow();
    }
}
