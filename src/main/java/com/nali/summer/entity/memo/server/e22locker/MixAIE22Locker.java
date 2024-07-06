package com.nali.summer.entity.memo.server.e22locker;

import com.nali.small.entity.EntityEInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.server.ServerSeInv;
import com.nali.small.entity.memo.server.ai.MixAIEInv;
import com.nali.summer.da.both.BothDaE22Locker;

public class MixAIE22Locker<SD, BD extends BothDaE22Locker, E extends EntityEInv, I extends IMixE<SD, BD, E>, S extends ServerSeInv<SD, BD, E, I, ?>> extends MixAIEInv<SD, BD, E, I, S>
{
    public MixAIE22Locker(S s)
    {
        super(s);
    }

    @Override
    public void init()
    {

    }
}
