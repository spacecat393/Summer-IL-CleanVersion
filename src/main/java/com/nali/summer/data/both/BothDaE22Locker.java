package com.nali.summer.data.both;

import com.nali.data.IBothDaSn;

public class BothDaE22Locker implements IBothDaSn
{
    public static BothDaE22Locker IBOTHDASN = new BothDaE22Locker();

    public static byte MAX_FRAME = 1;

    @Override
    public byte MaxFrame()
    {
        return MAX_FRAME;
    }
}
