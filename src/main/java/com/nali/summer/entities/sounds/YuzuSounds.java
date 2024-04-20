package com.nali.summer.entities.sounds;

import com.nali.small.entities.sounds.Sounds;
import net.minecraft.client.Minecraft;

public class YuzuSounds implements Sounds
{
    @Override
    public int HURT()
    {
        byte time = (byte)(Minecraft.getSystemTime() % 255);

        if (time > 127)
        {
            return 2;
        }
        else if (time > 85)
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }

    @Override
    public int DEATH()
    {
        byte time = (byte)(Minecraft.getSystemTime() % 255);

        if (time > 127)
        {
            return 11;
        }
        else
        {
            return 10;
        }
    }

    @Override
    public int PAT()
    {
        byte time = (byte)(Minecraft.getSystemTime() % 255);

        if (time > 127)
        {
            return 7;
        }
        else
        {
            return 8;
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
        return 12;
    }
}