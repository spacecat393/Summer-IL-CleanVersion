package com.nali.list.entity.render;

import com.nali.data.client.SkinningClientData;
import com.nali.list.entity.SummerIbuki;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.skinning.render.SkinningEntitiesRender;
import com.nali.system.opengl.memory.OpenGLAnimationMemory;
import com.nali.system.opengl.memory.OpenGLCurrentMemory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.system.ClientLoader.OBJECT_LIST;

@SideOnly(Side.CLIENT)
public class SummerFRenderIbuki<T extends SummerIbuki> extends SkinningEntitiesRender<T>
{
    public SummerFRenderIbuki(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
