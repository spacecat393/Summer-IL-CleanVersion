package com.nali.list.da;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaNE;
import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;

import static com.nali.list.data.SummerData.FRAME_STEP;
import static com.nali.list.data.SummerData.MODEL_STEP;

public class BothDaSaori implements IBothDaE, IBothDaO, IBothDaS, IBothDaNE
{
	public static BothDaSaori IDA = new BothDaSaori();

	@Override
	public float E_Width()
	{
		return 0.3F;
	}

	@Override
	public float E_Height()
	{
		return 0.85F;
	}

	@Override
	public float E_Scale()
	{
		return 1.5F;
	}

	@Override
	public byte E_MaxSync()
	{
		return 1;
	}

	@Override
	public int O_StartPart()
	{
		return MODEL_STEP + 106;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 115;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 11;
	}

	@Override
	public int NE_EAT()
	{
		return -1;
	}

	@Override
	public int NE_HURT()
	{
		return -1;
	}

	@Override
	public int NE_DEATH()
	{
		return -1;
	}

	@Override
	public int NE_PAT()
	{
		return -1;
	}

	@Override
	public int NE_SOFT_READY()
	{
		return -1;
	}

	@Override
	public int NE_HARD_READY()
	{
		return -1;
	}
}
