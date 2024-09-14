package com.nali.summer.entity.memo.client.ssshizuko;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderSSShizuko;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientRsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.FRenderE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class MixRenderSSShizuko<IE extends InvLe, RC extends IClientDaS, R extends RenderSSShizuko<E, I, MB, ?, C, SD, BD, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixE<SD, BD, E>, MC extends MixCIE<RC, R, SD, BD, E, I, MB, ?, C>, MB extends MixBoxSleInv<RC, R, SD, BD, E, I, MC, ?, C>, C extends ClientLeInv<IE, RC, R, SD, BD, E, I, MC, MB, ?> & IClientRsInv> extends MixRenderSleInv<IE, RC, R, SD, BD, E, I, MC, MB, C>
{
	public MixRenderSSShizuko(C c)
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
//		body_m4x4.multiply(sszukorender.seahouserender.skinning_float_array, 0);
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
