package com.nali.summer.entities.memory.client;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientIbukiMemory extends ClientEntitiesMemory
{
    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        9, 2882,
        9, 5893,
        4, 290,
        9, 969,
        9, 624,
        14, 38
    };
    @SideOnly(Side.CLIENT)
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        180.0F, -135.0F,
        -180.0F, -135.0F
    };
    @SideOnly(Side.CLIENT)
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.09F * 0.5F,
        0.025F * 0.5F, -1.1F * 0.5F, 0.11F * 0.5F,
        0.025F * 0.5F, -1.05F * 0.5F, 0.11F * 0.5F
    };

    @SideOnly(Side.CLIENT)
    public int client_eyes_tick;

    public ClientIbukiMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }
}
