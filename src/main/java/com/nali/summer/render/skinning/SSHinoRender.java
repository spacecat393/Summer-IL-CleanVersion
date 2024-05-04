package com.nali.summer.render.skinning;

import com.nali.data.client.ClientData;
import com.nali.list.entities.SummerSSHino;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.data.client.SSHinoClientData;
import com.nali.summer.render.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class SSHinoRender extends SkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerSSHino.BOTHDATA;
    public static ClientData CLIENTDATA = new SSHinoClientData();
    public byte[] model_byte_array;

    public SSHinoRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, SummerSSHino.BOTHDATA, CLIENTDATA, RenderHelper.DATALOADER, entity);
        this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 47;
//        this.texture_index_int_array[1] = 48;
//        this.texture_index_int_array[2] = 49;
//        this.texture_index_int_array[3] = 47;
//        this.texture_index_int_array[4] = 50;
//        this.texture_index_int_array[5] = 51;
//        this.texture_index_int_array[6] = 52;
//        this.texture_index_int_array[7] = 52;
//        this.texture_index_int_array[8] = 52;
//        this.texture_index_int_array[9] = 53;
//        this.texture_index_int_array[10] = 9;
//        this.texture_index_int_array[11] = 50;
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
