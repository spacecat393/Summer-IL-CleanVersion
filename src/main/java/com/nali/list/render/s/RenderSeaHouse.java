package com.nali.list.render.s;

import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.summer.da.both.BothDaSeaHouse;
import com.nali.summer.da.client.ClientDaSeaHouse;
import com.nali.summer.render.SummerRenderS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderSeaHouse<BD extends IBothDaSn, RC extends IClientDaS> extends SummerRenderS<BD, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = new SeaHouseBothDa();
    public static IClientDaS ICLIENTDAS = new ClientDaSeaHouse();
    public static IBothDaSn IBOTHDASN = BothDaSeaHouse.IBOTHDASN;
    public byte[] model_byte_array;

    public RenderSeaHouse(RC rc, BD bd)
    {
        super(rc, bd);
        this.model_byte_array = new byte[(int)Math.ceil((rc.EndPart() - rc.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 32;
//        this.texture_index_int_array[1] = 32;
//        this.texture_index_int_array[2] = 31;
        Arrays.fill(this.model_byte_array, (byte)255);
    }

    @Override
    public void draw(int index)
    {
        int i = index - this.rc.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.draw(index);
        }
    }

    @Override
    public void drawLater(int index)
    {
        int i = index - this.rc.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.drawLater(index);
        }
    }
}
