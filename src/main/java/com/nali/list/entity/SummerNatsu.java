package com.nali.list.entity;

import com.nali.da.IBothDaE;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.entity.si.*;
import com.nali.list.render.RenderNatsu;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.EntityMath;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.IBothLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.list.da.BothDaNatsu;
import com.nali.sound.SoundE;
import com.nali.summer.entity.memo.client.natsu.ClientNatsu;
import com.nali.summer.entity.memo.client.natsu.MixCINatsu;
import com.nali.summer.entity.memo.client.natsu.MixRenderNatsu;
import com.nali.summer.entity.memo.server.natsu.MixSINatsu;
import com.nali.summer.entity.memo.server.natsu.ServerNatsu;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

public class SummerNatsu extends EntityLeInv implements IMixES, IMixESInv
{
	public static int eggPrimary = 0xF1F6F9;
	public static int eggSecondary = 0xFB7290;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaNatsu.IDA.E_MaxSync()];
	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaNatsu.IDA.S_MaxFrame()];
	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	public static byte[] CI_BYTE_ARRAY;
	public static byte[] SI_BYTE_ARRAY;

	public IBothLeInv ibothleinv;

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

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerNatsu.class, DataSerializers.BYTE);
		}

		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
		{
			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerNatsu.class, DataSerializers.VARINT);
		}

		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
		{
			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerNatsu.class, DataSerializers.FLOAT);
		}
	}

	public SummerNatsu(World world)
	{
		super(world);
	}

	public static void initID()
	{
		CI_BYTE_ARRAY = new byte[]
		{
			CIEFrame.ID,
			CIESound.ID
		};

		SI_BYTE_ARRAY = new byte[]
		{
			SIESound.ID,

			SIEArea.ID,
			SIEOwner.ID,
			SILeEat.ID,

			SIEPat.ID,

			SIEInvLockInv.ID,
			SILeLockDMG.ID,
			SILeMineTo.ID,
			SILeUseTo.ID,
			SIESit.ID,
			SILeSetLocation.ID,
			SILeFollow.ID,
			SILeRevive.ID,
			SILeHeal.ID,
			SILeCareOwner.ID,
			SILeAttack.ID,
			SILeInvManageItem.ID,
			SILeInvGetItem.ID,
			SILeRandomWalk.ID,
			SILeLookTo.ID,
			SILeRandomLook.ID,

			SIEFrame.ID,

			SILeFindMove.ID,
			SILeMove.ID,
			SILeWalkTo.ID,
			SIELook.ID,
			SILeJump.ID
		};
	}

	@SideOnly(Side.CLIENT)
	public static ClientNatsu getC()
	{
		RenderNatsu r = new RenderNatsu();
		ClientNatsu c = new ClientNatsu(r);
		r.c = c;
		c.mr = new MixRenderNatsu(c);
		return c;
	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
	}

	@Override
	public byte[] getCI()
	{
		return CI_BYTE_ARRAY;
	}

	@Override
	public byte[] getSI()
	{
		return SI_BYTE_ARRAY;
	}

	@Override
	public DataParameter<Byte>[] getByteDataParameterArray()
	{
		return BYTE_DATAPARAMETER_ARRAY;
	}

	@Override
	public DataParameter<Integer>[] getIntegerDataParameterArray()
	{
		return INTEGER_DATAPARAMETER_ARRAY;
	}

	@Override
	public DataParameter<Float>[] getFloatDataParameterArray()
	{
		return FLOAT_DATAPARAMETER_ARRAY;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void newC()
	{
		RenderNatsu r = new RenderNatsu();
		ClientNatsu c = new ClientNatsu(this, r, new SoundE());
		MixCINatsu mc = new MixCINatsu(c);
		c.mc = mc;
		mc.init();
		c.mb = new MixBoxSleInv(c);
		c.mr = new MixRenderNatsu(c);
		r.c = c;
		c.ie = new InvLe();
		this.ibothleinv = c;
	}

	@Override
	public void newS()
	{
		ServerNatsu s = new ServerNatsu(this);
		MixSINatsu ms = new MixSINatsu(s);
		s.ms = ms;
		ms.init();
		s.initFrame();
		s.ie = new InvLe();
		this.ibothleinv = s;
	}

	@Override
	public IBothDaE getBD()
	{
		return BothDaNatsu.IDA;
	}

	@Override
	public IBothLeInv getB()
	{
		return this.ibothleinv;
	}
//	@Override
//	@SideOnly(Side.CLIENT)
//	public Object createObjectRender()
//	{
//		return new NasuRender(new EntitiesRenderMemory(), this);
//	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public Object createSoundRender()
//	{
////		return SoundRender.getSoundRender(DATALOADER);
//		return new NoSoundRender();
//	}
//
//	@Override
//	@SideOnly(Side.CLIENT)
//	public int[] getIVIntArray()
//	{
//		return ClientNasuMemory.IV_INT_ARRAY;
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
	public void mulFrame(float[] skinning_float_array, int[] frame_int_array, float partial_ticks)
	{
		float head_rot = (float)Math.toRadians(EntityMath.interpolateRotation(this.prevRotationYawHead, this.rotationYawHead, partial_ticks));
		float head_pitch = (float)Math.toRadians(this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * partial_ticks);
		float body_rot = (float)Math.toRadians(EntityMath.interpolateRotation(this.prevRotationYaw, this.rotationYaw, partial_ticks));
		float net_head_yaw = head_rot - body_rot;

		if (head_pitch > 1.04719755119659774615F)
		{
			head_pitch = 1.04719755119659774615F;
		}
		else if (head_pitch < -1.04719755119659774615F)
		{
			head_pitch = -1.04719755119659774615F;
		}

		M4x4 body_m4x4 = new Quaternion(0.0F, 0.0F, body_rot).getM4x4();
		M4x4 head_m4x4 = new Quaternion(-head_pitch, 0, net_head_yaw).getM4x4();

		head_m4x4.multiply(skinning_float_array, 24 * 16);

		body_m4x4.multiply(skinning_float_array, 0);
	}
}
