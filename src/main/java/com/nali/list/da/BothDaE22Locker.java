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

	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		0, 297,//react
		298, 302,//noact
		303, 386//idle
	};

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
			this.S_MaxFrame() * (4 + 1)
		);
	}

	@Override
	public int O_StartPart()
	{
		return MODEL_STEP + 91;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 98;
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
	public short[] S_FixKeyShortArray()
	{
		return FIX_KEY_SHORT_ARRAY;
	}

	@Override
	public byte Se_SyncIndex()
	{
		return
			4;
	}
}
