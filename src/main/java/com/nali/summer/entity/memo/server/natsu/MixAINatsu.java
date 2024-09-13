package com.nali.summer.entity.memo.server.natsu;

import com.nali.list.entity.ai.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIEInv;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaNatsu;

public class MixAINatsu<SD extends ISoundDaLe, BD extends BothDaNatsu<SD>, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, S extends ServerSleInv<SD, BD, E, I, ?>> extends MixAIEInv<SD, BD, E, I, S>
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
		SILeAttack.ID,
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

	public MixAINatsu(S s)
	{
		super(s);
	}

	@Override
	public void init()
	{
		super.init();
		SILeAttack<SD, BD, E, I, S, ?> sileattack = (SILeAttack<SD, BD, E, I, S, ?>)this.s.a.aie_map.get(SILeAttack.ID);
		sileattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
//		sileattack.max_magic_point = 16;
		sileattack.minimum_distance = 8.0F;

		((AILeHeal<SD, BD, E, I, S, ?>)this.s.a.aie_map.get(AILeHeal.ID)).heal_frame_int_array = HEAL_FRAME_INT_ARRAY;
	}
}
