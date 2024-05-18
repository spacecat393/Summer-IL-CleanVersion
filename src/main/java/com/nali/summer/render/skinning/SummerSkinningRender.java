package com.nali.summer.render.skinning;

import com.nali.data.BothData;
import com.nali.data.client.ClientData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.system.opengl.memory.OpenGLObjectMemory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.SHADER_STEP;
import static com.nali.list.data.SummerData.TEXTURE_STEP;

@SideOnly(Side.CLIENT)
public class SummerSkinningRender extends SkinningRender
{
    public SummerSkinningRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, ClientData clientdata)
    {
        super(entitiesrendermemory, bothdata, clientdata);
    }

    @Override
    public int getTextureID(OpenGLObjectMemory openglobjectmemory)
    {
        return TEXTURE_STEP + super.getTextureID(openglobjectmemory);
    }

    @Override
    public int getShaderID(OpenGLObjectMemory openglobjectmemory)
    {
        return SHADER_STEP + super.getShaderID(openglobjectmemory);
    }
}
