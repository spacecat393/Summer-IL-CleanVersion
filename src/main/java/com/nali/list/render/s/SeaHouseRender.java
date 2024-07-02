package com.nali.list.render.s;

import com.nali.data.BothData;
import com.nali.data.IBothDaSn;
import com.nali.data.client.ClientData;
import com.nali.data.client.IClientDaS;
import com.nali.render.EntitiesRenderMemory;
import com.nali.summer.data.both.SeaHouseBothDa;
import com.nali.summer.data.client.SeaHouseClientDa;
import com.nali.summer.render.skinning.SummerRenderS;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class SeaHouseRender<BD extends IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends SummerRenderS<BD, RG, RS, RST, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = new SeaHouseBothDa();
    public static ClientData CLIENTDATA = new SeaHouseClientDa();
    public byte[] model_byte_array;

    public SeaHouseRender(EntitiesRenderMemory entitiesrendermemory)
    {
        super(entitiesrendermemory, BOTHDATA, CLIENTDATA/*, RenderHelper.DATALOADER*/);
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

    @Override
    public void drawLater(int index)
    {
        int i = index - this.clientdata.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.drawLater(index);
        }
    }
}
