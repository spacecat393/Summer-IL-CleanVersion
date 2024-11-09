package com.nali.summer.entity.memo.client.sshifumi;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderSSHifumi;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixCISSHifumi
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderSSHifumi<IE, E, I, ?, MB, MR, C, BD, RC>,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E>,
	MB extends MixBoxSleInv<RC, R, BD, E, I, ?, MR, C>,
	MR extends MixRenderSSHifumi<IE, RC, R, BD, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, RC, R, BD, E, I, ?, MB, MR> & IClientERsInv
> extends MixCIE<RC, R, BD, E, I, MB, MR, C>
{
	public MixCISSHifumi(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		R r = this.c.r;
		I i = this.c.i;

		int frame = r.frame_int_array[0];
		float scale = r.scale;

		if (frame > 267 && frame < 284)
		{
//			this.width = bothdata.Width() * scale;
//			this.height = bothdata.Height() * scale;
			r.model_byte_array[0] &= 255-1 & 255-2 & 255-4 & 255-8 & 255-16/* & 255-32*/ & 255-64;
			r.model_byte_array[1] &= 255-8 & 255-16;
		}
		else
		{
//			this.width = bothdata.Width() * scale;
//			this.height = bothdata.Height() * scale;
//			skinningrender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
//			skinningrender.model_byte_array[1 / 8] |= 2;//Math.pow(2, 1 % 8)
//			skinningrender.model_byte_array[2 / 8] |= 4;//Math.pow(2, 2 % 8)
//			skinningrender.model_byte_array[3 / 8] |= 8;//Math.pow(2, 3 % 8)
//			skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
			r.model_byte_array[0] |= 1 | 2 | 4 | 8 | 16/* | 32*/ | 64;
//			skinningrender.model_byte_array[11 / 8] |= 8;//Math.pow(2, 11 % 8)
//			skinningrender.model_byte_array[12 / 8] |= 16;//Math.pow(2, 12 % 8)
			r.model_byte_array[1] |= 8 | 16;
		}

		E e = i.getE();
		if (frame < 379 || (frame > 590 && frame < 642))
		{
			e.width = 1.7F * scale;
			e.height = 1.5F * scale;
//			skinningrender.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
//			skinningrender.model_byte_array[9 / 8] |= 2;//Math.pow(2, 9 % 8)
//			skinningrender.model_byte_array[10 / 8] |= 4;//Math.pow(2, 10 % 8)
			r.model_byte_array[0] |= 128;
			r.model_byte_array[1] |= 1 | 2 | 4;
		}
		else
		{
			BD bd = i.getBD();
			e.width = bd.Width() * scale;
			e.height = bd.Height() * scale;
//			skinningrender.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
//			skinningrender.model_byte_array[9 / 8] &= 253;//255 - Math.pow(2, 9 % 8)
//			skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
			r.model_byte_array[0] &= 255-128;
			r.model_byte_array[1] &= 255-1 & 255-2 & 255-4;
		}

//		skinningrender.model_byte_array[5 / 8] &= 255-32;//255 - Math.pow(2, 5 % 8)
	}

	@Override
	public void onReadNBT()
	{
		this.c.r.frame_int_array[0] = 379;
		super.onReadNBT();
	}
}
