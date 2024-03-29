package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.SummerSaori;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SaoriRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = SummerSaori.BOTHDATA;

    public SaoriRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
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
        this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
        super.setGlow();
    }
}
