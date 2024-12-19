package com.nali.list.entity;

import com.nali.da.IBothDaE;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.entity.si.*;
import com.nali.list.render.RenderArisu;
import com.nali.math.M4x4;
import com.nali.math.Quaternion;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.EntityMath;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.IBothLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.list.da.BothDaArisu;
import com.nali.sound.SoundE;
import com.nali.summer.entity.memo.client.arisu.ClientArisu;
import com.nali.summer.entity.memo.client.arisu.MixCIArisu;
import com.nali.summer.entity.memo.client.arisu.MixRenderArisu;
import com.nali.summer.entity.memo.server.arisu.MixSIArisu;
import com.nali.summer.entity.memo.server.arisu.ServerArisu;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

public class SummerArisu extends EntityLeInv implements IMixES, IMixESInv
{
	public static int eggPrimary = 0x454D60;
	public static int eggSecondary = 0xF8E9E4;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaArisu.IDA.E_MaxSync()];
//	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaArisu.IDA.S_MaxFrame()];
//	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	public static byte[] CI_BYTE_ARRAY;
	public static byte[] SI_BYTE_ARRAY;

	public IBothLeInv ibothleinv;

	public static int[] IV_INT_ARRAY = new int[]
	{
		5+25 + MODEL_STEP, 8547,
		5+25 + MODEL_STEP, 9270,
		/*0+*/25 + MODEL_STEP, 2078,
		5+25 + MODEL_STEP, 268,
		5+25 + MODEL_STEP, 519,
		8+25 + MODEL_STEP, 39
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
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerArisu.class, DataSerializers.BYTE);
		}

//		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerArisu.class, DataSerializers.VARINT);
//		}
//
//		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerArisu.class, DataSerializers.FLOAT);
//		}
	}

	public SummerArisu(World world)
	{
		super(world);
//		Nali.LOGGER.info("New " + this + " C " + this.world.isRemote);
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

			SIEKey.ID,

			SILeFindMove.ID,
			SILeMove.ID,
			SILeWalkTo.ID,
			SIELook.ID,
			SILeJump.ID
		};
	}

	@SideOnly(Side.CLIENT)
	public static ClientArisu getC()
	{
		RenderArisu r = new RenderArisu();
		ClientArisu c = new ClientArisu(r);
		r.c = c;
		c.mr = new MixRenderArisu(c);
		return c;
	}
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void updateClient()
//	{
//		ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//		ArisRender skinningrender = (ArisRender)cliententitiesmemory.objectrender;
//		BothData bothdata = cliententitiesmemory.bothdata;
//		int frame = skinningrender.frame_int_array[0];
//
//		if (frame < 205)
//		{
////			skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
////			skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
//			skinningrender.model_byte_array[0] &= 239 & 191;
//		}
//		else
//		{
////			skinningrender.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
////			skinningrender.model_byte_array[6 / 8] |= 64;//Math.pow(2, 6 % 8)
//			skinningrender.model_byte_array[0] |= 16 | 64;
//		}
//
//		float scale = skinningrender.entitiesrendermemory.scale;
//		if (frame > 834 && frame < 861)
//		{
//			this.width = bothdata.E_Width() * scale;
//			this.height = 0.65F * scale;
//		}
//		else if (frame > 737 && frame < 784)
//		{
//			this.width = 1.5F * scale;
//			this.height = 0.2F * scale;
//		}
//		else
//		{
//			this.width = bothdata.E_Width() * scale;
//			this.height = bothdata.E_Height() * scale;
//		}
//	}

//	@Override
//	public AxisAlignedBB getMouthAxisAlignedBB()
//	{
//		ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//		SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
//		int frame = skinningrender.frame_int_array[0];
//
//		if (frame > 834 && frame < 861)
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

//	@Override
//	public BothData createBothData()
//	{
//		return BOTHDATA;
//	}
//
//	@Override
//	public WorkBytes createWorkBytes()
//	{
//		return WORKBYTES;
//	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
	}

//	@Override
//	public void createServer()
//	{
//		ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
//		WorkBytes workbytes = serverentitiesmemory.workbytes;
//
//		serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];
//
//		serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
//		serverentitiesmemory.entitiesaimemory.skinningentitiesattack.max_magic_point = 2;
//		serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 48.0F;
//
//		serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
//		serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
//		{
//			() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//			() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
//			() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//			() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
//			() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
//			() -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
//			() -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)4),
//			() -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)(1 + 2 + 8)),
//			() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8),
//			() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(9)
//		};
//	}

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
		RenderArisu r = new RenderArisu();
		ClientArisu c = new ClientArisu(this, r, new SoundE());
		MixCIArisu mc = new MixCIArisu(c);
		c.mc = mc;
		mc.init();
		c.mb = new MixBoxSleInv(c);
		c.mr = new MixRenderArisu(c);
		r.c = c;
		c.ie = new InvLe();
		this.ibothleinv = c;
	}

	@Override
	public void newS()
	{
		ServerArisu s = new ServerArisu(this);
		MixSIArisu ms = new MixSIArisu(s);
		s.ms = ms;
		ms.init();
		s.initKey();
		s.ie = new InvLe();
		this.ibothleinv = s;
	}

	@Override
	public IBothDaE getBD()
	{
		return BothDaArisu.IDA;
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
//		return new ArisRender(new EntitiesRenderMemory(), this);
//	}

//	@Override
//	public Sounds createSounds()
//	{
//		return SOUNDS;
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
//		return ClientArisMemory.IV_INT_ARRAY;
//	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
//	{
//		new ClientArisMemory(skinningentities, bothdata, workbytes);
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
	public void mulFrame(float[] skinning_float_array, short[] key_short_array, float partial_ticks)
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

		head_m4x4.multiply(skinning_float_array, 28*16);

		body_m4x4.multiply(skinning_float_array, 0);
	}
}
