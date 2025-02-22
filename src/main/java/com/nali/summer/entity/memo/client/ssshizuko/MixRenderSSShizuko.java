//package com.nali.summer.entity.memo.client.ssshizuko;
//
//import com.nali.list.da.BothDaSSShizuko;
//import com.nali.list.render.RenderSSShizuko;
//import com.nali.small.entity.EntityLe;
//import com.nali.small.entity.IMixE;
//import com.nali.small.entity.IMixES;
//import com.nali.small.entity.IMixESInv;
//import com.nali.small.entity.memo.client.ClientLe;
//import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
//import com.nali.small.entity.memo.client.ci.MixCIE;
//import com.nali.small.entity.memo.client.render.mix.MixRenderSle;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//@SideOnly(Side.CLIENT)
//public class MixRenderSSShizuko
//<
//	BD extends BothDaSSShizuko,
//	R extends RenderSSShizuko<E, I, MC, MB, ?, C, BD, R>,
//	E extends EntityLe,
//	I extends IMixE<BD, E> & IMixES & IMixESInv,
//	MC extends MixCIE<BD, R, E, I, MB, ?, C>,
//	MB extends MixBoxSle<BD, R, E, I, MC, ?, C>,
//	C extends ClientLe<BD, R, E, I, MC, MB, ?>
//> extends MixRenderSle<BD, R, E, I, MC, MB, C>
//{
//	public MixRenderSSShizuko(C c)
//	{
//		super(c);
//		this.shadow_opaque = 0.5F;
//		this.shadow_size = 0.25F;
//	}
//
////	@Override
////	public void doRender(FRenderE<E> rendere, double ox, double oy, double oz, float partialTicks)
////	{
////		super.doRender(rendere, ox, oy, oz, partialTicks);
////		GL11.glPushMatrix();
////		GL11.glTranslated(ox, oy, oz);
////		R r = this.c.r;
////		float s = r.scale;
////		GL11.glScaled(s, s, s);
////		GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
////		r.seahouserender.draw(BothDaSeaHouse.IDA/*ox, oy, oz*/);
////		GL11.glPopMatrix();
////	}
//}
