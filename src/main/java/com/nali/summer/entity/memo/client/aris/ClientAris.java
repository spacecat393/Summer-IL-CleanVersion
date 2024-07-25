package com.nali.summer.entity.memo.client.aris;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderAris;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.ClientSleInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import com.nali.sound.NoSound;
import com.nali.sound.Sound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientAris<RC extends IClientDaS, R extends RenderAris<E, I, MB, MR, ?, SD, BD, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RC, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RC, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RC, R, SD, BD, E, I, MB, MR>
{
//    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        5+25 + MODEL_STEP, 8547,
        5+25 + MODEL_STEP, 9270,
        /*0+*/25 + MODEL_STEP, 2078,
        5+25 + MODEL_STEP, 268,
        5+25 + MODEL_STEP, 519,
        8+25 + MODEL_STEP, 39
    };
//    @SideOnly(Side.CLIENT)
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        0.0F, 0.0F,
        0.0F, 0.0F
    };
//    @SideOnly(Side.CLIENT)
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.05F * 0.5F,
        0.0F, -1.1F * 0.5F, 0.12F * 0.5F,
        0.0F, -1.05F * 0.5F, 0.12F * 0.5F
    };

    public ClientAris(I i, R r, Inventory inventory)
    {
        super(i, r, inventory);
    }

    @Override
    public void updateClient()
    {
        int frame = this.r.frame_int_array[0];

        if (frame < 205)
        {
//            skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
//            skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
            this.r.model_byte_array[0] &= 239 & 191;
        }
        else
        {
//            skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
//            skinningrender.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
            this.r.model_byte_array[0] |= 16 | 64;
        }

        float scale = this.r.scale;
        BD bd = this.i.getBD();
        E e = this.i.getE();
        if (frame > 834 && frame < 861)
        {
            e.width = bd.Width() * scale;
            e.height = 0.65F * scale;
        }
        else if (frame > 737 && frame < 784)
        {
            e.width = 1.5F * scale;
            e.height = 0.2F * scale;
        }
        else
        {
            e.width = bd.Width() * scale;
            e.height = bd.Height() * scale;
        }
    }

//    @Override
//    public void initFakeFrame()
//    {
////        int max_bones = this.r.rst.memoanimation_list.get(this.r.rc.FrameID()).bones;
////
////        float[] f = new float[]
////        {
////            -1, 0, 0, 0,
////            0, -1, 0, 0,
////            0, 0, -1, 0,
////            0, 0, 0, 1
////        };
////        System.arraycopy(f, 0, this.r.skinning_float_array, 0, 16);
////        for (int i = 0; i < max_bones; ++i)
////        {
////            System.arraycopy(M4x4.IDENTITY, 0, this.r.skinning_float_array, i * 16, 16);
////        }
////        this.r.initSkinning();
////        this.r.setSkinning();
////        this.mr.updateSkinning();
////        super.initFakeFrame();
//    }

    @Override
    public Sound createSound()
    {
        return new NoSound();
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
}
