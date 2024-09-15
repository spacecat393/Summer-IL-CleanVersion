package com.nali.summer.entity.memo.client.e22locker;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.render.RenderS;
import com.nali.small.entity.EntityE;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvE;
import com.nali.small.entity.memo.IBothEInv;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientE22Locker
<
	IE extends InvE,
	RC extends IClientDaS,
	R extends RenderS<BD, RC>,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityE,
	I extends IMixE<BD, E>,
	MC extends MixCIE<RC, R, BD, E, I, MB, MR, ?>,
	MB extends MixBoxE<RC, R, BD, E, I, MC, MR, ?>,
	MR extends MixRenderSe<RC, R, BD, E, I, MC, MB, ?>
> extends ClientE<RC, R, BD, E, I, MC, MB, MR> implements IClientERsInv, IBothEInv<IE>
{
	public IE ie;

	public static byte[] CI_BYTE_ARRAY =
	{
		CIEFrame.ID
	};

	public static int[] IV_INT_ARRAY = new int[]
	{
		5+90 + MODEL_STEP, 523,
		5+90 + MODEL_STEP, 560,
		5+90 + MODEL_STEP, 12,
		5+90 + MODEL_STEP, 451,
		5+90 + MODEL_STEP, 451,
		4+90 + MODEL_STEP, 99
	};
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.65F * 0.5F, 0.0F,
		0.1F, -1.8F * 0.5F, 0.07F * 0.5F,
		0.1F, -1.85F * 0.5F, 0.09F * 0.5F,
		0.1F, -1.8F * 0.5F, 0.09F * 0.5F
	};

	public ClientE22Locker(I i, R r)
	{
		super(i, r);
	}

	@Override
	public byte[] getCI()
	{
		return CI_BYTE_ARRAY;
	}

//	@Override
//	public void initFakeFrame()
//	{
//
//	}

//	@Override
//	public Sound createSound()
//	{
//		return null;
//	}

	@Override
	public int[] getIVIntArray()
	{
		return IV_INT_ARRAY;
	}

	@Override
	public float[] getRotationFloatArray()
	{
		return ROTATION_FLOAT_ARRAY;
	}

	@Override
	public float[] getTransformFloatArray()
	{
		return TRANSFORM_FLOAT_ARRAY;
	}

	@Override
	public IE getIE()
	{
		return this.ie;
	}
//	@Override
//	public void updateClient()
//	{
//		super.updateClient();
//
//		E e = this.i.getE();
//		e.rotationYawHead = e.rotationYaw;
//		e.prevRotationYawHead = e.rotationYaw;
//		e.renderYawOffset = e.rotationYaw;
//	}
}
