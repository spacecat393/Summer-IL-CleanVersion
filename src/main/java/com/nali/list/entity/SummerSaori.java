package com.nali.list.entity;

import com.nali.da.IBothDaE;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.entity.si.*;
import com.nali.list.render.RenderSaori;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.IBothLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.list.da.BothDaSaori;
import com.nali.summer.entity.memo.client.saori.ClientSaori;
import com.nali.summer.entity.memo.client.saori.MixCISaori;
import com.nali.summer.entity.memo.client.saori.MixRenderSaori;
import com.nali.summer.entity.memo.server.saori.MixSISaori;
import com.nali.summer.entity.memo.server.saori.ServerSaori;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;
import static com.nali.small.entity.memo.client.render.FRenderSeMath.interpolateRotation;

public class SummerSaori extends EntityLeInv implements IMixES, IMixESInv
{
	public static int eggPrimary = 0x283756;
	public static int eggSecondary = 0x4a73bd;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaSaori.MAX_SYNC];
	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaSaori.MAX_FRAME];
	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	public static byte[] CI_BYTE_ARRAY;
	public static byte[] SI_BYTE_ARRAY;

	public IBothLeInv ibothleinv;

	public static int[] IV_INT_ARRAY = new int[]
	{
		4+106 + MODEL_STEP, 6697,
		4+106 + MODEL_STEP, 7694,
		4+106 + MODEL_STEP, 11839,
		4+106 + MODEL_STEP, 2735,
		4+106 + MODEL_STEP, 1759,
		8+106 + MODEL_STEP, 39
	};
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.55F * 0.5F, 0.0F,
		0.0F, -1.0F * 0.5F, 0.05F * 0.5F,
		0.0F, -1.1F * 0.5F, 0.12F * 0.5F,
		0.0F, -1.05F * 0.5F, 0.12F * 0.5F
	};

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSaori.class, DataSerializers.BYTE);
		}

		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
		{
			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSaori.class, DataSerializers.VARINT);
		}

		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
		{
			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSaori.class, DataSerializers.FLOAT);
		}
	}

	public SummerSaori(World world)
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
	public static ClientSaori getC()
	{
		RenderSaori r = new RenderSaori();
		ClientSaori c = new ClientSaori(r);
		r.c = c;
		c.mr = new MixRenderSaori(c);
		return c;
	}
//	@Override
//	public AxisAlignedBB getMouthAxisAlignedBB()
//	{
//		ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//		SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
//		int frame = skinningrender.frame_int_array[0];
//
//		if (frame > 889 && frame < 943)
//		{
//			double hw = this.width / 2.0F;
//			double hh = 0.5;
//			Vec3d view_vec3d = this.getVectorForRotation(this.rotationPitch, this.rotationYaw + 90.0F).scale(0.5);
//			double x = this.posX + view_vec3d.x;
//			double y = this.posY + this.height / 2.0F + view_vec3d.y;
//			double z = this.posZ + view_vec3d.z;
//			return new AxisAlignedBB(x - hw, y, z - hw, x + hw, y + hh, z + hw);
//		}
//		else
//		{
//			return super.getMouthAxisAlignedBB();
//		}
//	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
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
		RenderSaori r = new RenderSaori();
		ClientSaori c = new ClientSaori(this, r);
		MixCISaori mc = new MixCISaori(c);
		c.mc = mc;
		mc.init();
		c.mb = new MixBoxSleInv(c);
		c.mr = new MixRenderSaori(c);
		r.c = c;
		c.ie = new InvLe();
		this.ibothleinv = c;
	}

	@Override
	public void newS()
	{
		ServerSaori s = new ServerSaori(this);
		MixSISaori ms = new MixSISaori(s);
		s.ms = ms;
		ms.init();
		s.initFrame();
		s.ie = new InvLe();
		this.ibothleinv = s;
	}

	@Override
	public IBothDaE getBD()
	{
		return BothDaSaori.IDA;
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
//		return new SaoriRender(new EntitiesRenderMemory(), this);
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
//		return ClientSaoriMemory.IV_INT_ARRAY;
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
		float head_rot = (float)Math.toRadians(interpolateRotation(this.prevRotationYaw, this.rotationYaw, partial_ticks));
		float head_pitch = (float)Math.toRadians(this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * partial_ticks);
		float body_rot = (float)Math.toRadians(interpolateRotation(this.prevRenderYawOffset, this.renderYawOffset, partial_ticks));
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

		head_m4x4.multiply(skinning_float_array, 38*16);

		body_m4x4.multiply(skinning_float_array, 0);
	}
}
