package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderE;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaSaori;
import com.nali.summer.da.client.ClientDaSaori;
import com.nali.summer.render.SummerRenderSe;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.Nali.I;

@SideOnly(Side.CLIENT)
public class RenderSaori<E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, ?, SD, BD, E, I, MR, C>, MR extends MixRenderE<RG, RS, RC, RST, ?, SD, BD, E, I, MB, C>, C extends ClientSle<RG, RS, RC, RST, ?, SD, BD, E, I, MB, MR>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends SummerRenderSe<E, I, MB, MR, C, SD, BD, RG, RS, RST, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerSaori.BOTHDATA;
//    public static IClientDaS ICLIENTDAS = new SaoriClientDa();
    public RenderSaori()
    {
        this((RST)I.clientloader.stores, (RC) ClientDaSaori.ICLIENTDAS, (BD) BothDaSaori.IBOTHDASN);
    }

    public RenderSaori(RST rst, RC rc, BD bd)
    {
        super(rst, rc, bd);
//        this.texture_index_int_array[0] = 70;
//        this.texture_index_int_array[1] = 71;
//        this.texture_index_int_array[2] = 71;
//        this.texture_index_int_array[3] = 72;
//        this.texture_index_int_array[4] = 73;
//        this.texture_index_int_array[5] = 74;
//        this.texture_index_int_array[6] = 74;
//        this.texture_index_int_array[7] = 75;
//        this.texture_index_int_array[8] = 66;
    }

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[7 / 8] ^= 128;//Math.pow(2, 7 % 8)
//        super.setGlow();
//    }
}
