package com.nali.summer.render.skinning;

import com.nali.data.client.ClientData;
import com.nali.list.entities.SummerMYuzu;
import com.nali.render.EntitiesRenderMemory;
import com.nali.summer.data.client.MYuzuClientData;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MYuzuRender extends SummerSkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerMYuzu.BOTHDATA;
    public static ClientData CLIENTDATA = new MYuzuClientData();

    public MYuzuRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerMYuzu.BOTHDATA, CLIENTDATA/*, RenderHelper.DATALOADER*/, entity);
//        this.texture_index_int_array[0] = 54;
//        this.texture_index_int_array[1] = 55;
//        this.texture_index_int_array[2] = 56;
//        this.texture_index_int_array[3] = 56;
//        this.texture_index_int_array[4] = 57;
//        this.texture_index_int_array[5] = 58;
//        this.texture_index_int_array[6] = 59;
//        this.texture_index_int_array[7] = 60;
//        this.texture_index_int_array[8] = 9;
    }

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//        super.setGlow();
//    }
}
