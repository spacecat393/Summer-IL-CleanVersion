package com.nali.summer.entity.memo.client.sszuko;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderSSZuko;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.FRenderE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class MixRenderSSZuko<RG extends MemoGs, RS extends MemoSs, RC extends IClientDaS, RST extends StoreS<RG, RS>, R extends RenderSSZuko<E, I, MB, ?, C, SD, BD, RG, RS, RST, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, R, SD, BD, E, I, ?, C>, C extends ClientSle<RG, RS, RC, RST, R, SD, BD, E, I, MB, ?>> extends MixRenderSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, C>
{
    public MixRenderSSZuko(C c)
    {
        super(c);
        this.shadow_opaque = 0.5F;
        this.shadow_size = 0.25F;
    }

    @Override
    public void multiplyAnimation()
    {
        float head_pitch = this.head_pitch;
        if (this.head_pitch > 1.04719755119659774615F)
        {
            head_pitch = 1.04719755119659774615F;
        }
        else if (this.head_pitch < -1.04719755119659774615F)
        {
            head_pitch = -1.04719755119659774615F;
        }
        M4x4 body_m4x4 = new Quaternion(0.0F, 0.0F, this.body_rot).getM4x4();
        M4x4 head_m4x4 = new Quaternion(-head_pitch, 0, this.net_head_yaw).getM4x4();

        R r = this.c.r;
        head_m4x4.multiply(r.skinning_float_array, 6*16);

        body_m4x4.multiply(r.skinning_float_array, 0);
//        body_m4x4.multiply(sszukorender.seahouserender.skinning_float_array, 0);
    }

    @Override
    public void doRender(FRenderE<E> rendere, double ox, double oy, double oz, float partialTicks)
    {
        super.doRender(rendere, ox, oy, oz, partialTicks);
        GL11.glPushMatrix();
        GL11.glTranslated(ox, oy, oz);
        R r = this.c.r;
        float s = r.scale;
        GL11.glScaled(s, s, s);
        GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
        r.seahouserender.draw(/*ox, oy, oz*/);
        GL11.glPopMatrix();
    }
}
