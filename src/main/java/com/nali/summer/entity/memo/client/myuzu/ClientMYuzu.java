package com.nali.summer.entity.memo.client.myuzu;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderMYuzu;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.ClientSleInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import com.nali.sound.NoSound;
import com.nali.sound.Sound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientMYuzu<RC extends IClientDaS, R extends RenderMYuzu<E, I, MB, MR, ?, SD, BD, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RC, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RC, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RC, R, SD, BD, E, I, MB, MR>
{
	public static int[] IV_INT_ARRAY = new int[]
	{
		5+81 + MODEL_STEP, 11946,
		5+81 + MODEL_STEP, 10846,
		1+81 + MODEL_STEP, 557,
		5+81 + MODEL_STEP, 13404,
		5+81 + MODEL_STEP, 9960,
		8+81 + MODEL_STEP, 69
	};
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.55F * 0.5F, 0.0F,
		0.0F, -1.0F * 0.5F, 0.09F * 0.5F,
		0.0F, -1.1F * 0.5F, 0.11F * 0.5F,
		0.0F, -1.05F * 0.5F, 0.11F * 0.5F
	};

	public ClientMYuzu(I i, R r, Inventory inventory)
	{
		super(i, r, inventory);
	}

	@Override
	public void updateClient()
	{
		int frame = this.r.frame_int_array[0];

		float scale = this.r.scale;
		BD bd = this.i.getBD();
		E e = this.i.getE();
		if (frame < 513)
		{
			e.width = bd.Width() * scale;
			e.height = 0.65F * scale;
		}
		else if (/*frame > 512 && */frame < 564)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = bd.Width() * scale;
			e.height = bd.Height() * scale;
		}
	}

	@Override
	public void initFakeFrame()
	{
		this.r.frame_int_array[0] = 110;
		super.initFakeFrame();
	}

	@Override
	public Sound createSound()
	{
		return new NoSound();
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
}
