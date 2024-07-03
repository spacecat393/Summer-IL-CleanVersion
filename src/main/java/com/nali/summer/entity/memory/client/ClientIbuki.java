package com.nali.summer.entity.memory.client;

import com.nali.data.BothData;
import com.nali.list.render.s.IbukiRender;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.NoSoundRender;
import com.nali.render.ObjectRender;
import com.nali.render.SoundRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientIbuki extends ClientEntitiesMemory
{
//    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        9+128 + MODEL_STEP, 2882,
        9+128 + MODEL_STEP, 5893,
        4+128 + MODEL_STEP, 290,
        9+128 + MODEL_STEP, 969,
        9+128 + MODEL_STEP, 624,
        14+128 + MODEL_STEP, 38
    };
//    @SideOnly(Side.CLIENT)
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        180.0F, -135.0F,
        -180.0F, -135.0F
    };
//    @SideOnly(Side.CLIENT)
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.09F * 0.5F,
        0.025F * 0.5F, -1.1F * 0.5F, 0.11F * 0.5F,
        0.025F * 0.5F, -1.05F * 0.5F, 0.11F * 0.5F
    };

//    @SideOnly(Side.CLIENT)
    public int client_eyes_tick;

    public ClientIbuki(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }

    @Override
    public ObjectRender createObjectRender()
    {
        return new IbukiRender(new EntitiesRenderMemory(), this.main_skinningentities);
    }

    @Override
    public SoundRender createSoundRender()
    {
        return new NoSoundRender();
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientIbuki.IV_INT_ARRAY;
    }

    @Override
    public void initFakeFrame()
    {
        IbukiRender skinningrender = (IbukiRender)this.objectrender;
//        skinningrender.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
//        skinningrender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
        skinningrender.model_byte_array[0] &= 254 & 253;
        skinningrender.model_byte_array[2 / 8] |= 4;//Math.pow(2, 2 % 8)
        skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
        skinningrender.model_byte_array[12 / 8] |= 16;//Math.pow(2, 12 % 8)
    }
}
