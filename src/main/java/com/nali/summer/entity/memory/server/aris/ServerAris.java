package com.nali.summer.entity.memory.server.aris;

import com.nali.data.IBothDaNe;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.sound.ISoundLe;

public class ServerAris<SD extends ISoundLe, BD extends IBothDaNe, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIE<SD, BD, E, I, ?>> extends ServerLeInv<SD, BD, E, I, A>
{
    public ServerAris(I i, Inventory inventory)
    {
        super(i, inventory);
    }

    @Override
    public void updateServer()
    {

    }
}
