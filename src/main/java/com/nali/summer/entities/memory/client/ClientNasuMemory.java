package com.nali.summer.entities.memory.client;

import com.nali.data.BothData;
import com.nali.list.render.s.NasuRender;
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
public class ClientNasuMemory extends ClientEntitiesMemory
{
//    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        7+15 + MODEL_STEP, 3319,
        7+15 + MODEL_STEP, 5470,
        4+15 + MODEL_STEP, 7013,
        7+15 + MODEL_STEP, 1454,
        7+15 + MODEL_STEP, 1690,
        11+15 + MODEL_STEP, 45
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
        0.0F, -1.2F * 0.5F, 0.11F * 0.5F,
        0.0F, -1.15F * 0.5F, 0.11F * 0.5F
    };

    public ClientNasuMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }

    @Override
    public ObjectRender createObjectRender()
    {
        return new NasuRender(new EntitiesRenderMemory(), this.main_skinningentities);
    }

    @Override
    public SoundRender createSoundRender()
    {
        return new NoSoundRender();
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientNasuMemory.IV_INT_ARRAY;
    }
}
