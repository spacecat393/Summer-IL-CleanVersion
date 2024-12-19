package com.nali.summer.entity.memo.server.myuzu;

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
import com.nali.small.entity.memo.server.si.frame.attack.KeySleAttack;
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeSoftReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySleFLoopFreePE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.KeySleFLoopOffSetAttackPrepare;
import com.nali.small.entity.memo.server.si.frame.tloop.*;
import com.nali.system.bytes.ByteWriter;
import net.minecraft.util.DamageSource;

public class ServerMYuzu
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
		513, 563,
		0, 321,
		614, 643,//loop attack
		598, 613,
		479, 512,
		695, 770,
		644, 694,
		564, 597,
		0, 321,
		322, 478//pat
	};
	public static byte[] KEY_DATA_BYTE_ARRAY = new byte[]
	{
		0, 0*2,
		0, 1*2,
		0, 2*2, 2*2,
		0, 2*2,
		0, 3*2,
		0, 4*2,
		0, 9*2,
		0, 5*2,
		0, 6*2,
		0, 7*2,
		0, 8*2
	};
	public KeyS[][] keys_2d_array;

	public ServerMYuzu(I i)
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
				new KeySTLoopSit(this, (byte)2),
				new KeySleFLoopOffSetAttackPrepare(this, (byte)4),
				new KeySleAttack(this, (byte)7),
				new KeySleTLoopAttackWalk(this, (byte)9),
				new KeySleTLoopWalk(this, (byte)11),
				new KeySleFLoopFreePE(this, (byte)13),
				new KeySFLoopFreeHardReady(this, (byte)15),
				new KeySFLoopFreeSoftReady(this, (byte)17),
				new KeySleTLoopAttackStand(this, (byte)19),
				new KeySTLoop(this, (byte)21)
			}
		};
//		() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//		() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),

//		() -> (serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag & 2) == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(2, 2) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
//		() ->
//		{
//			boolean result = (serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag & 2) == 2;
//			if (result)
//			{
//				serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step = 1;
//
//				if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] < serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[2][0] || serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[2][1])
//				{
//					serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] = serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[2][0];
//					serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step = 0;
//					return true;
//				}
//
//				for (int attack_frame : serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array)
//				{
//					if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == attack_frame)
//					{
//						serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag |= 4;
//						break;
//					}
//				}
//			}
//
//			return result;
//		},

//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(3),
//		() -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(4),
//		() -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(9, (byte)(1 + 8)),
//		() -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(5, (byte)4),
//		() -> (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(6, (byte)2),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(7),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(8)
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
