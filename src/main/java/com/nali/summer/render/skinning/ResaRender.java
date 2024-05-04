package com.nali.summer.render.skinning;

import com.nali.data.client.ClientData;
import com.nali.list.entities.SummerResa;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.data.client.ResaClientData;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class ResaRender extends SkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerResa.BOTHDATA;
    public static ClientData CLIENTDATA = new ResaClientData();
    public byte[] model_byte_array;

    public ResaRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerResa.BOTHDATA, CLIENTDATA, RenderHelper.DATALOADER, entity);
        this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 41;
//        this.texture_index_int_array[1] = 40;
//        this.texture_index_int_array[2] = 41;
//        this.texture_index_int_array[3] = 42;
//        this.texture_index_int_array[4] = 43;
//        this.texture_index_int_array[5] = 44;
//        this.texture_index_int_array[6] = 41;
//        this.texture_index_int_array[7] = 45;
//        this.texture_index_int_array[8] = 44;
//        this.texture_index_int_array[9] = 46;
//        this.texture_index_int_array[10] = 9;
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

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[9 / 8] ^= 2;//Math.pow(2, 9 % 8)
//        super.setGlow();
//    }
}
