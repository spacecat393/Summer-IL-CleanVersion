package com.nali.list.da;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;
import com.nali.da.IBothDaSe;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaE22Locker implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe
{
	public static BothDaE22Locker IDA;

	@Override
	public float E_Width()
	{
		return 0.8F;
	}

	@Override
	public float E_Height()
	{
		return 1.5F;
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
//			4 +//rotation_yaw_head
			1 +//inv
			this.S_MaxFrame() * 2
		);
	}

	@Override
	public int O_StartPart()
	{
		return MODEL_STEP + 90;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 97;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 9;
	}

	@Override
	public byte Se_SyncIndex()
	{
		return
			4 +
//			4 +
			1;
	}
}
