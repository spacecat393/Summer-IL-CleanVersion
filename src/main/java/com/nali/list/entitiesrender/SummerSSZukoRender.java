package com.nali.list.entitiesrender;

import com.nali.list.entities.SummerSSZuko;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.skinning.render.SkinningEntitiesRender;
import com.nali.summer.render.SSZukoRender;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SummerSSZukoRender<T extends SummerSSZuko> extends SkinningEntitiesRender<T>
{
    public SummerSSZukoRender(RenderManager rendermanager)
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
        this.shadowOpaque = 0.5F;
        this.shadowSize = 0.25F;

        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)entities.bothentitiesmemory;
        SSZukoRender sszukorender = ((SSZukoRender)cliententitiesmemory.objectrender);
        EntitiesRenderMemory entitiesrendermemory = sszukorender.entitiesrendermemory;

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
        M4x4 head_m4x4 = new Quaternion(-head_pitch, 0, entitiesrendermemory.net_head_yaw).getM4x4();

        head_m4x4.multiply(sszukorender.skinning_float_array, 6*16);

        body_m4x4.multiply(sszukorender.skinning_float_array, 0);
//        body_m4x4.multiply(sszukorender.seahouserender.skinning_float_array, 0);
    }

    @Override
    public void updateData(T entities, float partialTicks)
    {
        super.updateData(entities, partialTicks);
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)entities.bothentitiesmemory;
        SSZukoRender sszukorender = ((SSZukoRender)cliententitiesmemory.objectrender);
        sszukorender.seahouserender.objectworlddraw.renderWorld();
    }
}
