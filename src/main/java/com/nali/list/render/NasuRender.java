package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.SummerNasu;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class NasuRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = SummerNasu.BOTHDATA;

    public NasuRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
        this.texture_index_int_array[0] = 10;
        this.texture_index_int_array[1] = 11;
        this.texture_index_int_array[2] = 12;
        this.texture_index_int_array[3] = 12;
        this.texture_index_int_array[4] = 13;
        this.texture_index_int_array[5] = 14;
        this.texture_index_int_array[6] = 18;
        this.texture_index_int_array[7] = 16;
        this.texture_index_int_array[8] = 11;
        this.texture_index_int_array[9] = 17;
        this.texture_index_int_array[10] = 15;
        this.texture_index_int_array[11] = 9;
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
        super.setGlow();
    }
}
