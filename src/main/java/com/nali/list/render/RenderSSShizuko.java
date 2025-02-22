package com.nali.list.render;

import com.nali.list.da.BothDaSSShizuko;
import com.nali.render.RenderS;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.client.ClientLe;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.IRenderS;
import com.nali.summer.render.SummerRenderSe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSSShizuko
<
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
	MB extends MixBoxSle<BD, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BD, ?, E, I, MC, MB, C>,
	C extends ClientLe<BD, ?, E, I, MC, MB, MR>,
	BD extends BothDaSSShizuko,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends SummerRenderSe<E, I, MC, MB, MR, C, BD, R>
{
	//seahouserender -> entity
//	public RenderSeaHouse seahouserender;
//	public byte[] model_byte_array;

	public RenderSSShizuko()
	{
		super((BD)BothDaSSShizuko.IDA);
//		this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.O_EndPart() - CLIENTDATA.O_StartPart()) / 8.0D)];
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
//		this.seahouserender = new RenderSeaHouse();
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[6 / 8] ^= 64;//Math.pow(2, 6 % 8)
//		super.setGlow();
//	}

//	@Override
//	public void updateLightCoord()
//	{
//		super.updateLightCoord();
//		this.seahouserender.lig_b = this.lig_b;
//		this.seahouserender.lig_s = this.lig_s;
//	}
//
//	@Override
//	public void initSkinning(BothDaSSShizuko bd/*MemoAnimation memoanimation*/)
//	{
//		super.initSkinning(bd/*memoanimation*/);
////		this.seahouserender.initSkinning((OpenGLAnimationMemory)this.dataloader.object_array[((SkinningClientData)this.seahouserender.clientdata).FrameID()]);
//		this.seahouserender.initSkinning(BothDaSeaHouse.IDA/*this.rst.memoanimation_list.get(this.seahouserender.rc.FrameID())*/);
//	}
//
//	@Override
//	public void setSkinning(BothDaSSShizuko bd/*MemoAnimation memoanimation*/)
//	{
//		super.setSkinning(bd/*memoanimation*/);
////		this.seahouserender.setSkinning((OpenGLAnimationMemory)this.dataloader.object_array[((SkinningClientData)this.seahouserender.clientdata).FrameID()]);
//		this.seahouserender.setSkinning(BothDaSeaHouse.IDA/*this.rst.memoanimation_list.get(this.seahouserender.rc.FrameID())*/);
//	}

//	@Override
//	public void draw(int index)
//	{
//		if ((this.model_byte_array[index / 8] >> index % 8 & 1) == 1)
//		{
//			super.draw(index);
//		}
//	}
}
