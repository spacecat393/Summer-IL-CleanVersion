package com.nali.list.render.s;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.data.client.IClientDaS;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderE;
import com.nali.sound.ISoundLe;
import com.nali.summer.data.both.BothDaSSZuko;
import com.nali.summer.data.both.BothDaSeaHouse;
import com.nali.summer.data.client.ClientDaSSZuko;
import com.nali.summer.data.client.ClientDaSeaHouse;
import com.nali.summer.render.s.SummerRenderSe;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.Nali.I;

@SideOnly(Side.CLIENT)
public class RenderSSZuko<E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, ?, SD, BD, E, I, MR, C>, MR extends MixRenderE<RG, RS, RC, RST, ?, SD, BD, E, I, MB, C>, C extends ClientSle<RG, RS, RC, RST, ?, SD, BD, E, I, MB, MR>, SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends SummerRenderSe<E, I, MB, MR, C, SD, BD, RG, RS, RST, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = SummerSSZuko.BOTHDATA;
//    public static IClientDaS ICLIENTDAS = new SSZukoClientDa();
    public RenderSeaHouse seahouserender;
//    public byte[] model_byte_array;

    public RenderSSZuko()
    {
        this((RST)I.clientloader.stores, (RC) ClientDaSSZuko.ICLIENTDAS, (BD) BothDaSSZuko.IBOTHDASN);
    }

    public RenderSSZuko(RST rst, RC rc, BD bd)
    {
        super(rst, rc, bd);
//        this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 25;
//        this.texture_index_int_array[1] = 26;
//        this.texture_index_int_array[2] = 27;
//        this.texture_index_int_array[3] = 27;
//        this.texture_index_int_array[4] = 28;
//        this.texture_index_int_array[5] = 29;
//        this.texture_index_int_array[6] = 30;
//        this.texture_index_int_array[7] = 32;
//        this.texture_index_int_array[8] = 9;
//        this.texture_index_int_array[9] = 32;
//        this.texture_index_int_array[10] = 32;
//        this.texture_index_int_array[11] = 31;
        this.seahouserender = new RenderSeaHouse(I.clientloader.stores, ClientDaSeaHouse.ICLIENTDAS, BothDaSeaHouse.IBOTHDASN);
    }

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
//        super.setGlow();
//    }

    @Override
    public void updateLightCoord()
    {
        super.updateLightCoord();
        this.seahouserender.lig_b = this.lig_b;
        this.seahouserender.lig_s = this.lig_s;
    }

    @Override
    public void initSkinning(/*MemoAnimation memoanimation*/)
    {
        super.initSkinning(/*memoanimation*/);
//        this.seahouserender.initSkinning((OpenGLAnimationMemory)this.dataloader.object_array[((SkinningClientData)this.seahouserender.clientdata).AnimationID()]);
        this.seahouserender.initSkinning(/*this.rst.memoanimation_list.get(this.seahouserender.rc.AnimationID())*/);
    }

    @Override
    public void setSkinning(/*MemoAnimation memoanimation*/)
    {
        super.setSkinning(/*memoanimation*/);
//        this.seahouserender.setSkinning((OpenGLAnimationMemory)this.dataloader.object_array[((SkinningClientData)this.seahouserender.clientdata).AnimationID()]);
        this.seahouserender.setSkinning(/*this.rst.memoanimation_list.get(this.seahouserender.rc.AnimationID())*/);
    }

//    @Override
//    public void draw(int index)
//    {
//        if ((this.model_byte_array[index / 8] >> index % 8 & 1) == 1)
//        {
//            super.draw(index);
//        }
//    }
}