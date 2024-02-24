package com.nali.list.entitiesrender;

import com.nali.list.entities.SummerIbuki;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.render.SkinningRender;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.skinning.render.SkinningEntitiesRender;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerIbukiRender<T extends SummerIbuki> extends SkinningEntitiesRender<T>
{
    public SummerIbukiRender(RenderManager rendermanager)
    {
        super(rendermanager);
    }

    @Override
    public ResourceLocation getEntityTexture(T entities)
    {
        return null;
    }

    @Override
    public void multiplyAnimation(T entities)
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)entities.bothentitiesmemory;
        SkinningRender skinningrender = ((SkinningRender)cliententitiesmemory.objectrender);

        float head_pitch = skinningrender.head_pitch;
        if (skinningrender.head_pitch > 1.04719755119659774615F)
        {
            head_pitch = 1.04719755119659774615F;
        }
        else if (skinningrender.head_pitch < -1.04719755119659774615F)
        {
            head_pitch = -1.04719755119659774615F;
        }
        M4x4 body_m4x4 = new Quaternion(0.0F, 0.0F, skinningrender.body_rot).getM4x4();
        M4x4 head_m4x4 = new Quaternion(-head_pitch, 0, skinningrender.net_head_yaw).getM4x4();

        head_m4x4.multiply(skinningrender.skinning_float_array, 39*16);

        body_m4x4.multiply(skinningrender.skinning_float_array, 0);
    }
}
