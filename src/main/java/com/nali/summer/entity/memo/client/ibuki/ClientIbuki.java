package com.nali.summer.entity.memo.client.ibuki;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.data.client.IClientDaS;
import com.nali.list.render.s.RenderIbuki;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.ClientSleInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundLe;
import com.nali.sound.NoSound;
import com.nali.sound.Sound;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class ClientIbuki<RG extends MemoGs, RS extends MemoSs, RC extends IClientDaS, RST extends StoreS<RG, RS>, R extends RenderIbuki<E, I, MB, MR, ?, SD, BD, RG, RS, RST, RC>, SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, MR>
{
    public static int[] IV_INT_ARRAY = new int[]
    {
        9+115 + MODEL_S_STEP, 2882,
        9+115 + MODEL_S_STEP, 5893,
        4+115 + MODEL_S_STEP, 290,
        9+115 + MODEL_S_STEP, 969,
        9+115 + MODEL_S_STEP, 624,
        14+115 + MODEL_S_STEP, 38
    };
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        180.0F, -135.0F,
        -180.0F, -135.0F
    };
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.09F * 0.5F,
        0.025F * 0.5F, -1.1F * 0.5F, 0.11F * 0.5F,
        0.025F * 0.5F, -1.05F * 0.5F, 0.11F * 0.5F
    };

    public int client_eyes_tick;

    public ClientIbuki(I i, R r, Inventory inventory)
    {
        super(i, r, inventory);
    }

    @Override
    public void updateClient()
    {
        int frame = skinningrender.frame_int_array[0];

        if (this.ticksExisted % 200 == 0)
        {
//            skinningrender.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
//            skinningrender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
            skinningrender.model_byte_array[0] &= 254 & 253;
            skinningrender.model_byte_array[2 / 8] |= 4;//Math.pow(2, 2 % 8)
            skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
            skinningrender.model_byte_array[12 / 8] |= 16;//Math.pow(2, 12 % 8)
            cliententitiesmemory.client_eyes_tick = 20;
        }
        else if (--cliententitiesmemory.client_eyes_tick <= 0)
        {
//            skinningrender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
//            skinningrender.model_byte_array[1 / 8] |= 2;//Math.pow(2, 1 % 8)
            skinningrender.model_byte_array[0] |= 1 | 2;
            skinningrender.model_byte_array[2 / 8] &= 251;//255 - Math.pow(2, 2 % 8)
            skinningrender.model_byte_array[11 / 8] |= 8;//Math.pow(2, 11 % 8)
            skinningrender.model_byte_array[12 / 8] &= 239;//255 - Math.pow(2, 12 % 8)
        }

        float scale = skinningrender.entitiesrendermemory.scale;

        if (frame > 296 && frame < 348)
        {
            this.width = 1.5F * scale;
            this.height = 0.2F * scale;
        }
        else
        {
            this.width = bothdata.Width() * scale;
            this.height = bothdata.Height() * scale;
        }
    }

    @Override
    public void updateRendering(EntityDataManager entitydatamanager)
    {
        super.updateRendering(entitydatamanager);
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        RenderIbuki ibukirender = (RenderIbuki)cliententitiesmemory.objectrender;
        ibukirender.iroharender.frame_int_array[0] = entitydatamanager.get(this.getIntegerDataParameterArray()[1]);
    }

    @Override
    public void initFakeFrame()
    {
        RenderIbuki skinningrender = (RenderIbuki)this.objectrender;
//        skinningrender.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
//        skinningrender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
        skinningrender.model_byte_array[0] &= 254 & 253;
        skinningrender.model_byte_array[2 / 8] |= 4;//Math.pow(2, 2 % 8)
        skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
        skinningrender.model_byte_array[12 / 8] |= 16;//Math.pow(2, 12 % 8)
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
