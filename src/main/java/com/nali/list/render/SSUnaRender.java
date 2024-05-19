package com.nali.list.render;

import com.nali.data.client.ClientData;
import com.nali.list.entities.SummerSSUna;
import com.nali.render.EntitiesRenderMemory;
import com.nali.summer.data.client.SSUnaClientData;
import com.nali.summer.render.skinning.SummerSkinningEntitiesRender;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class SSUnaRender extends SummerSkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerSSUna.BOTHDATA;
    public static ClientData CLIENTDATA = new SSUnaClientData();
    public byte[] model_byte_array;

    public SSUnaRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerSSUna.BOTHDATA, CLIENTDATA/*, RenderHelper.DATALOADER*/, entity);
        this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 33;
//        this.texture_index_int_array[1] = 34;
//        this.texture_index_int_array[2] = 35;
//        this.texture_index_int_array[3] = 34;
//        this.texture_index_int_array[4] = 36;
//        this.texture_index_int_array[5] = 37;
//        this.texture_index_int_array[6] = 38;
//        this.texture_index_int_array[7] = 9;
//        this.texture_index_int_array[8] = 39;
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