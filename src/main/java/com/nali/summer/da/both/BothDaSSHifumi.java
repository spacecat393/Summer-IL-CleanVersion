package com.nali.summer.da.both;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaNs;
import com.nali.da.IBothDaSn;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.entity.sound.SoundDaSSHifumi;

public class BothDaSSHifumi<SD extends ISoundDaLe> extends IBothDaNs<SD> implements IBothDaSn, IBothDaNe
{
//	public static ISoundDaLe ISOUNDDALE = new SSHimiSound();
	public static BothDaSSHifumi IBOTHDASN = new BothDaSSHifumi(SoundDaSSHifumi.ISOUNDDALE);

	public static byte MAX_FRAME = 1;
	public static byte MAX_SYNC = 1;

	public BothDaSSHifumi(SD sd)
	{
		super(sd);
	}

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
