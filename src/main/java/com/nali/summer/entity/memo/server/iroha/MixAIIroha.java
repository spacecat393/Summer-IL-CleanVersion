package com.nali.summer.entity.memo.server.iroha;

import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIEInv;
import com.nali.sound.ISoundLe;
import com.nali.summer.da.both.BothDaIroha;

public class MixAIIroha<SD extends ISoundLe, BD extends BothDaIroha<SD>, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, S extends ServerSleInv<SD, BD, E, I, ?>> extends MixAIEInv<SD, BD, E, I, S>
{
    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        534,
        789
    };

    public MixAIIroha(S s)
    {
        super(s);
    }

    @Override
    public void init()
    {

    }
}
