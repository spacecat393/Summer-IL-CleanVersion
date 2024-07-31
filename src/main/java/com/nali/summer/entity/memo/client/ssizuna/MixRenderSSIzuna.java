package com.nali.summer.entity.memo.client.ssizuna;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.render.RenderS;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixRenderSSIzuna<RC extends IClientDaS, R extends RenderS<BD, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RC, R, SD, BD, E, I, ?, C>, C extends ClientSle<RC, R, SD, BD, E, I, MB, ?>> extends MixRenderSleInv<RC, R, SD, BD, E, I, MB, C>
{
    public MixRenderSSIzuna(C c)
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
        head_m4x4.multiply(r.skinning_float_array, 38*16);

        body_m4x4.multiply(r.skinning_float_array, 0);
    }
}
