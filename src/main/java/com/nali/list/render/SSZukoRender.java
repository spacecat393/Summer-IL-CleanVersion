package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.SummerSSZuko;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SSZukoRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = SummerSSZuko.BOTHDATA;

    public SeaHouseRender seahouserender;

    public SSZukoRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
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
        this.seahouserender = new SeaHouseRender(entitiesrendermemory);
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
        super.setGlow();
    }

    @Override
    public void updateLightCoord()
    {
        super.updateLightCoord();
        this.seahouserender.lig_b = this.lig_b;
        this.seahouserender.lig_s = this.lig_s;
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