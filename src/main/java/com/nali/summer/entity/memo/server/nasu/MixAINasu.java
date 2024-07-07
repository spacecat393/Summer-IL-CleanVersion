package com.nali.summer.entity.memo.server.nasu;

import com.nali.list.entity.ai.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIEInv;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaNasu;

public class MixAINasu<SD extends ISoundDaLe, BD extends BothDaNasu<SD>, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, S extends ServerSleInv<SD, BD, E, I, ?>> extends MixAIEInv<SD, BD, E, I, S>
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
        AILeHeal.ID,
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
        698,
        701,
        703,
        707,
        711
    };
    public static int[] HEAL_FRAME_INT_ARRAY = new int[]
    {
        868
    };

    public MixAINasu(S s)
    {
        super(s);
    }

    @Override
    public void init()
    {
        AILeAttack<SD, BD, E, I, S, ?> aileattack = (AILeAttack<SD, BD, E, I, S, ?>)this.s.a.aie_map.get(AILeAttack.ID);
        aileattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
//        aileattack.max_magic_point = 16;
        aileattack.minimum_distance = 8.0F;

        ((AILeHeal<SD, BD, E, I, S, ?>)this.s.a.aie_map.get(AILeHeal.ID)).heal_frame_int_array = HEAL_FRAME_INT_ARRAY;
    }
}
