package com.nali.summer.entity.memo.client.ibuki;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderIbuki;
import com.nali.small.entity.EntityRefSound;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.summer.entity.sound.SoundIbuki;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientIbuki
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderIbuki<IE, E, I, MC, MB, MR, ?, BD, RC>,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E>,
	MC extends MixCIE<RC, R, BD, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<RC, R, BD, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, RC, R, BD, E, I, MC, MB, ?>
> extends ClientLeInv<IE, RC, R, BD, E, I, MC, MB, MR> implements IClientERsInv, IClientESound
{
	public static int[] IV_INT_ARRAY = new int[]
	{
		9+115 + MODEL_STEP, 2882,
		9+115 + MODEL_STEP, 5893,
		4+115 + MODEL_STEP, 290,
		9+115 + MODEL_STEP, 969,
		9+115 + MODEL_STEP, 624,
		14+115 + MODEL_STEP, 38
	};
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		180.0F, -135.0F,
		-180.0F, -135.0F
	};
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.55F * 0.5F, 0.0F,
		0.0F, -1.0F * 0.5F, 0.09F * 0.5F,
		0.025F * 0.5F, -1.1F * 0.5F, 0.11F * 0.5F,
		0.025F * 0.5F, -1.05F * 0.5F, 0.11F * 0.5F
	};

	public SoundIbuki soundibuki = new SoundIbuki();

	public ClientIbuki(I i, R r)
	{
		super(i, r);
	}

	public ClientIbuki(R r)
	{
		super(r);
	}

	@Override
	public SoundIbuki getSound()
	{
		return this.soundibuki;
	}

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
	public void getHurtSound(DamageSource damagesource)
	{
		this.getSound().play(this.getSound().getSoundBuffer(EntityRefSound.HURT));
	}

	@Override
	public void getDeathSound()
	{
		this.getSound().play(this.getSound().getSoundBuffer(EntityRefSound.DEATH));
	}
}
