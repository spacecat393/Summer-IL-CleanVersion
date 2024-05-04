package com.nali.summer.render.skinning;

import com.nali.data.BothData;
import com.nali.data.client.ClientData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.summer.data.both.SeaHouseBothData;
import com.nali.summer.data.client.SeaHouseClientData;
import com.nali.summer.render.RenderHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class SeaHouseRender extends SkinningRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = new SeaHouseBothData();
    public static ClientData CLIENTDATA = new SeaHouseClientData();
    public byte[] model_byte_array;

    public SeaHouseRender(EntitiesRenderMemory entitiesrendermemory)
    {
        super(entitiesrendermemory, BOTHDATA, CLIENTDATA, RenderHelper.DATALOADER);
        this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 32;
//        this.texture_index_int_array[1] = 32;
//        this.texture_index_int_array[2] = 31;
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
}
