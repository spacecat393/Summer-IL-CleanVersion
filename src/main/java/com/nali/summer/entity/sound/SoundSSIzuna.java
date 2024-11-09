package com.nali.summer.entity.sound;

import com.nali.sound.Sound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SoundSSIzuna extends Sound
{
	@Override
	public int getSoundBuffer(byte b)
	{
		return -1;
	}
}
