package com.nali.list.entity;

import com.nali.da.IBothDaE;
import com.nali.list.da.BothDaE22Locker;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.si.*;
import com.nali.list.render.RenderE22Locker;
import com.nali.math.M4x4;
import com.nali.math.V4;
import com.nali.small.entity.EntityE;
import com.nali.small.entity.EntityMath;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvE;
import com.nali.small.entity.memo.IBothE;
import com.nali.small.entity.memo.client.box.mix.MixBoxSeRSe;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.server.si.MixSIELock;
import com.nali.small.entity.memo.server.si.SI;
import com.nali.summer.entity.memo.client.e22locker.ClientE22Locker;
import com.nali.summer.entity.memo.client.e22locker.MixRenderE22Locker;
import com.nali.summer.entity.memo.server.e22locker.ServerE22Locker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.MODEL_STEP;

public class SummerE22Locker extends EntityE implements IMixES, IMixESInv
{
	public static int eggPrimary = 0x1a69a7;
	public static int eggSecondary = 0xffffff;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaE22Locker.IDA.E_MaxSync()];
//	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaE22Locker.IDA.S_MaxFrame()];
//	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	public static byte[] CI_BYTE_ARRAY;
	public static byte[] SI_BYTE_ARRAY;

	public IBothE ibothe;

	public static int[] IV_INT_ARRAY = new int[]
	{
		5+90 + MODEL_STEP, 523,
		5+90 + MODEL_STEP, 560,
		5+90 + MODEL_STEP, 12,
		5+90 + MODEL_STEP, 451,
		5+90 + MODEL_STEP, 451,
		4+90 + MODEL_STEP, 99
	};
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.65F * 0.5F, 0.0F,
		0.1F, -1.8F * 0.5F, 0.07F * 0.5F,
		0.1F, -1.85F * 0.5F, 0.09F * 0.5F,
		0.1F, -1.8F * 0.5F, 0.09F * 0.5F
	};

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerE22Locker.class, DataSerializers.BYTE);
		}

//		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerE22Locker.class, DataSerializers.VARINT);
//		}
//
//		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerE22Locker.class, DataSerializers.FLOAT);
//		}
	}

	public SummerE22Locker(World world)
	{
		super(world);
	}

	public static void initID()
	{
		CI_BYTE_ARRAY = new byte[]
		{
			CIEFrame.ID
		};

		SI_BYTE_ARRAY = new byte[]
		{
			SIEArea.ID,
			SIEOwner.ID,

			SIELock.ID,

//			SIEMineTo.ID,
//			SIESit.ID,
//			SIESetLocation.ID,

			SIEPlayWithRSe.ID,//Play-1

			SIEKey.ID,

//			SIEFindMove.ID,
//			SIEWalkTo.ID,
			SIELook.ID
		};
	}

//	@SideOnly(Side.CLIENT)
//	public static ClientE22Locker getC()
//	{
//		RenderE22Locker r = new RenderE22Locker();
//		ClientE22Locker c = new ClientE22Locker(r);
//		r.c = c;
//		c.mr = new MixRenderE22Locker(c);
//		return c;
//	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
	}

//	@Override
//	public void applyEntityAttributes()
//	{
//		super.applyEntityAttributes();
//		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
//		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
//		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
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
//	public AxisAlignedBB getMouthAxisAlignedBB()
//	{
//		return this.getEntityBoundingBox().grow(0.25);
//	}

//	@Override
//	public void collideWithNearbyEntities()
//	{
//	}

//	@Override
//	public boolean canBePushed()
//	{
//		return false;
//	}

//	@Override
//	public void heal(float value)
//	{
//		if (!this.world.isRemote)
//		{
//			ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
//
//			if (serverentitiesmemory.skinningentities != null)
//			{
//				serverentitiesmemory.skinningentities.heal(value);
//			}
//		}
//		else
//		{
//			super.heal(value);
//		}
//	}

//	@Override
//	public boolean canEat()
//	{
//		return this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).skinningentities != null;
//	}

//	@Override
//	public boolean canPat()
//	{
//		return false;
//	}

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
		RenderE22Locker r = new RenderE22Locker();
		ClientE22Locker c = new ClientE22Locker(this, r);
		MixCIE mc = new MixCIE(c);
		c.mc = mc;
		mc.init();
		c.mb = new MixBoxSeRSe(c);
		c.mr = new MixRenderE22Locker(c);
		r.c = c;
		c.ie = new InvE();
		this.ibothe = c;
	}

	@Override
	public void newS()
	{
		ServerE22Locker s = new ServerE22Locker(this);
//		MixSIE22Locker ms = new MixSIE22Locker(s);
		MixSIELock ms = new MixSIELock(s, new SI[]
		{
			new SIEArea(s),
			new SIEOwner(s),

			new SIELock(s),

			new SIEPlayWithRSe(s),

			new SIEKey(s),

			new SIELook(s)
		});
		s.ms = ms;
		ms.init();
		s.initKey();
		s.ie = new InvE();
		this.ibothe = s;
	}

	@Override
	public IBothDaE getBD()
	{
		return BothDaE22Locker.IDA;
	}

	@Override
	public IBothE getB()
	{
		return this.ibothe;
	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public Object createObjectRender()
//	{
//		return new E22LockerRender(new EntitiesRenderMemory(), this);
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
//		return ClientE22LockerMemory.IV_INT_ARRAY;
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
		float head_rot = (float)Math.toRadians(EntityMath.interpolateRotation(this.prevRotationYaw, this.rotationYaw, partial_ticks));

		V4.q(V4.TV4_FLOAT_ARRAY, 0, 0, head_rot);
		float[] head_m4x4 = V4.getM4X4(V4.TV4_FLOAT_ARRAY);
		M4x4.m(head_m4x4, skinning_float_array, 0, 0);
	}
}
