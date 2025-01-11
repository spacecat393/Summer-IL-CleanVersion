package com.nali.summer.entity.memo.client.ssshizuko;

import com.nali.list.da.BothDaSSShizuko;
import com.nali.list.render.RenderSSShizuko;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.small.render.IRenderS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixRenderSSShizuko
<
	IE extends InvLe,
	R extends RenderSSShizuko<IE, E, I, MC, MB, ?, C> & IRenderS<BothDaSSShizuko, R>,
	E extends EntityLe,
	I extends IMixE<BothDaSSShizuko, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSSShizuko, R, E, I, MB, ?, C>,
	MB extends MixBoxSleInv<BothDaSSShizuko, R, E, I, MC, ?, C>,
	C extends ClientLeInv<IE, BothDaSSShizuko, R, E, I, MC, MB, ?>
> extends MixRenderSleInv<IE, BothDaSSShizuko, R, E, I, MC, MB, C>
{
	public MixRenderSSShizuko(C c)
	{
		super(c);
		this.shadow_opaque = 0.5F;
		this.shadow_size = 0.25F;
	}

//	@Override
//	public void doRender(FRenderE<E> rendere, double ox, double oy, double oz, float partialTicks)
//	{
//		super.doRender(rendere, ox, oy, oz, partialTicks);
//		GL11.glPushMatrix();
//		GL11.glTranslated(ox, oy, oz);
//		R r = this.c.r;
//		float s = r.scale;
//		GL11.glScaled(s, s, s);
//		GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
//		r.seahouserender.draw(BothDaSeaHouse.IDA/*ox, oy, oz*/);
//		GL11.glPopMatrix();
//	}
}
