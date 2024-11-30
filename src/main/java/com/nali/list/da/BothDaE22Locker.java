package com.nali.list.da;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaE22Locker implements IBothDaE, IBothDaO, IBothDaS
{
	public static BothDaE22Locker IDA = new BothDaE22Locker();

	public static byte MAX_FRAME = 1;
	public static byte MAX_SYNC = 0;

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
		return MAX_SYNC;
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
		return MAX_FRAME;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 9;
	}
}