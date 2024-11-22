package com.nali.summer.entity.memo.server.natsu;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaNE;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.network.message.ClientMessage;
import com.nali.network.NetworkRegistry;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIE;
import com.nali.small.entity.memo.server.si.frame.FrameS;
import com.nali.small.entity.memo.server.si.frame.FrameSleHeal;
import com.nali.small.entity.memo.server.si.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSleFLoopFreePSrE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.FrameSleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.si.frame.shoot.FrameSleShootBF;
import com.nali.small.entity.memo.server.si.frame.tloop.*;
import com.nali.system.bytes.ByteWriter;
import net.minecraft.util.DamageSource;

public class ServerNatsu
<
	IE extends InvLe,
	BD extends IBothDaE & IBothDaNE,
	E extends EntityLeInv,
	I extends IMixE<BD, E>,
	MS extends MixSIE<BD, E, I, ?>
> extends ServerLeInv<IE, BD, E, I, MS> implements IServerS
{
	public static int[][] FRAME_INT_2D_ARRAY = new int[][]
	{
		{ 766, 822 },
		{ 405, 488 },
		{ 684, 696 },
		{ 489, 509 },
		{ 510, 535 },
		{ 185, 225 },
		{ 1029, 1066 },
		{ 68, 184 },
		{ 536, 569 },
		{ 0, 66 },
		{ 697, 712 },
		{ 713, 723 },
		{ 570, 607 },
		{ 823, 868 }
	};
	public static byte[] FRAME_BYTE_ARRAY = new byte[]
	{
		0, 0,
		0, 1,
		0, 3, 4,
		0, 2, 10, 11, 12,
		0, 13,
		0, 3,
		0, 5,
		0, 6,
		0, 7,
		0, 8,
		0, 9
	};
	public FrameS[][] frames_2d_array;

	public ServerNatsu(I i)
	{
		super(i);
	}

	@Override
	public void initFrame()
	{
		this.frames_2d_array = new FrameS[][]
		{
			{
				new FrameSleFLoopDie(this, 0),
				new FrameSTLoopSit(this, 2),
				new FrameSleFLoopOffSetAttackEndWalk(this, 4),
				new FrameSleShootBF(this, 7),
				new FrameSleHeal(this, 12),
				new FrameSleTLoopAttackWalk(this, 14),
				new FrameSleTLoopWalk(this, 16),
				new FrameSFLoopFreeHardReady(this, 18),
				new FrameSleFLoopFreePSrE(this, 20),
				new FrameSleTLoopAttackStand(this, 22),
				new FrameSTLoop(this, 24)
			}
		};
//		() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//		() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(3, 4),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(2, 10, 11, 12, true, serverentitiesmemory.entitiesaimemory.skinningentitiesattack),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setHeal(13, serverentitiesmemory.entitiesaimemory.skinningentitiesheal),
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
	public FrameS[][] getFrameS2DArray()
	{
		return this.frames_2d_array;
	}

	@Override
	public byte[] getFrameByteArray()
	{
		return FRAME_BYTE_ARRAY;
	}

	@Override
	public int[][] getFrame2DIntArray()
	{
		return FRAME_INT_2D_ARRAY;
	}

	@Override
	public void getHurtSound(DamageSource damagesource)
	{
		byte[] byte_array = new byte[1 + 8 + 1 + 4];
		this.setCCI(byte_array, CIESound.ID);
		ByteWriter.set(byte_array, this.i.getBD().NE_HURT(), 1 + 8 + 1);
		NetworkRegistry.I.sendToAll(new ClientMessage(byte_array));
	}

	@Override
	public void getDeathSound()
	{
		byte[] byte_array = new byte[1 + 8 + 1 + 4];
		this.setCCI(byte_array, CIESound.ID);
		ByteWriter.set(byte_array, this.i.getBD().NE_DEATH(), 1 + 8 + 1);
		NetworkRegistry.I.sendToAll(new ClientMessage(byte_array));
	}
}
