package com.nali.list.entity;

import com.nali.da.IBothDaNe;
import com.nali.list.render.s.RenderE22Locker;
import com.nali.small.entity.EntityE;
import com.nali.small.entity.inv.InvE;
import com.nali.small.entity.memo.IBothE;
import com.nali.small.entity.memo.client.box.mix.MixBoxSeRSe;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.summer.da.both.BothDaE22Locker;
import com.nali.summer.entity.memo.client.e22locker.ClientE22Locker;
import com.nali.summer.entity.memo.client.e22locker.MixRenderE22Locker;
import com.nali.summer.entity.memo.server.e22locker.MixSIE22Locker;
import com.nali.summer.entity.memo.server.e22locker.ServerE22Locker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SummerE22Locker extends EntityE
{
	public static int eggPrimary = 0x1a69a7;
	public static int eggSecondary = 0xffffff;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaE22Locker.MAX_SYNC];
	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaE22Locker.MAX_FRAME];
	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerE22Locker.class, DataSerializers.BYTE);
		}

		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
		{
			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerE22Locker.class, DataSerializers.VARINT);
		}

		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
		{
			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerE22Locker.class, DataSerializers.FLOAT);
		}
	}

	public IBothE ibothe;

	public SummerE22Locker(World world)
	{
		super(world);
	}

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
	public byte[] getSI()
	{
		return MixSIE22Locker.SI_BYTE_ARRAY;
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
		RenderE22Locker r = new RenderE22Locker(RenderE22Locker.ICLIENTDAS, BothDaE22Locker.IBOTHDASN);
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
		MixSIE22Locker ms = new MixSIE22Locker(s);
		s.ms = ms;
		ms.init();
		s.initFrame();
		s.ie = new InvE();
		this.ibothe = s;
	}

	@Override
	public IBothDaNe getBD()
	{
		return BothDaE22Locker.IBOTHDASN;
	}

	@Override
	public IBothE getB()
	{
		return this.ibothe;
	}

	@SideOnly(Side.CLIENT)
	public static ClientE22Locker getC()
	{
		RenderE22Locker r = new RenderE22Locker(RenderE22Locker.ICLIENTDAS, BothDaE22Locker.IBOTHDASN);
		ClientE22Locker c = new ClientE22Locker(null, r);
		r.c = c;
		c.mr = new MixRenderE22Locker(c);
		return c;
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
}
