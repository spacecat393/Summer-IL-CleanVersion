package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.SummerYuzu;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class YuzuRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = SummerYuzu.BOTHDATA;

    public YuzuRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
        this.texture_index_int_array[0] = 62;
        this.texture_index_int_array[1] = 54;
        this.texture_index_int_array[2] = 63;
        this.texture_index_int_array[3] = 63;
        this.texture_index_int_array[4] = 64;
        this.texture_index_int_array[5] = 65;
        this.texture_index_int_array[6] = 64;
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
