package com.nali.list.entity.render;

import com.nali.data.client.SkinningClientData;
import com.nali.list.entity.SummerIbuki;
import com.nali.list.render.s.IbukiRender;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.skinning.render.SkinningEntitiesRender;
import com.nali.system.opengl.memory.OpenGLAnimationMemory;
import com.nali.system.opengl.memory.OpenGLCurrentMemory;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import static com.nali.list.entity.render.SummerIrohaRender.setAnimation;
import static com.nali.summer.entity.memory.client.ClientIroha.IV_INT_ARRAY;
import static com.nali.system.ClientLoader.OBJECT_LIST;

@SideOnly(Side.CLIENT)
public class SummerIbukiRender<T extends SummerIbuki> extends SkinningEntitiesRender<T>
{
    public SummerIbukiRender(RenderManager rendermanager)
    {
        super(rendermanager);
    }
}
