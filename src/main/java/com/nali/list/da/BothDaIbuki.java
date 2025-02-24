package com.nali.list.da;

import com.nali.da.*;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaIbuki implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe, IBothDaNe
{
	public static BothDaIbuki IDA;

	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		297, 347, 347-297+2,
		348, 431,
		474, 486,//start attack
		1265, 1281,//loop move
		1282, 1312,//end move
		263, 296,//cafe walk
		585, 622,
		101, 262,
		432, 473,
		0, 100,
		487, 517,
		518, 528,
		529, 584,
		623, 656,// 13 start ride
		1214, 1264,// 14 loop ride
		657, 707,// 15 loop ride-move
		878, 919,// 16 end ride-move
		1163, 1213,// 17 ride-panic
		827, 877,// 18 ride-destroy
		708, 724,// 19 start ride-attack
		725, 758,// 20 loop ride-attack
		759, 775,// 21 end ride-attack
		776, 826// 22 ride-reload
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
		return MODEL_STEP + 116;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 131;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 12;
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
