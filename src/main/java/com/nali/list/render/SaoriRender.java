package com.nali.list.render;

import com.nali.data.client.ClientData;
import com.nali.list.entities.SummerSaori;
import com.nali.render.EntitiesRenderMemory;
import com.nali.summer.data.client.SaoriClientData;
import com.nali.summer.render.skinning.SummerSkinningEntitiesRender;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SaoriRender extends SummerSkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerSaori.BOTHDATA;
    public static ClientData CLIENTDATA = new SaoriClientData();

    public SaoriRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerSaori.BOTHDATA, CLIENTDATA/*, RenderHelper.DATALOADER*/, entity);
//        this.texture_index_int_array[0] = 70;
//        this.texture_index_int_array[1] = 71;
//        this.texture_index_int_array[2] = 71;
//        this.texture_index_int_array[3] = 72;
//        this.texture_index_int_array[4] = 73;
//        this.texture_index_int_array[5] = 74;
//        this.texture_index_int_array[6] = 74;
//        this.texture_index_int_array[7] = 75;
//        this.texture_index_int_array[8] = 66;
    }

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//        super.setGlow();
//    }
}
