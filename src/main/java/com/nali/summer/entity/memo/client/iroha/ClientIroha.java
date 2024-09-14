package com.nali.summer.entity.memo.client.iroha;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderIroha;
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
public class ClientIroha<RC extends IClientDaS, R extends RenderIroha<E, I, MB, MR, ?, SD, BD, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixE<SD, BD, E>, MB extends MixBoxSle<RC, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RC, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RC, R, SD, BD, E, I, MB, MR>
{
	public static int[] IV_INT_ARRAY = new int[]
	{
		8+130 + MODEL_STEP, 837,
		8+130 + MODEL_STEP, 2145,
		8+130 + MODEL_STEP, 10171,
		8+130 + MODEL_STEP, 6617,
		8+130 + MODEL_STEP, 5653,
		10+130 + MODEL_STEP, 39,
		5+130 + MODEL_STEP, 26084
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

	public ClientIroha(I i, R r, Inventory inventory)
	{
		super(i, r, inventory);
	}

	@Override
	public void updateClient()
	{
		int frame = this.r.frame_int_array[0];

		float scale = this.r.scale;
		E e = this.i.getE();
		if (frame > 257)
		{
			e.width = 1.7F * scale;
			e.height = 1.5F * scale;
//			skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[5 / 8] |= 32;//Math.pow(2, 5 % 8)
			this.r.model_byte_array[0] |= 16 | 32;
		}
		else
		{
			BD bd = this.i.getBD();
			e.width = bd.Width() * scale;
			e.height = bd.Height() * scale;
//			skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
			this.r.model_byte_array[0] &= 239 & 223;
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
