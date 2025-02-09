package com.nali.list.entity;

import com.nali.da.IBothDaE;
import com.nali.list.da.BothDaIbuki;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.entity.si.*;
import com.nali.list.render.RenderIbuki;
import com.nali.math.M4x4;
import com.nali.math.V4;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.EntityMath;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.IBothLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.server.si.SILeLook;
import com.nali.small.entity.memo.server.si.path.SILeFindMove;
import com.nali.small.entity.memo.server.si.path.SILeMineTo;
import com.nali.small.entity.memo.server.si.play.SILePlayWithSSle;
import com.nali.sound.SoundE;
import com.nali.summer.entity.memo.client.ibuki.ClientIbuki;
import com.nali.summer.entity.memo.client.ibuki.MixCIIbuki;
import com.nali.summer.entity.memo.client.ibuki.MixRenderIbuki;
import com.nali.summer.entity.memo.server.ibuki.MixSIIbuki;
import com.nali.summer.entity.memo.server.ibuki.ServerIbuki;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

public class SummerIbuki extends EntityLeInv implements IMixES, IMixESInv
{
	public static int eggPrimary = 0xfef5cb;
	public static int eggSecondary = 0xab6402;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaIbuki.IDA.E_MaxSync()];
//	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaIbuki.IDA.S_MaxFrame()/* + BothDaIroha.MAX_FRAME*/];
//	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1/*2*/];

	public static byte[] CI_BYTE_ARRAY;
	public static byte[] SI_BYTE_ARRAY;

	public IBothLeInv ibothleinv;

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

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIbuki.class, DataSerializers.BYTE);
		}

//		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIbuki.class, DataSerializers.VARINT);
//		}
//
//		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerIbuki.class, DataSerializers.FLOAT);
//		}
	}

	public SummerIbuki(World world)
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
			SIEUseTo.ID,
			SIESit.ID,
			SIESetLocation.ID,
			SIEFollow.ID,
			SIERevive.ID,
			SILePlayWithSSle.ID,//Play+1
			SIECareOwner.ID,
			SILeAttack.ID,
			SILeInvManageItem.ID,
			SIEInvGetItem.ID,
			SIERandomWalk.ID,
			SIELookTo.ID,
			SIERandomLook.ID,

			SIEKey.ID,

			SILeFindMove.ID,
			//SILeMove.ID,
			SIEWalkTo.ID,
			SILeLook.ID,
			//SILeJump.ID
		};
	}

//	@SideOnly(Side.CLIENT)
//	public static ClientIbuki getC()
//	{
//		RenderIbuki r = new RenderIbuki();
//		ClientIbuki c = new ClientIbuki(r);
//		r.c = c;
//		c.mr = new MixRenderIbuki(c);
//		return c;
//	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
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

//	@Override
//	public DataParameter<Integer>[] getIntegerDataParameterArray()
//	{
//		return INTEGER_DATAPARAMETER_ARRAY;
//	}
//
//	@Override
//	public DataParameter<Float>[] getFloatDataParameterArray()
//	{
//		return FLOAT_DATAPARAMETER_ARRAY;
//	}

	@SideOnly(Side.CLIENT)
	@Override
	public void newC()
	{
		RenderIbuki r = new RenderIbuki();
		ClientIbuki c = new ClientIbuki(this, r, new SoundE());
		MixCIIbuki mc = new MixCIIbuki(c);
		c.mc = mc;
		mc.init();
		c.mb = new MixBoxSleInv(c);
		c.mr = new MixRenderIbuki(c);
		r.c = c;
		c.ie = new InvLe();
		this.ibothleinv = c;
	}

	@Override
	public void newS()
	{
		ServerIbuki s = new ServerIbuki(this);
		MixSIIbuki ms = new MixSIIbuki(s);
		s.ms = ms;
		ms.init();
		s.initKey();
		s.ie = new InvLe();
		this.ibothleinv = s;
	}

	@Override
	public IBothDaE getBD()
	{
		return BothDaIbuki.IDA;
	}

	@Override
	public IBothLeInv getB()
	{
		return this.ibothleinv;
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
	public void mulFrame(float[] skinning_float_array, short[] key_short_array, float partial_ticks)
	{
		float body_rot = (float)Math.toRadians(EntityMath.interpolateRotation(this.prev_rotation_yaw_head, this.rotation_yaw_head, partial_ticks));
		float head_pitch = (float)Math.toRadians(this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * partial_ticks);
		float head_rot = (float)Math.toRadians(EntityMath.interpolateRotation(this.prevRotationYaw, this.rotationYaw, partial_ticks));
		float net_head_yaw = head_rot - body_rot;

		if (head_pitch > 1.04719755119659774615F)
		{
			head_pitch = 1.04719755119659774615F;
		}
		else if (head_pitch < -1.04719755119659774615F)
		{
			head_pitch = -1.04719755119659774615F;
		}

		V4.q(V4.TV4_FLOAT_ARRAY, 0.0F, 0.0F, body_rot);
		float[] body_m4x4 = V4.getM4X4(V4.TV4_FLOAT_ARRAY);
		V4.q(V4.TV4_FLOAT_ARRAY, -head_pitch, 0, net_head_yaw);
		float[] head_m4x4 = V4.getM4X4(V4.TV4_FLOAT_ARRAY);

		M4x4.m(head_m4x4, skinning_float_array, 0, 39*16);

		M4x4.m(body_m4x4, skinning_float_array, 0, 0);
	}
}
