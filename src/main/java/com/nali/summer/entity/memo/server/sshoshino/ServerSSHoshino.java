package com.nali.summer.entity.memo.server.sshoshino;

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
import com.nali.small.entity.memo.server.si.frame.floop.FrameSleFLoopDiePlus;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSleFLoopFreePSrE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.FrameSleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.si.frame.shoot.FrameSleShoot;
import com.nali.small.entity.memo.server.si.frame.tloop.*;
import com.nali.sound.ISoundDaLe;

public class ServerSSHoshino
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
		{ 409, 459 },
		{ 596, 679 },
		{ 715, 729 },
		{ 680, 695 },
		{ 696, 714 },
		{ 313, 408 },
		{ 558, 595 },
		{ 167, 312 },
		{ 507, 557 },
		{ 0, 166 },
		{ 730, 752 },
		{ 753, 761 },
		{ 762, 812 },
		{ 460, 506 }
	};
	public static byte[] FRAME_BYTE_ARRAY = new byte[]
	{
		0, 2, 0, 13,
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

	//	public boolean server_how_die;
	public ServerSSHoshino(I i)
	{
		super(i);
	}

	@Override
	public void initFrame()
	{
		this.frames_2d_array = new FrameS[][]
		{
			{
				new FrameSleFLoopDiePlus(this, 0/*, 2*/),
				new FrameSTLoopSit(this, 3+1+2),
				new FrameSleFLoopOffSetAttackEndWalk(this, 5+1+2),
				new FrameSleShoot(this, 8+1+2),
				new FrameSleTLoopAttackWalk(this, 13+1+2),
				new FrameSleTLoopWalk(this, 15+1+2),
				new FrameSFLoopFreeHardReady(this, 17+1+2),
				new FrameSleFLoopFreePSrE(this, 19+1+2),
				new FrameSleTLoopAttackStand(this, 21+1+2),
				new FrameSTLoop(this, 23+1+2)
			}
		};
//		() ->
//		{
//			boolean result = this.isZeroMove();
//			int id = 0;
//
//			if (result)
//			{
//				if (serverentitiesmemory.server_how_die)
//				{
//					id = 13;
//				}
//			}
//			else
//			{
//				if (this.ticksExisted % 50 == 0)
//				{
//					serverentitiesmemory.server_how_die = !serverentitiesmemory.server_how_die;
//				}
//			}
//
//			return result && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(id);
//		},

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
