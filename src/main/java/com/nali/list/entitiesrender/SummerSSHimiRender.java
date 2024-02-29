package com.nali.list.entitiesrender;

import com.nali.list.entities.SummerSSHimi;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.skinning.render.SkinningEntitiesRender;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerSSHimiRender<T extends SummerSSHimi> extends SkinningEntitiesRender<T>
{
    public SummerSSHimiRender(RenderManager rendermanager)
    {
        super(rendermanager);
    }

    @Override
    public void multiplyAnimation(T entities)
    {
        this.shadowOpaque = 0.5F;
        this.shadowSize = 0.25F;

        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)entities.bothentitiesmemory;
        SkinningRender skinningrender = ((SkinningRender)cliententitiesmemory.objectrender);
        EntitiesRenderMemory entitiesrendermemory = skinningrender.entitiesrendermemory;

        float head_pitch = entitiesrendermemory.head_pitch;
        if (entitiesrendermemory.head_pitch > 1.04719755119659774615F)
        {
            head_pitch = 1.04719755119659774615F;
        }
        else if (entitiesrendermemory.head_pitch < -1.04719755119659774615F)
        {
            head_pitch = -1.04719755119659774615F;
        }
        M4x4 body_m4x4 = new Quaternion(0.0F, 0.0F, entitiesrendermemory.body_rot).getM4x4();
//        M4x4 inverse_body_m4x4 = new Quaternion(0.0F, skinningrender.body_rot, 0.0F).getM4x4();

        if (skinningrender.frame_int_array[0] < 379)
        {
            M4x4 head_m4x4 = new Quaternion(0, 0, entitiesrendermemory.net_head_yaw).getM4x4();

            head_m4x4.multiply(skinningrender.skinning_float_array, 16 * 16);
        }
        else
        {
            M4x4 head_m4x4 = new Quaternion(-head_pitch, 0, entitiesrendermemory.net_head_yaw).getM4x4();

            head_m4x4.multiply(skinningrender.skinning_float_array, 74 * 16);
        }

        body_m4x4.multiply(skinningrender.skinning_float_array, 0);
    }

    @Override
    public ResourceLocation getEntityTexture(T entities)
    {
        return null;
    }
}
