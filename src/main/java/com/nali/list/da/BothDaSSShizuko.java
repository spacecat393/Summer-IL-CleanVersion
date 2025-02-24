package com.nali.list.da;

import com.nali.da.*;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaSSShizuko implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe, IBothDaNe
{
	public static BothDaSSShizuko IDA;

	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		0, 222,// 0 cafe idle <- need frame
		0, 222,// 1 cafe idle
		381, 481,// 2 cafe walk
		482, 532,// 3 t-start 50
		223, 380,// 4 cafe react
		0, 222, // 5 cafe idle
		533, 610,// 6 spawn
		611, 704,// 7 idle
		705, 725,// 8 act
		726, 750,// 9 end

		//SeaHouse
		0, 50, // 10
		0, 0, // 11
		51, 128,// 12 spawn
		129, 222,// 13 idle
		223, 243,// 14 act
		244, 269// 15 end
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
		return MODEL_STEP + 38;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 50;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 4;
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
		return -1;
	}

	@Override
	public int Ne_HURT()
	{
		return -1;
	}

	@Override
	public int Ne_DEATH()
	{
		return -1;
	}

	@Override
	public int Ne_PAT()
	{
		return -1;
	}

	@Override
	public int Ne_SOFT_READY()
	{
		return -1;
	}

	@Override
	public int Ne_HARD_READY()
	{
		return -1;
	}
}
