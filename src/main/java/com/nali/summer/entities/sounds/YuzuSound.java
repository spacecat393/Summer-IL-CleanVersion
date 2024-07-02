package com.nali.summer.entities.sounds;

import com.nali.sound.ISoundLe;
import net.minecraft.server.MinecraftServer;

import static com.nali.list.data.SummerData.OPENAL_STEP;

public class YuzuSound implements ISoundLe
{
    @Override
    public int HURT()
    {
//        byte time;
//        if (FMLLaunchHandler.side() == Side.SERVER)
//        {
//            time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
//        }
//        else
//        {
//            time = (byte)(Minecraft.getSystemTime() % 255);
//        }
        byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);

        if (time > 85)
        {
            return OPENAL_STEP + 2;
        }
        else if (time > -85)
        {
            return OPENAL_STEP + 3;
        }
        else
        {
            return OPENAL_STEP + 4;
        }
    }

    @Override
    public int DEATH()
    {
//        byte time;
//        if (FMLLaunchHandler.side() == Side.SERVER)
//        {
//            time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
//        }
//        else
//        {
//            time = (byte)(Minecraft.getSystemTime() % 255);
//        }
        byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);

        if (time > 85)
        {
            return OPENAL_STEP + 11;
        }
        else
        {
            return OPENAL_STEP + 10;
        }
    }

    @Override
    public int PAT()
    {
//        byte time;
//        if (FMLLaunchHandler.side() == Side.SERVER)
//        {
//            time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);
//        }
//        else
//        {
//            time = (byte)(Minecraft.getSystemTime() % 255);
//        }
        byte time = (byte)(MinecraftServer.getCurrentTimeMillis() % 255);

        if (time > 85)
        {
            return OPENAL_STEP + 7;
        }
        else
        {
            return OPENAL_STEP + 8;
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
        return OPENAL_STEP + 12;
    }
}