//package com.nali.summer.entity.memo.client.ssshizuko;
//
//import com.nali.list.da.BothDaSSShizuko;
//import com.nali.list.render.RenderSSShizuko;
//import com.nali.small.entity.EntityLe;
//import com.nali.small.entity.IMixE;
//import com.nali.small.entity.IMixES;
//import com.nali.small.entity.IMixESInv;
//import com.nali.small.entity.inv.InvLe;
//import com.nali.small.entity.memo.client.ClientLeInv;
//import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
//import com.nali.small.entity.memo.client.ci.MixCIE;
//import com.nali.system.bytes.ByteReader;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//import java.util.Arrays;
//
//@SideOnly(Side.CLIENT)
//public class MixCISSShizuko
//<
//	IE extends InvLe,
//	R extends RenderSSShizuko<E, I, ?, MB, MR, C>,
//	E extends EntityLe,
//	I extends IMixE<BothDaSSShizuko, E> & IMixES & IMixESInv,
//	MB extends MixBoxSle<BothDaSSShizuko, R, E, I, ?, MR, C>,
//	MR extends MixRenderSSShizuko<IE, R, E, I, ?, MB, C>,
//	C extends ClientLeInv<IE, BothDaSSShizuko, R, E, I, ?, MB, MR>
//> extends MixCIE<BothDaSSShizuko, R, E, I, MB, MR, C>
//{
//	public MixCISSShizuko(C c)
//	{
//		super(c);
//	}
//
////	@Override
////	public void updateBox()
////	{
////		super.updateBox();
////
////		R r = this.c.r;
//////		I i = this.c.i;
////
////		short key = r.key_short_array[0];
////
////		if (key > 481 && key < 533)
////		{
////			Arrays.fill(r.seahouserender.model_byte_array, (byte)255);
////		}
////		else if (key > 532 && key < 751)
////		{
////			r.seahouserender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
//////			sszukorender.seahouserender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
//////			sszukorender.seahouserender.model_byte_array[2 / 8] &= 251;//255 - Math.pow(2, 2 % 8)
////			r.seahouserender.model_byte_array[0] &= 253 & 251;
////		}
////		else
////		{
////			Arrays.fill(r.seahouserender.model_byte_array, (byte)0);
////		}
////
////		r.seahouserender.key_short_array[0] = ByteReader.getShort(this.c.sync_byte_array, this.c.i.getBD().Se_SyncIndex() + 1 * 2);
////	}
//
////	@Override
////	public void onReadNBT()
////	{
////		Arrays.fill(this.c.r.seahouserender.model_byte_array, (byte)0);
////		super.onReadNBT();
////	}
//}
