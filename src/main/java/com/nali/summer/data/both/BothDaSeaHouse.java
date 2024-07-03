package com.nali.summer.data.both;

import com.nali.data.IBothDaSn;

public class BothDaSeaHouse implements IBothDaSn
{
    public static BothDaSeaHouse IBOTHDASN = new BothDaSeaHouse();

    public static byte MAX_FRAME = 1;

    @Override
    public byte MaxFrame()
    {
        return MAX_FRAME;
    }
}
