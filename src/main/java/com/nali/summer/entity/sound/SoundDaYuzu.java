package com.nali.summer.entity.sound;

import com.nali.sound.ISoundDaLe;
import net.minecraft.server.MinecraftServer;

import static com.nali.list.data.SummerData.SOUND_STEP;

public class SoundDaYuzu implements ISoundDaLe
{
	public static ISoundDaLe ISOUNDDALE = new SoundDaYuzu();

	@Override
	public int HURT()
	{
//		byte time;
//		if (FMLLaunchHandler.side() == Side.SERVER)
//		{
//			time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
//		}
//		else
//		{
//			time = (byte)(Minecraft.getSystemTime() % 255);
//		}
		byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);

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
	}

	@Override
	public int DEATH()
	{
//		byte time;
//		if (FMLLaunchHandler.side() == Side.SERVER)
//		{
//			time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
//		}
//		else
//		{
//			time = (byte)(Minecraft.getSystemTime() % 255);
//		}
		byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);

		if (time > 85)
		{
			return SOUND_STEP + 11;
		}
		else
		{
			return SOUND_STEP + 10;
		}
	}

	@Override
	public int PAT()
	{
//		byte time;
//		if (FMLLaunchHandler.side() == Side.SERVER)
//		{
//			time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
//		}
//		else
//		{
//			time = (byte)(Minecraft.getSystemTime() % 255);
//		}
		byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);

		if (time > 85)
		{
			return SOUND_STEP + 7;
		}
		else
		{
			return SOUND_STEP + 8;
		}
	}

	@Override
	public int SOFT_READY()
	{
		return this.PAT();
	}

	@Override
	public int HARD_READY()
	{
		return SOUND_STEP + 12;
	}
}
