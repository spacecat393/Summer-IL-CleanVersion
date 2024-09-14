package com.nali.summer.entity.memo.server.e22locker;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.small.entity.EntityE;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvE;
import com.nali.small.entity.memo.IBothEInv;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerE;
import com.nali.small.entity.memo.server.si.MixSIE;
import com.nali.small.entity.memo.server.si.frame.FrameS;
import com.nali.small.entity.memo.server.si.frame.floop.FrameSFLoopRSeStand;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSFLoopFreeRSePlay;
import com.nali.small.entity.memo.server.si.frame.tloop.FrameSTLoop;

public class ServerE22Locker
<
	IE extends InvE,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityE,
	I extends IMixE<BD, E>,
	MS extends MixSIE<BD, E, I, ?>
> extends ServerE<BD, E, I, MS> implements IBothEInv<IE>, IServerS
{
	public IE ie;

	public static int[][] FRAME_INT_2D_ARRAY = new int[][]
	{
		{ 0, 297 },//react
		{ 298, 302 },//noact
		{ 303, 386 }//idle
	};
	public static byte[] FRAME_BYTE_ARRAY = new byte[]
	{
		0, 0,
		0, 2,
		0, 1
	};
	public FrameS[][] frames_2d_array;

	public ServerE22Locker(I i)
	{
		super(i);
	}

	@Override
	public void initFrame()
	{
		this.frames_2d_array = new FrameS[][]
		{
			{
				new FrameSFLoopFreeRSePlay(this, 0),
				new FrameSFLoopRSeStand(this, 2),
				new FrameSTLoop(this, 4)
			}
		};
//		() -> serverentitiesmemory.skinningentities != null && (serverentitiesmemory.statentitiesmemory.stat & 16) == 16 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(0, (byte)16),
//		() -> serverentitiesmemory.skinningentities != null && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(2),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1)
	}

	@Override
	public void updateServer()
	{
//		if (serverentitiesmemory.skinningentities != null && this.worldserver.getEntityFromUuid(serverentitiesmemory.skinningentities.getUniqueID()) == null)
//		{
//			serverentitiesmemory.skinningentities = null;
//		}
//
//		this.renderYawOffset = this.rotationYaw;
	}

//	@Override
//	public boolean processInitialInteract(EntityPlayer entityplayer, EnumHand enumhand)
//	{
//		serverentitiesmemory.statentitiesmemory.stat ^= 16;
//		return super.processInitialInteract(entityplayer, enumhand);
//	}

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
	public IE getIE()
	{
		return this.ie;
	}
}
