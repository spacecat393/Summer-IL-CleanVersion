package com.nali.summer.entities.memory.client;

import com.nali.data.BothData;
import com.nali.list.render.s.SaoriRender;
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
public class ClientSaoriMemory extends ClientEntitiesMemory
{
//    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        4+118 + MODEL_STEP, 6697,
        4+118 + MODEL_STEP, 7694,
        4+118 + MODEL_STEP, 11839,
        4+118 + MODEL_STEP, 2735,
        4+118 + MODEL_STEP, 1759,
        8+118 + MODEL_STEP, 39
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

    public ClientSaoriMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }

    @Override
    public ObjectRender createObjectRender()
    {
        return new SaoriRender(new EntitiesRenderMemory(), this.main_skinningentities);
    }


    @Override
    public SoundRender createSoundRender()
    {
        return new NoSoundRender();
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientSaoriMemory.IV_INT_ARRAY;
    }
}
