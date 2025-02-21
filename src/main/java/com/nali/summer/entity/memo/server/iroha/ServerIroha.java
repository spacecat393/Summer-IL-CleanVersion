package com.nali.summer.entity.memo.server.iroha;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaNe;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.network.message.ClientMessage;
import com.nali.network.NetworkRegistry;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerLe;
import com.nali.small.entity.memo.server.si.MixSIE;
import com.nali.small.entity.memo.server.si.frame.KeyS;
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopDieRSe;
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopRSeStart;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeSoftReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySleFLoopFreePE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.KeySleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.si.frame.floopoffset.KeySleFLoopOffSetAttackEndWalkRSe;
import com.nali.small.entity.memo.server.si.frame.shoot.KeySleShoot;
import com.nali.small.entity.memo.server.si.frame.shoot.KeySleShootRSe;
import com.nali.small.entity.memo.server.si.frame.tloop.*;
import com.nali.small.entity.memo.server.si.frame.tloopfb.KeySTLoopFBSit;
import com.nali.small.entity.memo.server.si.frame.tloopfb.KeySTLoopFBSitRSe;
import com.nali.system.bytes.ByteWriter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ServerIroha
<
	BD extends IBothDaE & IBothDaNe,
	E extends EntityLe,
	I extends IMixE<BD, E>,
	MS extends MixSIE<BD, E, I, ?>
> extends ServerLe<BD, E, I, MS> implements IServerS
{
	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		321, 371,
		635, 685,
		516, 532,//start attack
		423, 473,//loop move
		474, 515,//end move
		143, 206,//cafe walk
		51, 142,
		258, 320,
		207, 257,
		372, 422,// 9 n-idle
		0, 50,
		533, 566,
		567, 583,
		584, 634,
		686, 719,// 14 start ride
		720, 770,// 15 loop ride
		1034, 1084,// 16 loop ride-move
		941, 982,// 17 end ride-move
		983, 1033,// 18 ride-panic
		890, 940,// 19 ride-destroy
		771, 787,// 20 start ride-attack
		788, 821,// 21 loop ride-attack
		822, 838,// 22 end ride-attack
		839, 889// 23 ride-reload
	};
	public static byte[] KEY_DATA_BYTE_ARRAY = new byte[]
	{
		0, 14*2, //0
		0, 19*2, //2
		0, 18*2, //4
		0, 16*2, 17*2, //6
		0, 20*2, 21*2, 22*2, 23*2, //9
		0, 15*2, //14

		0, 0*2, //16
		0, 1*2, //18
		0, 3*2, 4*2, //20
		0, 2*2, 11*2, 12*2, 13*2, //23
		0, 3*2, //28
		0, 5*2, //30
		0, 6*2, //32
		0, 7*2, //34
		0, 8*2, //36
		0, 9*2, //38
		0, 10*2 //40
	};
	public KeyS[][] keys_2d_array;

	public ServerIroha(I i)
	{
		super(i);
	}

	@Override
	public void init()
	{
		super.init();
		this.sileinv.itemstack_array = new ItemStack[4*9];
	}

	@Override
	public void initKey()
	{
		this.keys_2d_array = new KeyS[][]
		{
			{
				new KeySleFLoopRSeStart(this, (byte)0),
				new KeySleFLoopDieRSe(this, (byte)2),
				new KeySTLoopFBSitRSe(this, (byte)4),
				new KeySleFLoopOffSetAttackEndWalkRSe(this, (byte)6),
				new KeySleShootRSe(this, (byte)9),
				new KeySTLoopPWStand(this, (byte)14),

				new KeySleFLoopDie(this, (byte)16),
				new KeySTLoopFBSit(this, (byte)18),
				new KeySleFLoopOffSetAttackEndWalk(this, (byte)20),
				new KeySleShoot(this, (byte)23),
				new KeySleTLoopAttackWalk(this, (byte)28),
				new KeySleTLoopWalk(this, (byte)30),
				new KeySleFLoopFreePE(this, (byte)32),
				new KeySFLoopFreeHardReady(this, (byte)34),
				new KeySFLoopFreeSoftReady(this, (byte)36),
				new KeySleTLoopAttackStand(this, (byte)38),
				new KeySTLoop(this, (byte)40)
			}
		};
//		() ->
//		{
//			int id = 14;
//			boolean result = serverentitiesmemory.skinningentities != null && ((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.first_playwith;
//			if (result)
//			{
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id - 1);
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
//				if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][1])
//				{
//					((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesplaywith.first_playwith = false;
//				}
//			}
//
//			return result && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
//		},
//		() ->
//		{
//			int id = 19;
//			boolean result = serverentitiesmemory.skinningentities != null && this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
//			if (result)
//			{
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id - 1);
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
//			}
//
//			return result;
//		},
//		() ->
//		{
//			int id = 18;
//			boolean result = serverentitiesmemory.skinningentities != null && (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(id);
//			if (result)
//			{
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(id - 1);
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
//			}
//
//			return result;
//		},
//		() ->
//		{
//			int id0 = 16;
//			int id1 = 17;
//			boolean result = serverentitiesmemory.skinningentities != null && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(id0, id1);
//			if (result)
//			{
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(id0 - 1, id1 - 1);
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
//			}
//
//			return result;
//		},
//		() ->
//		{
//			int id0 = 20, id1 = 21, id2 = 22, id3 = 23;
//			boolean result = serverentitiesmemory.skinningentities != null && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(id0, id1, id2, id3, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack);
//			if (result)
//			{
//				int id;
//				int frame = serverentitiesmemory.frame_int_array[0];
//				if (frame >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id0][0] && frame <= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id0][1])
//				{
//					id = id0 - 1;
//				}
//				else if (frame >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id1][0] && frame <= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id1][1])
//				{
//					id = id1 - 1;
//				}
//				else if (frame >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id2][0] && frame <= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id2][1])
//				{
//					id = id1 - 1;
//				}
//				else
//				{
//					id = id3 - 1;
//				}
//
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].step = serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step;
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
//			}
//
//			return result;
//		},
//		() ->
//		{
//			int id = 15;
//			boolean result = serverentitiesmemory.skinningentities != null && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(id);
//			if (result)
//			{
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(id - 1);
//				((ServerEntitiesMemory)serverentitiesmemory.skinningentities.bothentitiesmemory).entitiesaimemory.skinningentitiesliveframe_array[0].stepFrame();
//			}
//
//			return result;
//		},

//		() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//		() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 11, 12, 13, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
//		() -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5),
//		() -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)(1 + 8)),
//		() -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(7, (byte)4),
//		() -> (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(8, (byte)2),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(9),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(10)
	}

	@Override
	public void updateServer()
	{
//		if (serverentitiesmemory.skinningentities != null && ((WorldServer)this.world).getEntityFromUuid(serverentitiesmemory.skinningentities.getUniqueID()) == null)
//		{
//			serverentitiesmemory.skinningentities = null;
//		}
	}

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
