package com.nali.list.entity;

import com.nali.da.IBothDaE;
import com.nali.list.da.BothDaSaori;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.entity.si.*;
import com.nali.list.render.RenderSaori;
import com.nali.math.M4x4;
import com.nali.math.V4;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.IBothLe;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSle;
import com.nali.small.entity.memo.server.si.SILeLook;
import com.nali.small.entity.memo.server.si.path.SILeFindMove;
import com.nali.small.entity.memo.server.si.path.SILeMineTo;
import com.nali.sound.SoundE;
import com.nali.summer.entity.memo.client.saori.ClientSaori;
import com.nali.summer.entity.memo.client.saori.MixCISaori;
import com.nali.summer.entity.memo.server.saori.MixSISaori;
import com.nali.summer.entity.memo.server.saori.ServerSaori;
import com.nali.system.Time;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

public class SummerSaori extends EntityLe implements IMixES, IMixESInv
{
	public static int eggPrimary = 0x283756;
	public static int eggSecondary = 0x4a73bd;

	public static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaSaori.IDA.E_MaxSync()];
//	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaSaori.IDA.S_MaxFrame()];
//	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	public static byte[] CI_BYTE_ARRAY;
	public static byte[] SI_BYTE_ARRAY;

	public IBothLe ibothle;

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

//		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSaori.class, DataSerializers.VARINT);
//		}
//
//		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSaori.class, DataSerializers.FLOAT);
//		}
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

			SIELock.ID,
			SILeLockDMG.ID,
			SILeMineTo.ID,
			SIEUseTo.ID,
			SIESit.ID,
			SIELocation.ID,
			SIEFollow.ID,
			SIERevive.ID,
			SIECareOwner.ID,
			SILeAttack.ID,
			SIEManageItem.ID,
			SIEInv.ID,
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
//	public static ClientSaori getC()
//	{
//		RenderSaori r = new RenderSaori();
//		ClientSaori c = new ClientSaori(r);
//		r.c = c;
//		c.mr = new MixRenderSaori(c);
//		return c;
//	}
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
		//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
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
		RenderSaori r = new RenderSaori();
		ClientSaori c = new ClientSaori(this, r, new SoundE());
		MixCISaori mc = new MixCISaori(c);
		c.mc = mc;
		c.mb = new MixBoxSle(c);
//		c.mr = new MixRenderSaori(c);
		MixRenderSle mr = new MixRenderSle(c);
		mr.shadow_opaque = 0.5F;
		mr.shadow_size = 0.25F;
		c.mr = mr;
		r.c = c;
		this.ibothle = c;
	}

	@Override
	public void newS()
	{
		ServerSaori s = new ServerSaori(this);
		MixSISaori ms = new MixSISaori(s);
		s.ms = ms;
		ms.init();
		s.initKey();
		s.init();
		this.ibothle = s;
	}

	@Override
	public IBothDaE getBD()
	{
		return BothDaSaori.IDA;
	}

	@Override
	public IBothLe getB()
	{
		return this.ibothle;
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
	public void mulFrame(float[] skinning_float_array, short[] key_short_array)
	{
		float
			body_rot,
			head_rot,
			head_pitch;

		if (this.world.isRemote)
		{
			this.prev_rotation_yaw_body += (this.rotation_yaw_body - this.prev_rotation_yaw_body) * (float)Time.LINE;
			this.prev_rotation_yaw += (this.rotationYaw - this.prev_rotation_yaw) * (float)Time.LINE;
			this.prev_rotation_pitch += (this.rotationPitch - this.prev_rotation_pitch) * (float)Time.LINE;
			body_rot = (float)Math.toRadians(this.prev_rotation_yaw_body);
			head_rot = (float)Math.toRadians(this.prev_rotation_yaw);
			head_pitch = (float)Math.toRadians(this.prev_rotation_pitch);
		}
		else
		{
			body_rot = (float)Math.toRadians(this.rotation_yaw_body);
			head_rot = (float)Math.toRadians(this.rotationYaw);
			head_pitch = (float)Math.toRadians(this.rotationPitch);
		}

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

		M4x4.m(head_m4x4, skinning_float_array, 0, 38*16);

		M4x4.m(body_m4x4, skinning_float_array, 0, 0);
	}
}
