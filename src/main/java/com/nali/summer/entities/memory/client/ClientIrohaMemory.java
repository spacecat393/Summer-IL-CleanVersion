package com.nali.summer.entities.memory.client;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

public class ClientIrohaMemory extends ClientEntitiesMemory
{
    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        8+144 + MODEL_STEP, 837,
        8+144 + MODEL_STEP, 2145,
        8+144 + MODEL_STEP, 10171,
        8+144 + MODEL_STEP, 6617,
        8+144 + MODEL_STEP, 5653,
        10+144 + MODEL_STEP, 39,
        5+144 + MODEL_STEP, 26084
    };
    @SideOnly(Side.CLIENT)
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        0.0F, 0.0F,
        0.0F, 0.0F
    };
    @SideOnly(Side.CLIENT)
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.09F * 0.5F,
        0.0F, -1.2F * 0.5F, 0.11F * 0.5F,
        0.0F, -1.15F * 0.5F, 0.11F * 0.5F
    };

    public ClientIrohaMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }
}
