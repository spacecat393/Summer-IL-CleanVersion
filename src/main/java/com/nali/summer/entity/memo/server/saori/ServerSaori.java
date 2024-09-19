package com.nali.summer.entity.memo.server.saori;

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
import com.nali.small.entity.memo.server.si.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSleFLoopFreePSrE;
import com.nali.small.entity.memo.server.si.frame.floopoffset.FrameSleFLoopOffSetAttackEndWalk;
import com.nali.small.entity.memo.server.si.frame.shoot.FrameSleShootAttackPlus;
import com.nali.small.entity.memo.server.si.frame.tloop.*;
import com.nali.sound.ISoundDaLe;

public class ServerSaori
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
		{ 890, 942 },
		{ 492, 592 },
		{ 688, 704 },//2 start attack
		{ 593, 608 },
		{ 609, 646 },
		{ 358, 491 },
		{ 943, 979 },
		{ 241, 357 },
		{ 647, 687 },
		{ 0, 240 },
		{ 705, 723 },//10 loop attack
		{ 724, 742 },//11 end attack
		{ 743, 788 },//12 reload
		{ 789, 889 }//13 skill
	//			{ 980, 1013 }//delay attack
	};
	public static byte[] FRAME_BYTE_ARRAY = new byte[]
	{
		0, 0, //0
		0, 1, //2
		0, 3, 4, //4
		0, 2, 2, 10, 13, 11, 12, //7 frameId size startAttack (loop skill) end reload
		0, 3, //14
		0, 5, //16
		0, 6, //18
		0, 7, //20
		0, 8, //22
		0, 9 //24
	};
	public FrameS[][] frames_2d_array;

	//	public boolean server_how_attack;
	public ServerSaori(I i)
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
				new FrameSleShootAttackPlus(this, 7),
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
//		() ->
//		{
//			int id = 10;
//			int start_id = 2;
//
//			if (serverentitiesmemory.server_how_attack)
//			{
//				id = 13;
//				start_id = 13;
//
//				if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][1] - 1)
//				{
//					start_id = 2;
//					id = 10;
//					serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] = serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[2][0];
//					serverentitiesmemory.server_how_attack = false;
//				}
//			}
//
//			if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][1] - 1)
//			{
//				serverentitiesmemory.server_how_attack = (byte)(this.ticksExisted % 20) == 0;
//			}
//
//			return serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setShoot(start_id, id, 11, 12, false, serverentitiesmemory.entitiesaimemory.skinningentitiesattack);
//		},
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
