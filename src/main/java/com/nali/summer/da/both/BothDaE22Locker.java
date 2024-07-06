package com.nali.summer.da.both;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;

public class BothDaE22Locker implements IBothDaSn, IBothDaNe
{
    public static BothDaE22Locker IBOTHDASN = new BothDaE22Locker();

    public static byte MAX_FRAME = 1;
    public static byte MAX_SYNC = 0;

    @Override
    public byte MaxFrame()
    {
        return MAX_FRAME;
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
    public byte MaxSync()
    {
        return MAX_SYNC;
    }
}
