package com.nali.summer.entity.memo.server.yuzu;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.list.entity.SummerYuzu;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIE;
import com.nali.small.entity.memo.server.si.frame.FrameS;
import com.nali.small.entity.memo.server.si.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floop.FrameSleFLoopSSeRSePlay;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSleFLoopFreePSrE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.FrameSleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.si.frame.shoot.FrameSleShoot;
import com.nali.small.entity.memo.server.si.frame.tloop.*;
import com.nali.sound.ISoundDaLe;

public class ServerYuzu
<
	IE extends InvLe,
	SD extends ISoundDaLe,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLeInv,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	MS extends MixSIE<BD, E, I, ?>
> extends ServerLeInv<IE, SD, BD, E, I, MS> implements IServerS
{
	public static int[][] FRAME_INT_2D_ARRAY = new int[][]
	{
		{ 717, 767 },
		{ 526, 592 },
		{ 627, 643 },
		{ 844, 859 },
		{ 860, 893 },
		{ 113, 143 },
		{ 806, 843 },
		{ 34, 112 },
		{ 593, 626 },
		{ 0, 33 },
		{ 644, 664 },
		{ 703, 716 },
		{ 768, 805 },
		{ 665, 702 },//delay attack
		{ 144, 441 },//locker react
		{ 442, 525 }//locker idle
	};
	public static byte[] FRAME_BYTE_ARRAY = new byte[]
	{
		0, 0,
		0, 14,
		0, 15,
		0, 1,
		0, 3, 4,
		0, 2, 10, 11, 12,
		0, 3,
		0, 5,
		0, 6,
		0, 7,
		0, 8,
		0, 9
	};
	public FrameS[][] frames_2d_array;

	public ServerYuzu(I i)
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
				new FrameSleFLoopSSeRSePlay(this, 2),
				new FrameSTLoopPWStand(this, 4, SummerYuzu.PW_BYTE_ARRAY),
				new FrameSTLoopSit(this, 6),
				new FrameSleFLoopOffSetAttackEndWalk(this, 8),
				new FrameSleShoot(this, 11),
				new FrameSleTLoopAttackWalk(this, 16),
				new FrameSleTLoopWalk(this, 18),
				new FrameSFLoopFreeHardReady(this, 20),
				new FrameSleFLoopFreePSrE(this, 22),
				new FrameSleTLoopAttackStand(this, 24),
				new FrameSTLoop(this, 26)
			}
		};
//		() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(0),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.should_play && (((ServerEntitiesMemory)serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.playwith_skinningentities.bothentitiesmemory).statentitiesmemory.stat & 16) == 16 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(14),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesplaywith.should_play && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(15),
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
}
