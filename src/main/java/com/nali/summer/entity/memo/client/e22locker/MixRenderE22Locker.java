package com.nali.summer.entity.memo.client.e22locker;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.math.Quaternion;
import com.nali.render.RenderS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.IClientS;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixRenderE22Locker<RC extends IClientDaS, R extends RenderS<BD, RC>, SD, BD extends IBothDaNe & IBothDaSn, E extends Entity, I extends IMixE<SD, BD, E>, MB extends MixBoxE<RC, R, SD, BD, E, I, ?, C>, C extends ClientE<RC, R, SD, BD, E, I, MB, ?> & IClientS<RC, R, SD, BD, E, I, ?>> extends MixRenderSe<RC, R, SD, BD, E, I, MB, C>
{
    public MixRenderE22Locker(C c)
    {
        super(c);
        this.shadow_opaque = 0.5F;
        this.shadow_size = 0.25F;
    }

    @Override
    public void multiplyAnimation()
    {
        new Quaternion(0, 0, this.head_rot).getM4x4().multiply(this.c.r.skinning_float_array, 0);
    }
}
