package com.nali.list.da;

import com.nali.da.*;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaSSHifumi implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe, IBothDaNe
{
	public static BothDaSSHifumi IDA;

	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		482, 523,//Tank_Vital_Destroy*
		450, 481,//Tank_Vital_Retreat*
		118, 133,//Attack_Start*
		340, 389,//Tank_Move_Ing*
		390, 449,//Tank_Move_End*
		699, 732,//Cafe_Walk*
		616, 698,//Cafe_Reaction*
		0, 66,//Tank_Appearance*
		733, 783,//Tactical_Start*
		67, 117,//Attack_Delay*
		575, 615,//Cafe_Idle*
		134, 167,//Attack_Ing*
		168, 184,//Attack_End*
		289, 339//Normal_Reload*
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
		return MODEL_STEP/* + 0*//* + 2*/;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 14/* - 11*/;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP/* + 0*/;
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
