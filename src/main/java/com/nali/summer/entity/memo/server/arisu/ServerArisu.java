package com.nali.summer.entity.memo.server.arisu;

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
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySleFLoopFreePSrE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.KeySleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.si.frame.shoot.KeySleShoot;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySTLoop;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySleTLoopAttackStand;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySleTLoopAttackWalk;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySleTLoopWalk;
import com.nali.small.entity.memo.server.si.frame.tloopfb.KeySTLoopFBSit;
import com.nali.system.bytes.ByteWriter;
import net.minecraft.util.DamageSource;

public class ServerArisu
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
		738, 783,
		835, 860,
		560, 576,
		932, 948,
		949, 999,
		173, 204,
		522, 559,
		81, 172,
		861, 931,
		0, 80,
		577, 643,
		644, 660,
		687, 737
	};
	public static byte[] KEY_DATA_BYTE_ARRAY = new byte[]
	{
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

	public ServerArisu(I i)
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
				new KeySTLoopFBSit(this, (byte)2),
				new KeySleFLoopOffSetAttackEndWalk(this, (byte)4),
				new KeySleShoot(this, (byte)7),
				new KeySleTLoopAttackWalk(this, (byte)12),
				new KeySleTLoopWalk(this, (byte)14),
				new KeySFLoopFreeHardReady(this, (byte)16),
				new KeySleFLoopFreePSrE(this, (byte)18),
				new KeySleTLoopAttackStand(this, (byte)20),
				new KeySTLoop(this, (byte)22)
			}
		};
//		() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//		() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopFB(1),
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
