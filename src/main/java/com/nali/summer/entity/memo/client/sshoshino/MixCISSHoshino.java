package com.nali.summer.entity.memo.client.sshoshino;

import com.nali.list.da.BothDaSSHoshino;
import com.nali.list.render.RenderSSHoshino;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixCISSHoshino
<
	IE extends InvLe,
	R extends RenderSSHoshino<IE, E, I, ?, MB, MR, C>,
	E extends EntityLivingBase,
	I extends IMixE<BothDaSSHoshino, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaSSHoshino, R, E, I, ?, MR, C>,
	MR extends MixRenderSSHoshino<IE, BothDaSSHoshino, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaSSHoshino, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaSSHoshino, R, E, I, MB, MR, C>
{
	public MixCISSHoshino(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		R r = this.c.r;
		I i = this.c.i;

		int frame = r.frame_int_array[0];

		if (frame < 409)
		{
//			skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
			r.model_byte_array[0] &= 239 & 223;
			r.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
		}
		else
		{
//			skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
			r.model_byte_array[0] |= 16 | 32;
			r.model_byte_array[11 / 8] |= 8;//Math.pow(2, 11 % 8)
		}

		float scale = r.scale;
		E e = i.getE();
		if (frame > 408 && frame < 507)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = BothDaSSHoshino.IDA.E_Width() * scale;
			e.height = BothDaSSHoshino.IDA.E_Height() * scale;
		}

		r.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
	}
}