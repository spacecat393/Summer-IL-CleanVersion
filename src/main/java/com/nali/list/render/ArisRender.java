package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.SummerAris;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ArisRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = SummerAris.BOTHDATA;

    public ArisRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
        this.texture_index_int_array[0] = 19;
        this.texture_index_int_array[1] = 20;
        this.texture_index_int_array[2] = 21;
        this.texture_index_int_array[3] = 20;
        this.texture_index_int_array[4] = 22;
        this.texture_index_int_array[5] = 23;
        this.texture_index_int_array[6] = 22;
        this.texture_index_int_array[7] = 24;
        this.texture_index_int_array[8] = 9;
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[4 / 8] ^= 16;//Math.pow(2, 4 % 8)
        this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
        super.setGlow();
    }
}
