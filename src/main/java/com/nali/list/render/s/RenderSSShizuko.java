package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaSSShizuko;
import com.nali.summer.da.both.BothDaSeaHouse;
import com.nali.summer.da.client.ClientDaSSShizuko;
import com.nali.summer.render.SummerRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSSShizuko
<
	IE extends InvLe,
	E extends EntityLivingBase,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	MC extends MixCIE<RC, ?, BD, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<RC, ?, SD, BD, E, I, MC, MR, C>,
	MR extends MixRenderSe<RC, ?, BD, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, RC, ?, SD, BD, E, I, MC, MB, MR> & IClientERsInv,
	SD extends ISoundDaLe,
	BD extends IBothDaNe & IBothDaSn,
	RC extends IClientDaS
> extends SummerRenderSe<E, I, MC, MB, MR, C, BD, RC>
{
//	public static int ID;
//	public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//	public static BothData BOTHDATA = SummerSSZuko.BOTHDATA;
	public static IClientDaS ICLIENTDAS = new ClientDaSSShizuko();
	public static IBothDaSn IBOTHDASN = BothDaSSShizuko.IBOTHDASN;
	public RenderSeaHouse seahouserender;
//	public byte[] model_byte_array;

	public RenderSSShizuko(RC rc, BD bd)
	{
		super(rc, bd);
//		this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 25;
//		this.texture_index_int_array[1] = 26;
//		this.texture_index_int_array[2] = 27;
//		this.texture_index_int_array[3] = 27;
//		this.texture_index_int_array[4] = 28;
//		this.texture_index_int_array[5] = 29;
//		this.texture_index_int_array[6] = 30;
//		this.texture_index_int_array[7] = 32;
//		this.texture_index_int_array[8] = 9;
//		this.texture_index_int_array[9] = 32;
//		this.texture_index_int_array[10] = 32;
//		this.texture_index_int_array[11] = 31;
		this.seahouserender = new RenderSeaHouse(RenderSeaHouse.ICLIENTDAS, BothDaSeaHouse.IBOTHDASN);
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
//		super.setGlow();
//	}

	@Override
	public void updateLightCoord()
	{
		super.updateLightCoord();
		this.seahouserender.lig_b = this.lig_b;
		this.seahouserender.lig_s = this.lig_s;
	}

	@Override
	public void initSkinning(/*MemoAnimation memoanimation*/)
	{
		super.initSkinning(/*memoanimation*/);
//		this.seahouserender.initSkinning((OpenGLAnimationMemory)this.dataloader.object_array[((SkinningClientData)this.seahouserender.clientdata).FrameID()]);
		this.seahouserender.initSkinning(/*this.rst.memoanimation_list.get(this.seahouserender.rc.FrameID())*/);
	}

	@Override
	public void setSkinning(/*MemoAnimation memoanimation*/)
	{
		super.setSkinning(/*memoanimation*/);
//		this.seahouserender.setSkinning((OpenGLAnimationMemory)this.dataloader.object_array[((SkinningClientData)this.seahouserender.clientdata).FrameID()]);
		this.seahouserender.setSkinning(/*this.rst.memoanimation_list.get(this.seahouserender.rc.FrameID())*/);
	}

//	@Override
//	public void draw(int index)
//	{
//		if ((this.model_byte_array[index / 8] >> index % 8 & 1) == 1)
//		{
//			super.draw(index);
//		}
//	}
}
