package com.nali.summer.data.both;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;

public class E22LockerBothDa implements IBothDaSn, IBothDaNe
{
    public static E22LockerBothDa IBOTHDASN = new E22LockerBothDa();

    public static byte MAX_FRAME = 1;
    public static byte MAX_SYNC = 1;

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
