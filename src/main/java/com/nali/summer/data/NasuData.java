package com.nali.summer.data;

import com.nali.data.BothData;

public class NasuData implements BothData
{
    public static int MAX_FRAME = 1;

    @Override
    public int MaxPart()
    {
        return 12;
    }

    @Override
    public int StepModels()
    {
        return 15;
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
    public int MaxFrame()
    {
        return MAX_FRAME;
    }
}
