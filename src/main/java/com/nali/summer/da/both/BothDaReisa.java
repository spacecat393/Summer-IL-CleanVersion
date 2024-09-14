package com.nali.summer.da.both;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;

public class BothDaReisa implements IBothDaSn, IBothDaNe
{
	public static BothDaReisa IBOTHDASN = new BothDaReisa();

	public static byte MAX_FRAME = 1;
	public static byte MAX_SYNC = 1;

	@Override
	public float Width()
	{
		return 0.3F;
	}

	@Override
	public float Height()
	{
		return 0.85F;
	}

	@Override
	public float Scale()
	{
		return 1.5F;
	}

	@Override
	public byte MaxFrame()
	{
		return MAX_FRAME;
	}

	@Override
	public byte MaxSync()
	{
		return MAX_SYNC;
	}
}
