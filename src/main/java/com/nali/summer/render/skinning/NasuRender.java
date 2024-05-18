package com.nali.summer.render.skinning;

import com.nali.data.client.ClientData;
import com.nali.list.entities.SummerNasu;
import com.nali.render.EntitiesRenderMemory;
import com.nali.summer.data.client.NasuClientData;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class NasuRender extends SummerSkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static ClientData CLIENTDATA = new NasuClientData();
    public byte[] model_byte_array;

    public NasuRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerNasu.BOTHDATA, CLIENTDATA/*, RenderHelper.DATALOADER*/, entity);
        this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 10;
//        this.texture_index_int_array[1] = 11;
//        this.texture_index_int_array[2] = 12;
//        this.texture_index_int_array[3] = 12;
//        this.texture_index_int_array[4] = 13;
//        this.texture_index_int_array[5] = 14;
//        this.texture_index_int_array[6] = 18;
//        this.texture_index_int_array[7] = 16;
//        this.texture_index_int_array[8] = 11;
//        this.texture_index_int_array[9] = 17;
//        this.texture_index_int_array[10] = 15;
//        this.texture_index_int_array[11] = 9;
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
//        this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
//        super.setGlow();
//    }
}
