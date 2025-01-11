package com.nali.summer.entity.memo.client.sshifumi;

import com.nali.list.da.BothDaSSHifumi;
import com.nali.list.render.RenderSSHifumi;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.render.IRenderS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixCISSHifumi
<
	IE extends InvLe,
	R extends RenderSSHifumi<IE, E, I, ?, MB, MR, C> & IRenderS<BothDaSSHifumi, R>,
	E extends EntityLe,
	I extends IMixE<BothDaSSHifumi, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaSSHifumi, R, E, I, ?, MR, C>,
	MR extends MixRenderSSHifumi<IE, BothDaSSHifumi, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaSSHifumi, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaSSHifumi, R, E, I, MB, MR, C>
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

		short key = r.key_short_array[0];
		float scale = r.scale;

		if (key > 465 && key < 482)
		{
//			this.width = bothdata.E_Width() * scale;
//			this.height = bothdata.E_Height() * scale;
			r.model_byte_array[0] &= 255-1 & 255-2 & 255-4 & 255-8 & 255-16/* & 255-32*/ & 255-64;
			r.model_byte_array[1] &= 255-8 & 255-16;
		}
		else
		{
//			this.width = bothdata.E_Width() * scale;
//			this.height = bothdata.E_Height() * scale;
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
		if (key < 575)
		{
			e.width = 4.0F * scale;
			e.height = 2.5F * scale;
//			skinningrender.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
//			skinningrender.model_byte_array[9 / 8] |= 2;//Math.pow(2, 9 % 8)
//			skinningrender.model_byte_array[10 / 8] |= 4;//Math.pow(2, 10 % 8)
			r.model_byte_array[0] |= 128;
			r.model_byte_array[1] |= 1 | 2 | 4;
		}
		else
		{
			e.width = BothDaSSHifumi.IDA.E_Width() * scale;
			e.height = BothDaSSHifumi.IDA.E_Height() * scale;
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
		this.c.r.key_short_array[0] = 371;
		super.onReadNBT();
	}
}
