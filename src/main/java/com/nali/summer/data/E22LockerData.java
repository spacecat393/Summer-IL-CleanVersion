package com.nali.summer.data;

import com.nali.data.BothData;

public class E22LockerData implements BothData
{
    public static int MAX_FRAME = 1;
    public static int MAX_SYNC = 1;

    @Override
    public int MaxPart()
    {
        return 7+1;
    }

    @Override
    public int StepModels()
    {
        return 100-1;
    }

    @Override
    public float Width()
    {
        return 0.8F;
    }

    @Override
    public float Height()
    {
        return 1.5F;
    }

    @Override
    public float Scale()
    {
        return 1.5F;
    }

    @Override
    public int MaxFrame()
    {
        return MAX_FRAME;
    }

    @Override
    public int MaxSync()
    {
        return MAX_SYNC;
    }
}
