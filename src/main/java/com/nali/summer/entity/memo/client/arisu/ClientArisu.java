package com.nali.summer.entity.memo.client.arisu;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.render.s.RenderArisu;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import com.nali.sound.NoSound;
import com.nali.sound.Sound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientArisu
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderArisu<IE, E, I, MC, MB, MR, ?, SD, BD, RC>,
	SD extends ISoundDaLe,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	MC extends MixCIE<RC, R, BD, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<RC, R, SD, BD, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, RC, R, SD, BD, E, I, MC, MB, ?>
> extends ClientLeInv<IE, RC, R, SD, BD, E, I, MC, MB, MR> implements IClientERsInv, IClientESound
{
	public Sound sound = new NoSound();

	public static byte[] CI_BYTE_ARRAY =
	{
		CIEFrame.ID,
		CIESound.ID
	};

//	@SideOnly(Side.CLIENT)
	public static int[] IV_INT_ARRAY = new int[]
	{
		5+25 + MODEL_STEP, 8547,
		5+25 + MODEL_STEP, 9270,
		/*0+*/25 + MODEL_STEP, 2078,
		5+25 + MODEL_STEP, 268,
		5+25 + MODEL_STEP, 519,
		8+25 + MODEL_STEP, 39
	};
//	@SideOnly(Side.CLIENT)
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
//	@SideOnly(Side.CLIENT)
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.55F * 0.5F, 0.0F,
		0.0F, -1.0F * 0.5F, 0.05F * 0.5F,
		0.0F, -1.1F * 0.5F, 0.12F * 0.5F,
		0.0F, -1.05F * 0.5F, 0.12F * 0.5F
	};

	public ClientArisu(I i, R r)
	{
		super(i, r);
	}

//	@Override
//	public void initFakeFrame()
//	{
////		int max_bones = this.r.rst.memoanimation_list.get(this.r.rc.FrameID()).bones;
////
////		float[] f = new float[]
////		{
////			-1, 0, 0, 0,
////			0, -1, 0, 0,
////			0, 0, -1, 0,
////			0, 0, 0, 1
////		};
////		System.arraycopy(f, 0, this.r.skinning_float_array, 0, 16);
////		for (int i = 0; i < max_bones; ++i)
////		{
////			System.arraycopy(M4x4.IDENTITY, 0, this.r.skinning_float_array, i * 16, 16);
////		}
////		this.r.initSkinning();
////		this.r.setSkinning();
////		this.mr.updateSkinning();
////		super.initFakeFrame();
//	}

	@Override
	public Sound getSound()
	{
		return sound;
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
	public byte[] getCI()
	{
		return CI_BYTE_ARRAY;
	}
}
