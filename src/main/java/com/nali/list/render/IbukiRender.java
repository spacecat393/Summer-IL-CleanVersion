package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.SummerIbuki;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class IbukiRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = SummerIbuki.BOTHDATA;
    public IrohaRender iroharender;

    public IbukiRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
        this.texture_index_int_array[0] = 76;
        this.texture_index_int_array[1] = 77;
        this.texture_index_int_array[2] = 77;
        this.texture_index_int_array[3] = 77;
        this.texture_index_int_array[4] = 78;
        this.texture_index_int_array[5] = 79;
        this.texture_index_int_array[6] = 80;
        this.texture_index_int_array[7] = 80;
        this.texture_index_int_array[8] = 80;
        this.texture_index_int_array[9] = 81;
        this.texture_index_int_array[10] = 82;
        this.texture_index_int_array[11] = 81;
        this.texture_index_int_array[12] = 81;
        this.texture_index_int_array[13] = 83;
        this.texture_index_int_array[14] = 9;
        this.iroharender = new IrohaRender(entitiesrendermemory, entity);
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[13 / 8] ^= 32;//Math.pow(2, 13 % 8)
        super.setGlow();
    }
}
