package com.nali.summer.entity.memo.server.ssshizuko;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaNe;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.network.message.ClientMessage;
import com.nali.network.NetworkRegistry;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIE;
import com.nali.small.entity.memo.server.si.frame.KeyS;
import com.nali.small.entity.memo.server.si.frame.KeySleProtect;
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySleFLoopFreePSrE;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySTLoop;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySTLoopSit;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySleTLoopWalk;
import com.nali.system.bytes.ByteWriter;
import net.minecraft.util.DamageSource;

public class ServerSSShizuko
<
	IE extends InvLe,
	BD extends IBothDaE & IBothDaNe,
	E extends EntityLeInv,
	I extends IMixE<BD, E>,
	MS extends MixSIE<BD, E, I, ?>
> extends ServerLeInv<IE, BD, E, I, MS> implements IServerS
{
	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		0, 222,// 0 cafe idle <- need frame
		0, 222,// 1 cafe idle
		381, 481,// 2 cafe walk
		482, 532,// 3 t-start 50
		223, 380,// 4 cafe react
		0, 222, // 5 cafe idle
		533, 610,// 6 spawn
		611, 704,// 7 idle
		705, 725,// 8 act
		726, 750,// 9 end

		//SeaHouse
		0, 50, // 10
		0, 0, // 11
		51, 128,// 12 spawn
		129, 222,// 13 idle
		223, 243,// 14 act
		244, 269// 15 end
	};
	public static byte[] KEY_DATA_BYTE_ARRAY = new byte[]
	{
		0, 0*2, //0
		0, 6*2, 7*2, 8*2, 9*2, //2
		0, 1*2, //7
		0, 2*2, //9
		0, 3*2, //11
		0, 4*2, //13
		0, 5*2, //15

		1, 12*2, 13*2, 14*2, 15*2, //17
		1, 10*2, //22
		1, 11*2 //24
	};
	public KeyS[][] keys_2d_array;

	public ServerSSShizuko(I i)
	{
		super(i);
	}

	@Override
	public void initKey()
	{
		this.keys_2d_array = new KeyS[][]
		{
			{
				new KeySleFLoopDie(this, (byte)0),
				new KeySleProtect(this, (byte)2),
				new KeySTLoopSit(this, (byte)7),
				new KeySleTLoopWalk(this, (byte)9),
				new KeySFLoopFreeHardReady(this, (byte)11),
				new KeySleFLoopFreePSrE(this, (byte)13),
				new KeySTLoop(this, (byte)15)
			},
			{
				new KeySleProtect(this, (byte)17),
				new KeySFLoopFreeHardReady(this, (byte)22),
				new KeySTLoop(this, (byte)24)
			}
		};
//		{
////			() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(0),
////			() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setProtect(6, 7, 8, 9, serverentitiesmemory.entitiesaimemory.skinningentitiesprotect),
////			() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
////			() -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(2),
////			() -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(3, (byte)4),
////			() -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(4, (byte)(1 + 2 + 8)),
////			() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(5)
//		};
//		{
////			() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1].setProtect(2, 3, 4, 5, serverentitiesmemory.entitiesaimemory.skinningentitiesprotect),
////			() -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1].setFLoopFree(0, (byte)4),
////			() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[1].setTLoop(1)
//		};
	}

	@Override
	public void updateServer()
	{
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
