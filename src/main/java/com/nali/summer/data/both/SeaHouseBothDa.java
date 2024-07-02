package com.nali.summer.data.both;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;

public class SeaHouseBothDa implements IBothDaSn, IBothDaNe
{
    public static SeaHouseBothDa IBOTHDASN = new SeaHouseBothDa();

    public static byte MAX_FRAME = 1;
    public static byte MAX_SYNC = 1;

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
    public byte MaxFrame()
    {
        return MAX_FRAME;
    }

    @Override
    public byte MaxSync()
    {
        return MAX_SYNC;
    }
}
