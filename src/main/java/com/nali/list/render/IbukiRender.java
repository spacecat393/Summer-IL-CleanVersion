package com.nali.list.render;

import com.nali.data.client.ClientData;
import com.nali.list.entities.SummerIbuki;
import com.nali.render.EntitiesRenderMemory;
import com.nali.summer.data.client.IbukiClientData;
import com.nali.summer.render.skinning.SummerSkinningEntitiesRender;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class IbukiRender extends SummerSkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerIbuki.BOTHDATA;
    public static ClientData CLIENTDATA = new IbukiClientData();
    public IrohaRender iroharender;
    public byte[] model_byte_array;

    public IbukiRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerIbuki.BOTHDATA, CLIENTDATA/*, RenderHelper.DATALOADER*/, entity);
        this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 76;
//        this.texture_index_int_array[1] = 77;
//        this.texture_index_int_array[2] = 77;
//        this.texture_index_int_array[3] = 77;
//        this.texture_index_int_array[4] = 78;
//        this.texture_index_int_array[5] = 79;
//        this.texture_index_int_array[6] = 80;
//        this.texture_index_int_array[7] = 80;
//        this.texture_index_int_array[8] = 80;
//        this.texture_index_int_array[9] = 81;
//        this.texture_index_int_array[10] = 82;
//        this.texture_index_int_array[11] = 81;
//        this.texture_index_int_array[12] = 81;
//        this.texture_index_int_array[13] = 83;
//        this.texture_index_int_array[14] = 9;
        this.iroharender = new IrohaRender(entitiesrendermemory, entity);
        Arrays.fill(this.model_byte_array, (byte)255);
    }

    @Override
    public void draw(int index)
    {
        int i = index - this.clientdata.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.draw(index);
        }
    }

    @Override
    public void drawLater(int index)
    {
        int i = index - this.clientdata.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.drawLater(index);
        }
    }

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[13 / 8] ^= 32;//Math.pow(2, 13 % 8)
//        super.setGlow();
//    }
}
