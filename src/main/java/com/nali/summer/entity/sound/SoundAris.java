package com.nali.summer.entity.sound;

import com.nali.sound.ISoundLe;

public class SoundAris implements ISoundLe
{
    public static ISoundLe ISOUNDLE = new SoundAris();

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