package com.nali.summer.entity.memo.client.ssizuna;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderSSIzuna;
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
public class ClientSSIzuna<RC extends IClientDaS, R extends RenderSSIzuna<E, I, MB, MR, ?, SD, BD, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixE<SD, BD, E>, MB extends MixBoxSle<RC, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RC, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RC, R, SD, BD, E, I, MB, MR>
{
	public static int[] IV_INT_ARRAY = new int[]
	{
		4+49 + MODEL_STEP, 7108,
		4+49 + MODEL_STEP, 11754,
		/*0+*/49 + MODEL_STEP, 1805,
		4+49 + MODEL_STEP, 12755,
		4+49 + MODEL_STEP, 3359,
		7+49 + MODEL_STEP, 69
	};
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.55F * 0.5F, 0.0F,
		0.0F, -1.0F * 0.5F, 0.0F,
		0.0F, -1.2F * 0.5F, 0.14F * 0.5F,
		0.0F, -1.15F * 0.5F, 0.14F * 0.5F
	};

	public ClientSSIzuna(I i, R r, Inventory inventory)
	{
		super(i, r, inventory);
	}

	@Override
	public void updateClient()
	{
		int frame = this.r.frame_int_array[0];

		if (frame < 264 || (frame > 562 && frame < 612))
		{
			this.r.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
		}
		else
		{
			this.r.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
		}

		float scale = this.r.scale;
		BD bd = this.i.getBD();
		E e = this.i.getE();
		if (frame > 314 && frame < 351)
		{
			e.width = bd.Width() * scale;
			e.height = 0.65F * scale;
		}
		else if (frame > 263 && frame < 315)
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

//	@Override
//	public void initFakeFrame()
//	{
//
//	}

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
