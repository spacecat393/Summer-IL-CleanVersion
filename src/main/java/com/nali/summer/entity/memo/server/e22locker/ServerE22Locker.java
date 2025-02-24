package com.nali.summer.entity.memo.server.e22locker;

import com.nali.da.IBothDaE;
import com.nali.small.entity.EntityE;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerE;
import com.nali.small.entity.memo.server.si.MixSIE;
import com.nali.small.entity.memo.server.si.SIData;
import com.nali.small.entity.memo.server.si.frame.KeyS;
import com.nali.small.entity.memo.server.si.frame.floop.KeySFLoopRSeStand;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeRSePlay;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySTLoop;

public class ServerE22Locker
<
	BD extends IBothDaE,
	E extends EntityE,
	I extends IMixE<BD, E>,
	MS extends MixSIE<BD, E, I, ?>
> extends ServerE<BD, E, I, MS> implements IServerS
{
	public static byte[] KEY_DATA_BYTE_ARRAY = new byte[]
	{
		0, 0*2,
		0, 2*2,
		0, 1*2
	};
	public KeyS[][] keys_2d_array;

	public ServerE22Locker(I i)
	{
		super(i);
	}

	@Override
	public void writeFile(SIData siData)
	{
	}

	@Override
	public void readFile(SIData siData)
	{
	}

	@Override
	public void initFile()
	{
	}

	@Override
	public void initKey()
	{
		this.keys_2d_array = new KeyS[][]
		{
			{
				new KeySFLoopFreeRSePlay(this, (byte)0),
				new KeySFLoopRSeStand(this, (byte)2),
				new KeySTLoop(this, (byte)4)
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
	public KeyS[][] getKeyS2DArray()
	{
		return this.keys_2d_array;
	}

	@Override
	public byte[] getKeyDataByteArray()
	{
		return KEY_DATA_BYTE_ARRAY;
	}

//	@Override
//	public short[] getFixKeyShortArray()
//	{
//		return FIX_KEY_SHORT_ARRAY;
//	}
}
