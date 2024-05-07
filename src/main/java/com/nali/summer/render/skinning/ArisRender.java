package com.nali.summer.render.skinning;

import com.nali.data.client.ClientData;
import com.nali.list.entities.SummerAris;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.data.client.ArisClientData;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class ArisRender extends SkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static ClientData CLIENTDATA = new ArisClientData();
    public byte[] model_byte_array;

    public ArisRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerAris.BOTHDATA, CLIENTDATA, RenderHelper.DATALOADER, entity);
        this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 19;
//        this.texture_index_int_array[1] = 20;
//        this.texture_index_int_array[2] = 21;
//        this.texture_index_int_array[3] = 20;
//        this.texture_index_int_array[4] = 22;
//        this.texture_index_int_array[5] = 23;
//        this.texture_index_int_array[6] = 22;
//        this.texture_index_int_array[7] = 24;
//        this.texture_index_int_array[8] = 9;
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
//        this.glow_byte_array[4 / 8] ^= 16;//Math.pow(2, 4 % 8)
//        this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//        super.setGlow();
//    }
}
