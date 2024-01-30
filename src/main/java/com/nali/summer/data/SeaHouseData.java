package com.nali.summer.data;

import com.nali.data.BothData;

public class SeaHouseData implements BothData
{
    public static int MAX_FRAME = 1;

    @Override
    public int MaxPart()
    {
        return 3;
    }

    @Override
    public int StepModels()
    {
        return 38;
    }

    @Override
    public float Width()
    {
        return -1.0F;
    }

    @Override
    public float Height()
    {
        return -1.0F;
    }

    @Override
    public float Scale()
    {
        return -1.0F;
    }

    @Override
    public int MaxFrame()
    {
        return MAX_FRAME;
    }
}
