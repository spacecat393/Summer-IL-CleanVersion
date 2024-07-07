package com.nali.summer.entity.memo.client.sshimi;

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
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixRenderSSHimi<RG extends MemoGs, RS extends MemoSs, RC extends IClientDaS, RST extends StoreS<RG, RS>, R extends RenderS<BD, RG, RS, RST, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, R, SD, BD, E, I, ?, C>, C extends ClientSle<RG, RS, RC, RST, R, SD, BD, E, I, MB, ?>> extends MixRenderSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, C>
{
    public MixRenderSSHimi(C c)
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
//        M4x4 inverse_body_m4x4 = new Quaternion(0.0F, skinningrender.body_rot, 0.0F).getM4x4();

        R r = this.c.r;
        if (r.frame_int_array[0] < 379)
        {
            M4x4 head_m4x4 = new Quaternion(0, 0, this.net_head_yaw).getM4x4();

            head_m4x4.multiply(r.skinning_float_array, 16 * 16);
        }
        else
        {
            M4x4 head_m4x4 = new Quaternion(-head_pitch, 0, this.net_head_yaw).getM4x4();

            head_m4x4.multiply(r.skinning_float_array, 74 * 16);
        }

        body_m4x4.multiply(r.skinning_float_array, 0);
    }
}
