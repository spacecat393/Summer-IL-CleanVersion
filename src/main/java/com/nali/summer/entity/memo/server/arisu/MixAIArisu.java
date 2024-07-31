package com.nali.summer.entity.memo.server.arisu;

import com.nali.list.entity.ai.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIEInv;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaArisu;

public class MixAIArisu<SD extends ISoundDaLe, BD extends BothDaArisu<SD>, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, S extends ServerSleInv<SD, BD, E, I, ?>> extends MixAIEInv<SD, BD, E, I, S>
{
    public static byte[] AI_BYTE_ARRAY =
    {
        AIEArea.ID,
        AIEOwner.ID,
        AIEInvOpenInv.ID,
        AILeEat.ID,

        AIEPat.ID,

        AIEInvLockInv.ID,
        AILeLockDMG.ID,
        AILeMineTo.ID,
//        AILeWalkTo.ID,
        AILeUseTo.ID,
        AIESit.ID,
        AILeSetLocation.ID,
        AILeFollow.ID,
        AILeRevive.ID,
        AILeCareOwner.ID,
        AILeAttack.ID,
        AILeInvManageItem.ID,
        AILeInvGetItem.ID,
        AILeRandomWalk.ID,
        AILeLookTo.ID,
        AILeRandomLook.ID,

        //frame

        AILeFindMove.ID,
        AILeMove.ID,
        AILeWalkTo.ID,
        AILeLook.ID,
        AILeJump.ID
    };

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        603,
        650
    };

    public MixAIArisu(S s)
    {
        super(s);
    }

    @Override
    public void init()
    {
        super.init();
        AILeAttack<SD, BD, E, I, S, ?> aileattack = (AILeAttack<SD, BD, E, I, S, ?>)this.s.a.aie_map.get(AILeAttack.ID);
        aileattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        aileattack.max_magic_point = 2;
        aileattack.minimum_distance = 48.0F;
    }
}
