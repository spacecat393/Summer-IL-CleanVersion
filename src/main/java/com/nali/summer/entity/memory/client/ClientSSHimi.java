package com.nali.summer.entity.memory.client;

import com.nali.data.BothData;
import com.nali.list.render.s.SSHimiRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientSSHimi extends ClientEntitiesMemory
{
//    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        0+1 + MODEL_STEP, 9046,
        0+1 + MODEL_STEP, 2581,
        4+1 + MODEL_STEP, 1275,
        0+1 + MODEL_STEP, 9224,
        0+1 + MODEL_STEP, 7860,
        12+1 + MODEL_STEP, 69
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
        0.0F, -1.0F * 0.5F, 0.01F * 0.5F,
        0.0F, -1.2F * 0.5F, 0.14F * 0.5F,
        0.0F, -1.15F * 0.5F, 0.14F * 0.5F
    };

    public ClientSSHimi(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }

    @Override
    public void initFakeFrame()
    {
        ((SkinningRender)this.objectrender).frame_int_array[0] = 379;
    }

    @Override
    public ObjectRender createObjectRender()
    {
        return new SSHimiRender(new EntitiesRenderMemory(), this.main_skinningentities);
    }

    @Override
    public SoundRender createSoundRender()
    {
        return new NoSoundRender();
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientSSHimi.IV_INT_ARRAY;
    }
}
