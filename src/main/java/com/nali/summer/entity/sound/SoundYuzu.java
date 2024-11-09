package com.nali.summer.entity.sound;

import com.nali.small.entity.EntityRefSound;
import com.nali.sound.Sound;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.SOUND_STEP;

@SideOnly(Side.CLIENT)
public class SoundYuzu extends Sound
{
	@Override
	public int getSoundBuffer(byte b)
	{
		byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
		switch (b)
		{
			case EntityRefSound.EAT:
			case EntityRefSound.PAT:
			case EntityRefSound.SOFT_READY:
				return this.getDefault(time);
			case EntityRefSound.HURT:
				if (time > 85)
				{
					return SOUND_STEP + 2;
				}
				else if (time > -85)
				{
					return SOUND_STEP + 3;
				}
				else
				{
					return SOUND_STEP + 4;
				}
			case EntityRefSound.DEATH:
				if (time > 85)
				{
					return SOUND_STEP + 11;
				}
				else
				{
					return SOUND_STEP + 10;
				}
			case EntityRefSound.HARD_READY:
				return SOUND_STEP + 12;
		}
		return -1;
	}

	public int getDefault(byte time)
	{
		if (time > 85)
		{
			return SOUND_STEP + 7;
		}
		else
		{
			return SOUND_STEP + 8;
		}
	}
}
