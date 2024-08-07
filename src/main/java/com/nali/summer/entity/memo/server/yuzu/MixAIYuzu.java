package com.nali.summer.entity.memo.server.yuzu;

import com.nali.list.entity.SummerE22Locker;
import com.nali.list.entity.ai.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIEInv;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaYuzu;

public class MixAIYuzu<SD extends ISoundDaLe, BD extends BothDaYuzu<SD>, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, S extends ServerSleInv<SD, BD, E, I, ?>> extends MixAIEInv<SD, BD, E, I, S>
{
    public static byte[] AI_BYTE_ARRAY =
    {
        AIEInvLockInv.ID,
        AILeLockDMG.ID,
        AILeMineTo.ID,
        AILeWalkTo.ID,
        AILeUseTo.ID,
        AIESit.ID,
        AILeSetLocation.ID,
        AILeFollow.ID,
        AILeRevive.ID,
        AILePlayWithSSe.ID,//Play+1
        AILeCareOwner.ID,
        AILeAttack.ID,
        AILeInvManageItem.ID,
        AILeInvGetItem.ID,
        AILeRandomWalk.ID,
        AILeLookTo.ID,
        AILeRandomLook.ID
    };

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        649,
        650,
        651
    };

    public MixAIYuzu(S s)
    {
        super(s);
    }

    @Override
    public void init()
    {
        super.init();
        ((AILePlayWithSSe)this.s.a.aie_map.get(AILePlayWithSSe.ID)).e2_class = SummerE22Locker.class;

        AILeAttack<SD, BD, E, I, S, ?> aileattack = (AILeAttack<SD, BD, E, I, S, ?>)this.s.a.aie_map.get(AILeAttack.ID);
        aileattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        aileattack.max_magic_point = 4;
        aileattack.minimum_distance = 10.0F;
    }
}
