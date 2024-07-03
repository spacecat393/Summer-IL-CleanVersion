package com.nali.summer.data.both;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaNs;
import com.nali.data.IBothDaSn;
import com.nali.sound.ISoundLe;
import com.nali.summer.entity.sounds.SoundAris;

public class BothDaAris<SD extends ISoundLe> extends IBothDaNs<SD> implements IBothDaSn, IBothDaNe
{
//    public static ISoundLe ISOUNDLE = new ArisSound();
    public static BothDaAris IBOTHDASN = new BothDaAris(SoundAris.ISOUNDLE);

    public static byte MAX_FRAME = 1;
    public static byte MAX_SYNC = 1;

    public BothDaAris(SD sd)
    {
        super(sd);
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
