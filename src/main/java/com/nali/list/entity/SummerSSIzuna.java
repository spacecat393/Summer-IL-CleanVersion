package com.nali.list.entity;

import com.nali.da.IBothDaNe;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.entity.si.*;
import com.nali.list.render.s.RenderSSIzuna;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.IBothLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.summer.da.both.BothDaSSIzuna;
import com.nali.summer.entity.memo.client.ssizuna.ClientSSIzuna;
import com.nali.summer.entity.memo.client.ssizuna.MixCISSIzuna;
import com.nali.summer.entity.memo.client.ssizuna.MixRenderSSIzuna;
import com.nali.summer.entity.memo.server.ssizuna.MixSISSIzuna;
import com.nali.summer.entity.memo.server.ssizuna.ServerSSIzuna;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SummerSSIzuna extends EntityLeInv
{
	public static int eggPrimary = 0x7d4a39;
	public static int eggSecondary = 0xf4c4d7;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaSSIzuna.MAX_SYNC];
	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaSSIzuna.MAX_FRAME];
	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	public static byte[] CI_BYTE_ARRAY;
	public static byte[] SI_BYTE_ARRAY;

	public IBothLeInv ibothleinv;

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSIzuna.class, DataSerializers.BYTE);
		}

		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
		{
			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSIzuna.class, DataSerializers.VARINT);
		}

		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
		{
			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(SummerSSIzuna.class, DataSerializers.FLOAT);
		}
	}

	public SummerSSIzuna(World world)
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
	public static ClientSSIzuna getC()
	{
		RenderSSIzuna r = new RenderSSIzuna(RenderSSIzuna.ICLIENTDAS, BothDaSSIzuna.IBOTHDASN);
		ClientSSIzuna c = new ClientSSIzuna(r);
		r.c = c;
		c.mr = new MixRenderSSIzuna(c);
		return c;
	}
//	@Override
//	public AxisAlignedBB getMouthAxisAlignedBB()
//	{
//		ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//		SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
//		int frame = skinningrender.frame_int_array[0];
//
//		if (frame > 314 && frame < 351)
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
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
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
		RenderSSIzuna r = new RenderSSIzuna(RenderSSIzuna.ICLIENTDAS, BothDaSSIzuna.IBOTHDASN);
		ClientSSIzuna c = new ClientSSIzuna(this, r);
		MixCISSIzuna mc = new MixCISSIzuna(c);
		c.mc = mc;
		mc.init();
		c.mb = new MixBoxSleInv(c);
		c.mr = new MixRenderSSIzuna(c);
		r.c = c;
		c.ie = new InvLe();
		this.ibothleinv = c;
	}

	@Override
	public void newS()
	{
		ServerSSIzuna s = new ServerSSIzuna(this);
		MixSISSIzuna ms = new MixSISSIzuna(s);
		s.ms = ms;
		ms.init();
		s.initFrame();
		s.ie = new InvLe();
		this.ibothleinv = s;
	}

	@Override
	public IBothDaNe getBD()
	{
		return BothDaSSIzuna.IBOTHDASN;
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
//		return new SSUnaRender(new EntitiesRenderMemory(), this);
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
//		return ClientSSUnaMemory.IV_INT_ARRAY;
//	}
}
