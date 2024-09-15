package com.nali.summer.entity.memo.client.ssshizuko;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderSSShizuko;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.sound.ISoundDaLe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class MixCISSShizuko
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderSSShizuko<IE, E, I, ?, MB, MR, C, SD, BD, RC>,
	SD extends ISoundDaLe,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	MB extends MixBoxSleInv<RC, R, SD, BD, E, I, ?, MR, C>,
	MR extends MixRenderSSShizuko<IE, RC, R, SD, BD, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, RC, R, SD, BD, E, I, ?, MB, MR> & IClientERsInv
> extends MixCIE<RC, R, BD, E, I, MB, MR, C>
{
	public MixCISSShizuko(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		super.updateBox();

		R r = this.c.r;
		I i = this.c.i;

		int frame = r.frame_int_array[0];

		if (frame > 481 && frame < 533)
		{
			Arrays.fill(r.seahouserender.model_byte_array, (byte)255);
		}
		else if (frame > 532 && frame < 751)
		{
			r.seahouserender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
//			sszukorender.seahouserender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
//			sszukorender.seahouserender.model_byte_array[2 / 8] &= 251;//255 - Math.pow(2, 2 % 8)
			r.seahouserender.model_byte_array[0] &= 253 & 251;
		}
		else
		{
			Arrays.fill(r.seahouserender.model_byte_array, (byte)0);
		}

		r.seahouserender.frame_int_array[0] = i.getE().getDataManager().get(i.getIntegerDataParameterArray()[1]);
	}

	@Override
	public void onReadNBT()
	{
		Arrays.fill(this.c.r.seahouserender.model_byte_array, (byte)0);
		super.onReadNBT();
	}
}
