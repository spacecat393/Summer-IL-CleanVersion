package com.nali.list.da;

import com.nali.da.*;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaArisu implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe, IBothDaNe
{
	public static BothDaArisu IDA;

	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		570, 614,//Vital_Death*
		205, 285,//Formation_Idle*
		394, 409,//Attack_Start*
		640, 655,//Move_Ing*
		656, 706,//Move_End*
		173, 204,//Cafe_Walk*
		286, 322,//Callsign*
		81, 172,//Cafe_Reaction*
		323, 393,//Normal_Idle*
		0, 80,//Cafe_Idle*
		410, 476,//Attack_Ing*
		477, 518,//Attack_Delay-Attack_End*
		519, 569//Reload*
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
			//can't sync and lerp
//			this.S_MaxFrame() * 6//frame(byte) time(short) future_frame(byte) future_time(short)
//			this.S_MaxFrame() * 4//time(short) future_time(short)
		);
	}

	@Override
	public int O_StartPart()
	{
		return MODEL_STEP + 26;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 35;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 2;
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
