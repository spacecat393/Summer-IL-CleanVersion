package com.nali.summer.entity.memory.client;

import com.nali.data.BothData;
import com.nali.list.render.s.RenderMYuzu;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientMYuzu extends ClientEntitiesMemory
{
//    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        5+90 + MODEL_STEP, 11946,
        5+90 + MODEL_STEP, 10846,
        1+90 + MODEL_STEP, 557,
        5+90 + MODEL_STEP, 13404,
        5+90 + MODEL_STEP, 9960,
        8+90 + MODEL_STEP, 69
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
        0.0F, -1.1F * 0.5F, 0.11F * 0.5F,
        0.0F, -1.05F * 0.5F, 0.11F * 0.5F
    };

    public ClientMYuzu(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }

    @Override
    public void initFakeFrame()
    {
        ((SkinningRender)this.objectrender).frame_int_array[0] = 110;
    }

    @Override
    public ObjectRender createObjectRender()
    {
        return new RenderMYuzu(new EntitiesRenderMemory(), this.main_skinningentities);
    }

    @Override
    public SoundRender createSoundRender()
    {
        return new NoSoundRender();
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientMYuzu.IV_INT_ARRAY;
    }
}
