package com.nali.summer.entity.memo.client.e22locker;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.render.RenderS;
import com.nali.small.entity.EntityEInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.ClientSeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.sound.Sound;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class ClientE22Locker<RG extends MemoGs, RS extends MemoSs, RC extends IClientDaS, RST extends StoreS<RG, RS>, R extends RenderS<BD, RG, RS, RST, RC>, SD, BD extends IBothDaNe & IBothDaSn, E extends EntityEInv, I extends IMixE<SD, BD, E>, MB extends MixBoxE<RG, RS, RC, RST, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSe<RG, RS, RC, RST, R, SD, BD, E, I, MB, ?>> extends ClientSeInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, MR>
{
    public static int[] IV_INT_ARRAY = new int[]
    {
        5+90 + MODEL_S_STEP, 523,
        5+90 + MODEL_S_STEP, 560,
        5+90 + MODEL_S_STEP, 12,
        5+90 + MODEL_S_STEP, 451,
        5+90 + MODEL_S_STEP, 451,
        4+90 + MODEL_S_STEP, 99
    };
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        0.0F, 0.0F,
        0.0F, 0.0F
    };
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.65F * 0.5F, 0.0F,
        0.1F, -1.8F * 0.5F, 0.07F * 0.5F,
        0.1F, -1.85F * 0.5F, 0.09F * 0.5F,
        0.1F, -1.8F * 0.5F, 0.09F * 0.5F
    };

    public ClientE22Locker(I i, R r, Inventory inventory)
    {
        super(i, r, inventory);
    }

//    @Override
//    public void initFakeFrame()
//    {
//
//    }

    @Override
    public Sound createSound()
    {
        return null;
    }

    @Override
    public int[] getIVIntArray()
    {
        return IV_INT_ARRAY;
    }

    @Override
    public float[] getRotationFloatArray()
    {
        return ROTATION_FLOAT_ARRAY;
    }

    @Override
    public float[] getTransformFloatArray()
    {
        return TRANSFORM_FLOAT_ARRAY;
    }
//    @Override
//    public void updateClient()
//    {
//        super.updateClient();
//
//        E e = this.i.getE();
//        e.rotationYawHead = e.rotationYaw;
//        e.prevRotationYawHead = e.rotationYaw;
//        e.renderYawOffset = e.rotationYaw;
//    }
}
