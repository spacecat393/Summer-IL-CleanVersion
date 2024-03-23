package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.SummerSSHimi;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.summer.render.RenderHelper;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SSHimiRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = SummerSSHimi.BOTHDATA;

    public SSHimiRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
        this.texture_index_int_array[0] = 1;
        this.texture_index_int_array[1] = 2;
        this.texture_index_int_array[2] = 6;
        this.texture_index_int_array[3] = 3;
        this.texture_index_int_array[4] = 4;
        this.texture_index_int_array[5] = 8;
        this.texture_index_int_array[6] = 7;
        this.texture_index_int_array[7] = 5;
        this.texture_index_int_array[8] = 0;
        this.texture_index_int_array[9] = 0;
        this.texture_index_int_array[10] = 0;
        this.texture_index_int_array[11] = 9;
        this.texture_index_int_array[12] = 0;
    }

    @Override
    public void setGlow()
    {
        this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
        super.setGlow();
    }

//    public static float block(int i)
//    {
//        return i & 0xFFFF;
//    }
//
//    public static float sky(int i)
//    {
//        return (i >> 16) & 0xFFFF;
//    }

//    @Override
//    public void setTextureUniform(OpenGLObjectMemory openglobjectmemory, OpenGLObjectShaderMemory openglobjectshadermemory, int index)
//    {
//        GL20.glUniform1i(openglobjectshadermemory.uniformlocation_int_array[0], 0);
//        GL13.glActiveTexture(33984);
//        OpenGLBuffer.setTextureBuffer(Minecraft.getMinecraft().getFramebuffer().framebufferTexture, openglobjectmemory.texture_state);
//    }

//    @Override
//    public void setLightMapUniform(OpenGLObjectShaderMemory openglobjectshadermemory)
//    {
//        GL20.glUniform1i(openglobjectshadermemory.uniformlocation_int_array[1], 1);
//        GL13.glActiveTexture(33985);
//        OpenGLBuffer.setLightMapBuffer(Minecraft.getMinecraft().getFramebuffer().framebufferTexture);
//    }

//    @Override
//    public void updateLightCoord()
//    {
//        super.updateLightCoord();
//
//        int brightness = this.skinningentities.getBrightnessForRender();
//        this.lig_b = brightness & 0xFFFF;
//        this.lig_s = (brightness >> 16) & 0xFFFF;
//    }
}
