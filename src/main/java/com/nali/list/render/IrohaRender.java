package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.SummerIroha;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class IrohaRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = SummerIroha.BOTHDATA;

    public IrohaRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
        this.texture_index_int_array[0] = 84;
        this.texture_index_int_array[1] = 85;
        this.texture_index_int_array[2] = 85;
        this.texture_index_int_array[3] = 86;
        this.texture_index_int_array[4] = 87;
        this.texture_index_int_array[5] = 88;
        this.texture_index_int_array[6] = 89;
        this.texture_index_int_array[7] = 90;
        this.texture_index_int_array[8] = 91;
        this.texture_index_int_array[9] = 92;
        this.texture_index_int_array[10] = 9;
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[9 / 8] ^= 2;//Math.pow(2, 9 % 8)
        super.setGlow();
    }
}
