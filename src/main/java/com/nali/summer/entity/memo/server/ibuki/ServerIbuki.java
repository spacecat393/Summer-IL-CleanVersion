package com.nali.summer.entity.memo.server.ibuki;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaNe;
import com.nali.list.entity.SummerIbuki;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.network.message.ClientMessage;
import com.nali.network.NetworkRegistry;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.frame.KeyS;
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopDieSSle;
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopSSleStart;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySleFLoopFreePSrE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.KeySleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.si.frame.floopoffset.KeySleFLoopOffSetAttackEndWalkSSle;
import com.nali.small.entity.memo.server.si.frame.shoot.KeySleShoot;
import com.nali.small.entity.memo.server.si.frame.shoot.KeySleShootSSle;
import com.nali.small.entity.memo.server.si.frame.tloop.*;
import com.nali.small.entity.memo.server.si.frame.tloopfb.KeySleTLoopFBSitSSle;
import com.nali.system.bytes.ByteWriter;
import net.minecraft.util.DamageSource;

public class ServerIbuki
<
	IE extends InvLe,
	BD extends IBothDaE & IBothDaNe,
	E extends EntityLeInv,
	I extends IMixE<BD, E>,
	MS extends MixSIIbuki<IE, BD, E, I, ?>
> extends ServerLeInv<IE, BD, E, I, MS> implements IServerS
{
	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		297, 347, 347-297+2,
		348, 431,
		474, 486,//start attack
		1265, 1281,//loop move
		1282, 1312,//end move
		263, 296,//cafe walk
		585, 622,
		101, 262,
		432, 473,
		0, 100,
		487, 517,
		518, 528,
		529, 584,
		623, 656,// 13 start ride
		1214, 1264,// 14 loop ride
		657, 707,// 15 loop ride-move
		878, 919,// 16 end ride-move
		1163, 1213,// 17 ride-panic
		827, 877,// 18 ride-destroy
		708, 724,// 19 start ride-attack
		725, 758,// 20 loop ride-attack
		759, 775,// 21 end ride-attack
		776, 826// 22 ride-reload
	};
	public static byte[] KEY_DATA_BYTE_ARRAY = new byte[]
	{
		0, 13*2,
		0, 18*2,
		0, 17*2,
		0, 15*2, 16*2,
		0, 19*2, 20*2, 21*2, 22*2,
		0, 14*2,

		0, 0*2,
		0, 1*2,
		0, 3*2, 4*2,
		0, 2*2, 10*2, 11*2, 12*2,
		0, 3*2,
		0, 5*2,
		0, 6*2,
		0, 7*2,
		0, 8*2,
		0, 9*2
	};
	public KeyS[][] keys_2d_array;
//	public SILePlayWithSSle sileplaywithssle;

	public ServerIbuki(I i)
	{
		super(i);
	}

	@Override
	public void initKey()
	{
		this.keys_2d_array = new KeyS[][]
		{
			{
				new KeySleFLoopSSleStart(this, (byte)0),
				new KeySleFLoopDieSSle(this, (byte)2),
				new KeySleTLoopFBSitSSle(this, (byte)4),
				new KeySleFLoopOffSetAttackEndWalkSSle(this, (byte)6),
				new KeySleShootSSle(this, (byte)9),
				new KeySTLoopPWStand(this, (byte)14, SummerIbuki.PW_BYTE_ARRAY),

				new KeySleFLoopDie(this, /*0+*/(byte)16),
				new KeySTLoopSit(this, (byte)(2+16)),
				new KeySleFLoopOffSetAttackEndWalk(this, (byte)(4+16)),
				new KeySleShoot(this, (byte)(7+16)),
				new KeySleTLoopAttackWalk(this, (byte)(12+16)),
				new KeySleTLoopWalk(this, (byte)(14+16)),
				new KeySFLoopFreeHardReady(this, (byte)(16+16)),
				new KeySleFLoopFreePSrE(this, (byte)(18+16)),
				new KeySleTLoopAttackStand(this, (byte)(20+16)),
				new KeySTLoop(this, (byte)(22+16))
			}
		};
//		() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//		() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
//		() -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
//		() -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)4),
//		() -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)(1 + 2 + 8)),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(9)
	}

	@Override
	public void updateServer()
	{
		//sync tank
//		if (this.ms.sileplaywithssle.s2 == null && (this.sync_byte_array[0] & 128) == 128)
//		{
//			this.sync_byte_array[0] ^= (byte)128;
//			this.i.getE().getDataManager().set(this.i.getByteDataParameterArray()[0], this.sync_byte_array[0]);
//		}
	}

//	@Override
//	public void onShouldPlayWith()
//	{
//		super.onShouldPlayWith();
//		ServerEntitiesMemory serverentitiesmemory = (ServerEntitiesMemory)this.bothentitiesmemory;
//		SkinningEntities playwith_skinningentities = serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities;
//
//		DataParameter<Byte> byte_dataparameter = this.getByteDataParameterArray()[0];
//		serverentitiesmemory.sync_byte_array[0] = this.getDataManager().get(byte_dataparameter);
//		if ((serverentitiesmemory.sync_byte_array[0] & 128) == 0)
//		{
//			serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].lock = true;
//			serverentitiesmemory.sync_byte_array[0] ^= (byte)128;
//			this.getDataManager().set(byte_dataparameter, serverentitiesmemory.sync_byte_array[0]);
//		}
//		this.getDataManager().set(this.getIntegerDataParameterArray()[1], playwith_skinningentities.getDataManager().get(playwith_skinningentities.getIntegerDataParameterArray()[0]));
//		this.getDataManager().set(this.getFloatDataParameterArray()[1], playwith_skinningentities.getDataManager().get(playwith_skinningentities.getFloatDataParameterArray()[0]));
//	}

//	@Override
//	public void collideWithNearbyEntities()
//	{
//		if (this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities == null || !((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.should_play)
//		{
//			super.collideWithNearbyEntities();
//		}
//	}
//
//	@Override
//	public boolean canBePushed()
//	{
//		return this.world.isRemote || ((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities == null || !((ServerEntitiesMemory)this.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.should_play;
//	}

	@Override
	public KeyS[][] getKeyS2DArray()
	{
		return this.keys_2d_array;
	}

	@Override
	public byte[] getKeyDataByteArray()
	{
		return KEY_DATA_BYTE_ARRAY;
	}

	@Override
	public short[] getFixKeyShortArray()
	{
		return FIX_KEY_SHORT_ARRAY;
	}

	@Override
	public void getHurtSound(DamageSource damagesource)
	{
		byte[] byte_array = new byte[1 + 8 + 1 + 4];
		this.setCCI(byte_array, CIESound.ID);
		ByteWriter.set(byte_array, this.i.getBD().Ne_HURT(), 1 + 8 + 1);
		NetworkRegistry.I.sendToAll(new ClientMessage(byte_array));
	}

	@Override
	public void getDeathSound()
	{
		byte[] byte_array = new byte[1 + 8 + 1 + 4];
		this.setCCI(byte_array, CIESound.ID);
		ByteWriter.set(byte_array, this.i.getBD().Ne_DEATH(), 1 + 8 + 1);
		NetworkRegistry.I.sendToAll(new ClientMessage(byte_array));
	}
}
