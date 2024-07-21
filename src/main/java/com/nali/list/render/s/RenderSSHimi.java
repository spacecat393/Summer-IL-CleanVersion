package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaSSHimi;
import com.nali.summer.da.client.ClientDaSSHimi;
import com.nali.summer.render.SummerRenderSe;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

import static com.nali.Nali.I;

@SideOnly(Side.CLIENT)
public class RenderSSHimi<E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, ?, SD, BD, E, I, MR, C>, MR extends MixRenderSe<RG, RS, RC, RST, ?, SD, BD, E, I, MB, C>, C extends ClientSle<RG, RS, RC, RST, ?, SD, BD, E, I, MB, MR>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends SummerRenderSe<E, I, MB, MR, C, SD, BD, RG, RS, RST, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static IClientDaS ICLIENTDAS = new SSHimiClientDa();
    public byte[] model_byte_array;

    public RenderSSHimi()
    {
        this((RST)I.clientloader.stores, (RC) ClientDaSSHimi.ICLIENTDAS, (BD) BothDaSSHimi.IBOTHDASN);
    }

    public RenderSSHimi(RST rst, RC rc, BD bd)
    {
        super(rst, rc, bd);
        this.model_byte_array = new byte[(int)Math.ceil((rc.EndPart() - rc.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 1;
//        this.texture_index_int_array[1] = 2;
//        this.texture_index_int_array[2] = 6;
//        this.texture_index_int_array[3] = 3;
//        this.texture_index_int_array[4] = 4;
//        this.texture_index_int_array[5] = 8;
//        this.texture_index_int_array[6] = 7;
//        this.texture_index_int_array[7] = 5;
//        this.texture_index_int_array[8] = 0;
//        this.texture_index_int_array[9] = 0;
//        this.texture_index_int_array[10] = 0;
//        this.texture_index_int_array[11] = 9;
//        this.texture_index_int_array[12] = 0;
        Arrays.fill(this.model_byte_array, (byte)255);
        this.model_byte_array[5 / 8] &= 255-32;//255 - Math.pow(2, 5 % 8)
    }

    @Override
    public void draw(int index)
    {
        int i = index - this.rc.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.draw(index);
        }
    }

    @Override
    public void drawLater(int index)
    {
        int i = index - this.rc.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.drawLater(index);
        }
    }

//    @Override
//    public void setGlow()
//    {
////        this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
//        super.setGlow();
//    }

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
