package com.nali.summer.entity.memo.server.myuzu;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIE;
import com.nali.small.entity.memo.server.si.frame.FrameS;
import com.nali.small.entity.memo.server.si.frame.attack.FrameSleAttack;
import com.nali.small.entity.memo.server.si.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSFLoopFreeSoftReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSleFLoopFreePE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.FrameSleFLoopOffSetAttackPrepare;
import com.nali.small.entity.memo.server.si.frame.tloop.*;
import com.nali.sound.ISoundDaLe;

public class ServerMYuzu
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
		{ 513, 563 },
		{ 0, 321 },
		{ 614, 643 },//loop attack
		{ 598, 613 },
		{ 479, 512 },
		{ 695, 770 },
		{ 644, 694 },
		{ 564, 597 },
		{ 0, 321 },
		{ 322, 478 }//pat
	};
	public static byte[] FRAME_BYTE_ARRAY = new byte[]
	{
		0, 0,
		0, 1,
		0, 2, 2,
		0, 2,
		0, 3,
		0, 4,
		0, 9,
		0, 5,
		0, 6,
		0, 7,
		0, 8
	};
	public FrameS[][] frames_2d_array;

	public ServerMYuzu(I i)
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
				new FrameSleFLoopOffSetAttackPrepare(this, 4),
				new FrameSleAttack(this, 7),
				new FrameSleTLoopAttackWalk(this, 9),
				new FrameSleTLoopWalk(this, 11),
				new FrameSleFLoopFreePE(this, 13),
				new FrameSFLoopFreeHardReady(this, 15),
				new FrameSFLoopFreeSoftReady(this, 17),
				new FrameSleTLoopAttackStand(this, 19),
				new FrameSTLoop(this, 21)
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
