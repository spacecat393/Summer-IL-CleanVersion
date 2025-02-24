package com.nali.list.da;

import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaSeaHouse implements IBothDaS, IBothDaO
{
	public static BothDaSeaHouse IDA;

	@Override
	public int O_StartPart()
	{
		return MODEL_STEP + 35;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 38;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 3;
	}

	@Override
	public short[] S_FixKeyShortArray()
	{
		return null;
	}
}
