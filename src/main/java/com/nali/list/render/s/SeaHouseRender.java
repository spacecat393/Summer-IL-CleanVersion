package com.nali.list.render.s;

import com.nali.data.IBothDaSn;
import com.nali.data.client.IClientDaS;
import com.nali.summer.data.both.BothDaSeaHouse;
import com.nali.summer.data.client.ClientDaSeaHouse;
import com.nali.summer.render.s.SummerRenderS;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

import static com.nali.Nali.I;

@SideOnly(Side.CLIENT)
public class SeaHouseRender<BD extends IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends SummerRenderS<BD, RG, RS, RST, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = new SeaHouseBothDa();
//    public static IClientDaS ICLIENTDAS = new SeaHouseClientDa();
    public byte[] model_byte_array;

    public SeaHouseRender()
    {
        this((RST)I.clientloader.stores, (RC) ClientDaSeaHouse.ICLIENTDAS, (BD) BothDaSeaHouse.IBOTHDASN);
    }

    public SeaHouseRender(RST rst, RC rc, BD bd)
    {
        super(rst, rc, bd);
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
