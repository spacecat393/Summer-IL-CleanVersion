package com.nali.list.da;

import com.nali.da.*;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaSSHoshino implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe, IBothDaNe
{
	public static BothDaSSHoshino IDA;

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
			1 +//inv
			this.S_MaxFrame() * 2
		);
	}

	@Override
	public int O_StartPart()
	{
		return MODEL_STEP + 69;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 81;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 7;
	}

	@Override
	public byte Se_SyncIndex()
	{
		return
			4 +
			4 +
			1;
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
