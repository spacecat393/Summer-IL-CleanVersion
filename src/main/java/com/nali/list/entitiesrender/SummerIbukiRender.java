package com.nali.list.entitiesrender;

import com.nali.list.entities.SummerIbuki;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.render.SkinningRender;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.skinning.render.SkinningEntitiesRender;
import com.nali.summer.render.IbukiRender;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

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

    @Override
    public void doRender(T skinningentities, double ox, double oy, double oz, float entityYaw, float partialTicks)
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)skinningentities.bothentitiesmemory;
        IbukiRender ibukirender = ((IbukiRender)cliententitiesmemory.objectrender);

        GL11.glPushMatrix();
//        if ((cliententitiesmemory.sync_byte_array[0] & 128) == 128)
//        {
//            float[] c_vec4 = this.get3DSkinning(ibukirender.iroharender, (float)ox, (float)oy, (float)oz, IV_INT_ARRAY[12], IV_INT_ARRAY[13]);
//            this.apply3DSkinningVec4(c_vec4);
//            ox = 0;
//            oy = 0;
//            oz = 0;
//
////            float[] c_mat4 = this.getMat43DSkinning(ibukirender.iroharender, IV_INT_ARRAY[12], IV_INT_ARRAY[13]);
////            float[] mat4 = new float[]
////            {
////                c_mat4[0], c_mat4[4], c_mat4[8], 0,
////                c_mat4[1], c_mat4[5], c_mat4[9], 0,
////                c_mat4[2], c_mat4[6], c_mat4[10], 0,
////                0, 0, 0, 1.0F
////            };
////            OpenGLCurrentMemory.setFloatBuffer(mat4);
////            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
////            GL11.glMultMatrix(OpenGLCurrentMemory.OPENGL_FLOATBUFFER);
//        }

        super.doRender(skinningentities, ox, oy, oz, entityYaw, partialTicks);
        GL11.glPopMatrix();
    }
}
