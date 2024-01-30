package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SaoriRender extends SkinningEntitiesRender
{
    public SaoriRender(BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 70;
        this.texture_index_int_array[1] = 71;
        this.texture_index_int_array[2] = 71;
        this.texture_index_int_array[3] = 72;
        this.texture_index_int_array[4] = 73;
        this.texture_index_int_array[5] = 74;
        this.texture_index_int_array[6] = 74;
        this.texture_index_int_array[7] = 75;
        this.texture_index_int_array[8] = 66;
    }

    @Override
    public void setGlow()
    {
        this.glow_boolean_array[7] = true;
        super.setGlow();
    }
}
