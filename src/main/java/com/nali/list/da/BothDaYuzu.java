package com.nali.list.da;

import com.nali.da.*;
import net.minecraft.server.MinecraftServer;

import static com.nali.list.data.SummerData.*;
import static com.nali.list.data.SummerData.SOUND_STEP;

public class BothDaYuzu implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe, IBothDaNe
{
	public static BothDaYuzu IDA;

	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		717, 767,
		526, 592,
		627, 643,
		844, 859,
		860, 893,
		113, 143,
		806, 843,
		34, 112,
		593, 626,
		0, 33,
		644, 664,
		703, 716,
		768, 805,
		665, 702,//delay attack
		144, 441,//locker react
		442, 525//locker idle
	};

	@Override
	public float E_Width()
	{
		return 0.3F;
	}

	@Override
	public float E_Height()
	{
		return 0.95F;
	}

	@Override
	public float E_Scale()
	{
		return 1.5F;
	}

	@Override
	public byte E_MaxSync()
	{
		return (byte)
		(
			4 +//scale
			4 +//rotation_yaw_head
			this.S_MaxFrame() * (4 + 1)
		);
	}

	@Override
	public int O_StartPart()
	{
		return MODEL_STEP + 98;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 107;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 10;
	}

	@Override
	public short[] S_FixKeyShortArray()
	{
		return FIX_KEY_SHORT_ARRAY;
	}

	@Override
	public byte Se_SyncIndex()
	{
		return
			4 +
			4;
	}

	@Override
	public int Ne_EAT()
	{
		byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
		return this.getDefault(time);
	}

	@Override
	public int Ne_HURT()
	{
		byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
		if (time > 85)
		{
			return SOUND_STEP + 2;
		}
		else if (time > -85)
		{
			return SOUND_STEP + 3;
		}
		else
		{
			return SOUND_STEP + 4;
		}
	}

	@Override
	public int Ne_DEATH()
	{
		byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
		if (time > 85)
		{
			return SOUND_STEP + 11;
		}
		else
		{
			return SOUND_STEP + 10;
		}
	}

	@Override
	public int Ne_PAT()
	{
		byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
		return this.getDefault(time);
	}

	@Override
	public int Ne_SOFT_READY()
	{
		byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
		return this.getDefault(time);
	}

	@Override
	public int Ne_HARD_READY()
	{
		return SOUND_STEP + 12;
	}

	public int getDefault(byte time)
	{
		if (time > 85)
		{
			return SOUND_STEP + 7;
		}
		else
		{
			return SOUND_STEP + 8;
		}
	}
}
