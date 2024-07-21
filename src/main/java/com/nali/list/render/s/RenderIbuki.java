package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaIbuki;
import com.nali.summer.da.both.BothDaIroha;
import com.nali.summer.da.client.ClientDaIbuki;
import com.nali.summer.da.client.ClientDaIroha;
import com.nali.summer.render.SummerRenderSe;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

import static com.nali.Nali.I;

@SideOnly(Side.CLIENT)
public class RenderIbuki<E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, ?, SD, BD, E, I, MR, C>, MR extends MixRenderSe<RG, RS, RC, RST, ?, SD, BD, E, I, MB, C>, C extends ClientSle<RG, RS, RC, RST, ?, SD, BD, E, I, MB, MR>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends SummerRenderSe<E, I, MB, MR, C, SD, BD, RG, RS, RST, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerIbuki.BOTHDATA;
//    public static IClientDaS ICLIENTDAS = new IbukiClientDa();
    public RenderIroha iroharender;
    public byte[] model_byte_array;

    public RenderIbuki()
    {
        this((RST)I.clientloader.stores, (RC) ClientDaIbuki.ICLIENTDAS, (BD) BothDaIbuki.IBOTHDASN);
    }

    public RenderIbuki(RST rst, RC rc, BD bd)
    {
        super(rst, rc, bd);
        this.model_byte_array = new byte[(int)Math.ceil((rc.EndPart() - rc.StartPart()) / 8.0D)];
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
        this.iroharender = new RenderIroha(I.clientloader.stores, ClientDaIroha.ICLIENTDAS, BothDaIroha.IBOTHDASN);
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

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[13 / 8] ^= 32;//Math.pow(2, 13 % 8)
//        super.setGlow();
//    }
}
