package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderE;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaResa;
import com.nali.summer.da.client.ClientDaResa;
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
public class RenderResa<E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, ?, SD, BD, E, I, MR, C>, MR extends MixRenderE<RG, RS, RC, RST, ?, SD, BD, E, I, MB, C>, C extends ClientSle<RG, RS, RC, RST, ?, SD, BD, E, I, MB, MR>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends SummerRenderSe<E, I, MB, MR, C, SD, BD, RG, RS, RST, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerResa.BOTHDATA;
//    public static IClientDaS ICLIENTDAS = new ResaClientDa();
    public byte[] model_byte_array;

    public RenderResa()
    {
        this((RST)I.clientloader.stores, (RC) ClientDaResa.ICLIENTDAS, (BD) BothDaResa.IBOTHDASN);
    }

    public RenderResa(RST rst, RC rc, BD bd)
    {
        super(rst, rc, bd);
        this.model_byte_array = new byte[(int)Math.ceil((rc.EndPart() - rc.StartPart()) / 8.0D)];
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
        this.model_byte_array[3 / 8] &= 255-8;
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
//        this.glow_byte_array[9 / 8] ^= 2;//Math.pow(2, 9 % 8)
//        super.setGlow();
//    }
}
