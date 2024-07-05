package com.nali.summer.entity.memory.client;

import com.nali.data.BothData;
import com.nali.list.render.s.RenderResa;
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
public class ClientResa extends ClientEntitiesMemory
{
//    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        7+65 + MODEL_STEP, 15515,
        7+65 + MODEL_STEP, 16019,
        1+65 + MODEL_STEP, 176,
        7+65 + MODEL_STEP, 2115,
        7+65 + MODEL_STEP, 1941,
        10+65 + MODEL_STEP, 52
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
        0.0F, -1.0F * 0.5F, 0.09F * 0.5F,
        0.0F, -1.3F * 0.5F, 0.11F * 0.5F,
        0.0F, -1.25F * 0.5F, 0.11F * 0.5F
    };

//    @SideOnly(Side.CLIENT)
    public int client_eyes_tick;

    public ClientResa(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }

    @Override
    public void initFakeFrame()
    {
        RenderResa skinningrender = (RenderResa)this.objectrender;
        skinningrender.model_byte_array[0 / 8] &= 255-1;//255 - Math.pow(2, 0 % 8)
//        skinningrender.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
        skinningrender.model_byte_array[8 / 8] &= 255-1;//255 - Math.pow(2, 8 % 8)
    }

    @Override
    public ObjectRender createObjectRender()
    {
        return new RenderResa(new EntitiesRenderMemory(), this.main_skinningentities);
    }

    @Override
    public SoundRender createSoundRender()
    {
        return new NoSoundRender();
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientResa.IV_INT_ARRAY;
    }
}
