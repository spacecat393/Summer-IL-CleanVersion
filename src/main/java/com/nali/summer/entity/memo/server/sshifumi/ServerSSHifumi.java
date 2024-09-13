package com.nali.summer.entity.memo.server.sshifumi;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSleFLoopAttackStand;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSFLoopFreeSoftReady;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSleFLoopFreePE;
import com.nali.small.entity.memo.server.ai.frame.floopoffset.FrameSleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.ai.frame.shoot.FrameSleShoot;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSTLoop;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSleTLoopAttackWalk;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSleTLoopWalk;
import com.nali.small.entity.memo.server.ai.frame.tloopfb.FrameSTLoopFBSit;
import com.nali.sound.ISoundDaLe;

public class ServerSSHifumi<SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, MS extends MixSIE<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
{
	public static int[][] FRAME_INT_2D_ARRAY = new int[][]
	{
		{ 285, 327 },
		{ 591, 641 },
		{ 180, 197 },
		{ 68, 118 },
		{ 119, 179 },
		{ 506, 539 },
		{ 422, 504 },
		{ 0, 67 },
		{ 540, 590 },
		{ 251, 284 },
		{ 379, 421 },
		{ 198, 232 },
		{ 233, 250 },
		{ 328, 378 }
	};
	public static byte[] FRAME_BYTE_ARRAY = new byte[]
	{
		0, 0,
		0, 1,
		0, 3, 4,
		0, 2, 11, 12, 13,
		0, 3,
		0, 5,
		0, 6,
		0, 7,
		0, 8,
		0, 9,
		0, 10
	};
	public FrameS[][] frames_2d_array;

	public ServerSSHifumi(I i, Inventory inventory)
	{
		super(i, inventory);
	}

	@Override
	public void initFrame()
	{
		this.frames_2d_array = new FrameS[][]
		{
			{
				new FrameSleFLoopDie(this, 0),
				new FrameSTLoopFBSit(this, 2),
				new FrameSleFLoopOffSetAttackEndWalk(this, 4),
				new FrameSleShoot(this, 7),
				new FrameSleTLoopAttackWalk(this, 12),
				new FrameSleTLoopWalk(this, 14),
				new FrameSleFLoopFreePE(this, 16),
				new FrameSFLoopFreeHardReady(this, 18),
				new FrameSFLoopFreeSoftReady(this, 20),
				new FrameSleFLoopAttackStand(this, 22),
				new FrameSTLoop(this, 24)
			}
		};
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
