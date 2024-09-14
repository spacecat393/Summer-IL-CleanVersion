package com.nali.summer.entity.sound;

import com.nali.sound.ISoundDaLe;

public class SoundDaSaori implements ISoundDaLe
{
	public static ISoundDaLe ISOUNDDALE = new SoundDaSaori();

	@Override
	public int EAT()
	{
		return -1;
	}

	@Override
	public int HURT()
	{
		return -1;
	}

	@Override
	public int DEATH()
	{
		return -1;
	}

	@Override
	public int PAT()
	{
		return -1;
	}

	@Override
	public int SOFT_READY()
	{
		return -1;
	}

	@Override
	public int HARD_READY()
	{
		return -1;
	}
}
