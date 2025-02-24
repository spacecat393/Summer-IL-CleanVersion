package com.nali.list.da;

import com.nali.da.*;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaNatsu implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe, IBothDaNe
{
	public static BothDaNatsu IDA;

	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		537, 592,//Vital_Death
		225, 307,//Formation_Idle
		426, 438,//Attack_Start
		380, 400,//Move_Ing
		401, 425,//End_Normal
		184, 224,//Cafe_Walk
		308, 346,//Callsign
		67, 183,//Cafe_Reaction
		347, 379,//Normal_Idle
		0, 66,//Cafe_Idle
		439, 487,//Attack_Delay-Attack_Ing
		488, 498,//Attack_End
		499, 535,//Normal_Reload
		593, 638//Public
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
		return MODEL_STEP + 14;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 26;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 1;
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
