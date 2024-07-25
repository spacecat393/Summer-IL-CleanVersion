package com.nali.summer.entity.memo.client.resa;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderResa;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.ClientSleInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import com.nali.sound.NoSound;
import com.nali.sound.Sound;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class ClientResa<RG extends MemoGs, RS extends MemoSs, RC extends IClientDaS, RST extends StoreS<RG, RS>, R extends RenderResa<E, I, MB, MR, ?, SD, BD, RG, RS, RST, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, MR>
{
    public static int[] IV_INT_ARRAY = new int[]
    {
        7+58 + MODEL_S_STEP, 15515,
        7+58 + MODEL_S_STEP, 16019,
        1+58 + MODEL_S_STEP, 176,
        7+58 + MODEL_S_STEP, 2115,
        7+58 + MODEL_S_STEP, 1941,
        10+58 + MODEL_S_STEP, 52
    };
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        0.0F, 0.0F,
        0.0F, 0.0F
    };
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.09F * 0.5F,
        0.0F, -1.3F * 0.5F, 0.11F * 0.5F,
        0.0F, -1.25F * 0.5F, 0.11F * 0.5F
    };

//    @SideOnly(Side.CLIENT)
    public int client_eyes_tick;

    public ClientResa(I i, R r, Inventory inventory)
    {
        super(i, r, inventory);
    }

    @Override
    public void updateClient()
    {
        int frame = this.r.frame_int_array[0];

        E e = this.i.getE();
        if (e.ticksExisted % 200 == 0)
        {
            this.r.model_byte_array[0 / 8] &= 255-1;//255 - Math.pow(2, 0 % 8)
            this.r.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
            this.r.model_byte_array[8 / 8] &= 255-1;//255 - Math.pow(2, 8 % 8)
            this.client_eyes_tick = 20;
        }
        else if (--this.client_eyes_tick <= 0)
        {
            this.r.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
            this.r.model_byte_array[5 / 8] &= 255-32;//255 - Math.pow(2, 5 % 8)
            this.r.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
        }

        if (frame > 125 && frame < 227)
        {
            this.r.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
        }
        else
        {
            this.r.model_byte_array[6 / 8] &= 255-64;//255 - Math.pow(2, 6 % 8)
        }

        float scale = this.r.scale;
        if (frame > 600 && frame < 652)
        {
            e.width = 1.5F * scale;
            e.height = 0.2F * scale;
        }
        else
        {
            BD bd = this.i.getBD();
            e.width = bd.Width() * scale;
            e.height = bd.Height() * scale;
        }

//        skinningrender.model_byte_array[3 / 8] &= 255-8;//255 - Math.pow(2, 3 % 8)
    }

    @Override
    public void initFakeFrame()
    {
        this.r.model_byte_array[0 / 8] &= 255-1;//255 - Math.pow(2, 0 % 8)
//        skinningrender.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
        this.r.model_byte_array[8 / 8] &= 255-1;//255 - Math.pow(2, 8 % 8)
        super.initFakeFrame();
    }

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
