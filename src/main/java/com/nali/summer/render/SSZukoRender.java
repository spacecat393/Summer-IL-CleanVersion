package com.nali.summer.render;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.data.SeaHouseData;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SSZukoRender extends SkinningEntitiesRender
{
    public SeaHouseRender seahouserender;
    public static SeaHouseData SEAHOUSEDATA = new SeaHouseData();

    public SSZukoRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(entitiesrendermemory, bothdata, dataloader, entity);
        this.texture_index_int_array[0] = 25;
        this.texture_index_int_array[1] = 26;
        this.texture_index_int_array[2] = 27;
        this.texture_index_int_array[3] = 27;
        this.texture_index_int_array[4] = 28;
        this.texture_index_int_array[5] = 29;
        this.texture_index_int_array[6] = 30;
        this.texture_index_int_array[7] = 32;
        this.texture_index_int_array[8] = 9;
        this.texture_index_int_array[9] = 32;
        this.texture_index_int_array[10] = 32;
        this.texture_index_int_array[11] = 31;
        this.seahouserender = new SeaHouseRender(new EntitiesRenderMemory(), SEAHOUSEDATA, dataloader);
    }

    @Override
    public void setGlow()
    {
        this.glow_boolean_array[6] = true;
        super.setGlow();
    }

    @Override
    public void updateLightCoord()
    {
        super.updateLightCoord();
        this.seahouserender.objectworlddraw.lig_b = this.objectworlddraw.lig_b;
        this.seahouserender.objectworlddraw.lig_s = this.objectworlddraw.lig_s;
    }

    @Override
    public void initSkinning()
    {
        super.initSkinning();
        this.seahouserender.initSkinning();
    }

    @Override
    public void setSkinning()
    {
        super.setSkinning();
        this.seahouserender.setSkinning();
    }
}