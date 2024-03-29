package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.SummerResa;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ResaRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = SummerResa.BOTHDATA;

    public ResaRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
        this.texture_index_int_array[0] = 41;
        this.texture_index_int_array[1] = 40;
        this.texture_index_int_array[2] = 41;
        this.texture_index_int_array[3] = 42;
        this.texture_index_int_array[4] = 43;
        this.texture_index_int_array[5] = 44;
        this.texture_index_int_array[6] = 41;
        this.texture_index_int_array[7] = 45;
        this.texture_index_int_array[8] = 44;
        this.texture_index_int_array[9] = 46;
        this.texture_index_int_array[10] = 9;
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[9 / 8] ^= 2;//Math.pow(2, 9 % 8)
        super.setGlow();
    }
}
