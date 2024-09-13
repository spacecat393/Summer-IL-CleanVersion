package com.nali.summer.entity.memo.client.sshifumi;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderSSHifumi;
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
public class ClientSSHifumi<RC extends IClientDaS, R extends RenderSSHifumi<E, I, MB, MR, ?, SD, BD, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RC, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RC, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RC, R, SD, BD, E, I, MB, MR>
{
	public static int[] IV_INT_ARRAY = new int[]
	{
		/*0+0 + */MODEL_STEP, 9046,
		/*0+0 + */MODEL_STEP, 2581,
		4/*+0*/ + MODEL_STEP, 1275,
		/*0+0 + */MODEL_STEP, 9224,
		/*0+0 + */MODEL_STEP, 7860,
		12/*+0*/ + MODEL_STEP, 69
	};
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.55F * 0.5F, 0.0F,
		0.0F, -1.0F * 0.5F, 0.01F * 0.5F,
		0.0F, -1.2F * 0.5F, 0.14F * 0.5F,
		0.0F, -1.15F * 0.5F, 0.14F * 0.5F
	};

	public ClientSSHifumi(I i, R r, Inventory inventory)
	{
		super(i, r, inventory);
	}

	@Override
	public void updateClient()
	{
		int frame = this.r.frame_int_array[0];
		float scale = this.r.scale;

		if (frame > 267 && frame < 284)
		{
//			this.width = bothdata.Width() * scale;
//			this.height = bothdata.Height() * scale;
			this.r.model_byte_array[0] &= 255-1 & 255-2 & 255-4 & 255-8 & 255-16/* & 255-32*/ & 255-64;
			this.r.model_byte_array[1] &= 255-8 & 255-16;
		}
		else
		{
//			this.width = bothdata.Width() * scale;
//			this.height = bothdata.Height() * scale;
//			skinningrender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
//			skinningrender.model_byte_array[1 / 8] |= 2;//Math.pow(2, 1 % 8)
//			skinningrender.model_byte_array[2 / 8] |= 4;//Math.pow(2, 2 % 8)
//			skinningrender.model_byte_array[3 / 8] |= 8;//Math.pow(2, 3 % 8)
//			skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
//			skinningrender.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
			this.r.model_byte_array[0] |= 1 | 2 | 4 | 8 | 16/* | 32*/ | 64;
//			skinningrender.model_byte_array[11 / 8] |= 8;//Math.pow(2, 11 % 8)
//			skinningrender.model_byte_array[12 / 8] |= 16;//Math.pow(2, 12 % 8)
			this.r.model_byte_array[1] |= 8 | 16;
		}

		E e = this.i.getE();
		if (frame < 379 || (frame > 590 && frame < 642))
		{
			e.width = 1.7F * scale;
			e.height = 1.5F * scale;
//			skinningrender.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
//			skinningrender.model_byte_array[9 / 8] |= 2;//Math.pow(2, 9 % 8)
//			skinningrender.model_byte_array[10 / 8] |= 4;//Math.pow(2, 10 % 8)
			this.r.model_byte_array[0] |= 128;
			this.r.model_byte_array[1] |= 1 | 2 | 4;
		}
		else
		{
			BD bd = this.i.getBD();
			e.width = bd.Width() * scale;
			e.height = bd.Height() * scale;
//			skinningrender.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
//			skinningrender.model_byte_array[9 / 8] &= 253;//255 - Math.pow(2, 9 % 8)
//			skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
			this.r.model_byte_array[0] &= 255-128;
			this.r.model_byte_array[1] &= 255-1 & 255-2 & 255-4;
		}

//		skinningrender.model_byte_array[5 / 8] &= 255-32;//255 - Math.pow(2, 5 % 8)
	}

	@Override
	public void initFakeFrame()
	{
		this.r.frame_int_array[0] = 379;
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
