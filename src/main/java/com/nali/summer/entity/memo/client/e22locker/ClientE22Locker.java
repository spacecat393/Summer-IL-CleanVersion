//package com.nali.summer.entity.memo.client.e22locker;
//
//import com.nali.da.IBothDaE;
//import com.nali.da.IBothDaO;
//import com.nali.da.IBothDaS;
//import com.nali.render.RenderS;
//import com.nali.small.entity.EntityE;
//import com.nali.small.entity.IMixE;
//import com.nali.small.entity.IMixES;
//import com.nali.small.entity.memo.client.ClientE;
//import com.nali.small.entity.memo.client.box.mix.MixBoxE;
//import com.nali.small.entity.memo.client.ci.MixCIE;
//import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
//import com.nali.small.render.IRenderS;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//@SideOnly(Side.CLIENT)
//public class ClientE22Locker
//<
//	R extends RenderS<BD> & IRenderS<BD, R>,
//	BD extends IBothDaE & IBothDaO & IBothDaS,
//	E extends EntityE,
//	I extends IMixE<BD, E> & IMixES,
//	MC extends MixCIE<BD, R, E, I, MB, MR, ?>,
//	MB extends MixBoxE<BD, R, E, I, MC, MR, ?>,
//	MR extends MixRenderSe<BD, R, E, I, MC, MB, ?>
//> extends ClientE<BD, R, E, I, MC, MB, MR>
//{
//	public ClientE22Locker(I i, R r)
//	{
//		super(i, r);
//	}
//
//	public ClientE22Locker(R r)
//	{
//		super(r);
//	}
////	@Override
////	public void initFakeFrame()
////	{
////
////	}
//
////	@Override
////	public Sound createSound()
////	{
////		return null;
////	}
//
////	@Override
////	public void updateClient()
////	{
////		super.updateClient();
////
////		E e = this.i.getE();
////		e.rotationYawHead = e.rotationYaw;
////		e.prevRotationYawHead = e.rotationYaw;
////		e.renderYawOffset = e.rotationYaw;
////	}
//}
