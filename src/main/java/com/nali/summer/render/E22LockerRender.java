package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class E22LockerRender extends SkinningEntitiesRender
{
    public E22LockerRender(BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(bothdata, dataloader, entity);
        Arrays.fill(this.texture_index_int_array, 61);
    }

    @Override
    public void setGlow()
    {
        this.glow_boolean_array[6] = true;
        super.setGlow();
    }
}
