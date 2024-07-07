package com.nali.summer.da.both;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaNs;
import com.nali.da.IBothDaSn;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.entity.sound.SoundDaResa;

public class BothDaResa<SD extends ISoundDaLe> extends IBothDaNs<SD> implements IBothDaSn, IBothDaNe
{
//    public static ISoundDaLe ISOUNDDALE = new ResaSound();
    public static BothDaResa IBOTHDASN = new BothDaResa(SoundDaResa.ISOUNDDALE);

    public static byte MAX_FRAME = 1;
    public static byte MAX_SYNC = 1;

    public BothDaResa(SD sd)
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
