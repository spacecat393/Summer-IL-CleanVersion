package com.nali.summer.entity.memo.client.ssshizuko;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderSSShizuko;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.ClientSleInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import com.nali.sound.NoSound;
import com.nali.sound.Sound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

import static com.nali.list.data.SummerData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientSSShizuko<RC extends IClientDaS, R extends RenderSSShizuko<E, I, MB, MR, ?, SD, BD, RC>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RC, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RC, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RC, R, SD, BD, E, I, MB, MR>
{
	public static int[] IV_INT_ARRAY = new int[]
	{
		4+37 + MODEL_STEP, 8643,
		4+37 + MODEL_STEP, 1426,
		/*0+*/37 + MODEL_STEP, 1374,
		4+37 + MODEL_STEP, 1726,
		4+37 + MODEL_STEP, 2838,
		8+37 + MODEL_STEP, 45
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

	public ClientSSShizuko(I i, R r, Inventory inventory)
	{
		super(i, r, inventory);
	}

	@Override
	public void updateClient()
	{
		int frame = this.r.frame_int_array[0];

		if (frame > 481 && frame < 533)
		{
			Arrays.fill(this.r.seahouserender.model_byte_array, (byte)255);
		}
		else if (frame > 532 && frame < 751)
		{
			this.r.seahouserender.model_byte_array[0 / 8] |= 1;//Math.pow(2, 0 % 8)
//			sszukorender.seahouserender.model_byte_array[1 / 8] &= 253;//255 - Math.pow(2, 1 % 8)
//			sszukorender.seahouserender.model_byte_array[2 / 8] &= 251;//255 - Math.pow(2, 2 % 8)
			this.r.seahouserender.model_byte_array[0] &= 253 & 251;
		}
		else
		{
			Arrays.fill(this.r.seahouserender.model_byte_array, (byte)0);
		}

		super.updateClient();
	}

	@Override
	public void updateClientObject()//?
	{
		super.updateClientObject();
		DataParameter<Integer>[] integer_dataparameter = this.i.getIntegerDataParameterArray();

		EntityDataManager entitydatamanager = this.i.getE().getDataManager();
		this.r.frame_int_array[0] = entitydatamanager.get(integer_dataparameter[0]);
		this.r.seahouserender.frame_int_array[0] = entitydatamanager.get(integer_dataparameter[1]);
	}

	@Override
	public void initFakeFrame()
	{
		Arrays.fill(this.r.seahouserender.model_byte_array, (byte)0);
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
