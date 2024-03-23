package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.SummerSSHino;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SSHinoRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = SummerSSHino.BOTHDATA;

    public SSHinoRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
        this.texture_index_int_array[0] = 47;
        this.texture_index_int_array[1] = 48;
        this.texture_index_int_array[2] = 49;
        this.texture_index_int_array[3] = 47;
        this.texture_index_int_array[4] = 50;
        this.texture_index_int_array[5] = 51;
        this.texture_index_int_array[6] = 52;
        this.texture_index_int_array[7] = 52;
        this.texture_index_int_array[8] = 52;
        this.texture_index_int_array[9] = 53;
        this.texture_index_int_array[10] = 9;
        this.texture_index_int_array[11] = 50;
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[9 / 8] ^= 2;//Math.pow(2, 9 % 8)
        super.setGlow();
    }
}
