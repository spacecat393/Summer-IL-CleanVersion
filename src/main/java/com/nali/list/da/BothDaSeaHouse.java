package com.nali.list.da;

import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaSeaHouse implements IBothDaS, IBothDaO
{
	public static BothDaSeaHouse IDA = new BothDaSeaHouse();

	public static byte MAX_FRAME = 1;

	@Override
	public int O_StartPart()
	{
		return MODEL_STEP + 34;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 37;
	}

	@Override
	public byte S_MaxFrame()
	{
		return MAX_FRAME;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 3;
	}
}
