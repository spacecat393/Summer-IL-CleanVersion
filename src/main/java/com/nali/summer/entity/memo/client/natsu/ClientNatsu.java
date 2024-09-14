package com.nali.summer.entity.memo.client.natsu;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderNatsu;
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
public class ClientNatsu<RC extends IClientDaS, R extends RenderNatsu<E, I, MB, MR, ?, SD, BD, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixE<SD, BD, E>, MB extends MixBoxSle<RC, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RC, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RC, R, SD, BD, E, I, MB, MR>
{
	public static int[] IV_INT_ARRAY = new int[]
	{
		7+13 + MODEL_STEP, 3319,
		7+13 + MODEL_STEP, 5470,
		4+13 + MODEL_STEP, 7013,
		7+13 + MODEL_STEP, 1454,
		7+13 + MODEL_STEP, 1690,
		11+13 + MODEL_STEP, 45
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
		0.0F, -1.2F * 0.5F, 0.11F * 0.5F,
		0.0F, -1.15F * 0.5F, 0.11F * 0.5F
	};

	public ClientNatsu(I i, R r, Inventory inventory)
	{
		super(i, r, inventory);
	}

	@Override
	public void updateClient()
	{
		int frame = this.r.frame_int_array[0];

		if (frame > 255)
		{
			this.r.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
			this.r.model_byte_array[10 / 8] |= 4;//Math.pow(2, 10 % 8)
		}
		else
		{
			this.r.model_byte_array[0 / 8] &= 254;//255 - Math.pow(2, 0 % 8)
			this.r.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
		}

		this.r.model_byte_array[8 / 8] = (byte)((frame > 313 && frame < 338) || (frame > 341 && frame < 383) || (frame > 827 && frame < 850)
			? this.r.model_byte_array[8 / 8] | 1//Math.pow(2, 8 % 8)
			: this.r.model_byte_array[8 / 8] & 254);//255 - Math.pow(2, 8 % 8)
		this.r.model_byte_array[9 / 8] = (byte)((frame > -1 && frame < 226) || (frame > 306 && frame < 388) || (frame > 868 && frame < 1029)
			? this.r.model_byte_array[9 / 8] | 2//Math.pow(2, 9 % 8)
			: this.r.model_byte_array[9 / 8] & 253);//255 - Math.pow(2, 9 % 8)

		float scale = this.r.scale;
		E e = this.i.getE();
		if (frame > 765 && frame < 823)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			BD bd = this.i.getBD();
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
