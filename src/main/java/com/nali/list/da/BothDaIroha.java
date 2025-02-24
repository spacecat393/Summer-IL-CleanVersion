package com.nali.list.da;

import com.nali.da.*;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaIroha implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe, IBothDaNe
{
	public static BothDaIroha IDA;

	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		321, 371,
		635, 685,
		516, 532,//start attack
		423, 473,//loop move
		474, 515,//end move
		143, 206,//cafe walk
		51, 142,
		258, 320,
		207, 257,
		372, 422,// 9 n-idle
		0, 50,
		533, 566,
		567, 583,
		584, 634,
		686, 719,// 14 start ride
		720, 770,// 15 loop ride
		1034, 1084,// 16 loop ride-move
		941, 982,// 17 end ride-move
		983, 1033,// 18 ride-panic
		890, 940,// 19 ride-destroy
		771, 787,// 20 start ride-attack
		788, 821,// 21 loop ride-attack
		822, 838,// 22 end ride-attack
		839, 889// 23 ride-reload
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
		return MODEL_STEP + 131;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 142;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 13;
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
