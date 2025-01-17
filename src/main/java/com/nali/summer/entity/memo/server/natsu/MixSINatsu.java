package com.nali.summer.entity.memo.server.natsu;

import com.nali.da.IBothDaE;
import com.nali.list.entity.si.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIEInv;
import com.nali.small.entity.memo.server.si.SI;
import com.nali.small.entity.memo.server.si.SILeLook;
import com.nali.small.entity.memo.server.si.path.SILeFindMove;
import com.nali.small.entity.memo.server.si.path.SILeMineTo;

public class MixSINatsu
<
	IE extends InvLe,
	BD extends IBothDaE,
	E extends EntityLeInv,
	I extends IMixE<BD, E>,
	S extends ServerLeInv<IE, BD, E, I, ?>
> extends MixSIEInv<BD, E, I, S>
{
	public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
	{
		473,
		476,
		478,
		480,
		482,
		486
	};
	public static int[] HEAL_FRAME_INT_ARRAY = new int[]
	{
		620
	};

	public MixSINatsu(S s)
	{
		super(s, new SI[]
		{
			new SIESound(s),

			new SIEArea(s),
			new SIEOwner(s),
			new SILeEat(s),

			new SIEPat(s),

			new SIEInvLockInv(s),
			new SILeLockDMG(s),
			new SILeMineTo(s),
			new SILeUseTo(s),
			new SIESit(s),
			new SIESetLocation(s),
			new SILeFollow(s),
			new SILeRevive(s),
			new SILeHeal(s),
			new SILeCareOwner(s),
			new SILeAttack(s),
			new SILeInvManageItem(s),
			new SILeInvGetItem(s),
			new SILeRandomWalk(s),
			new SILeLookTo(s),
			new SILeRandomLook(s),

			new SIEKey(s),

			new SILeFindMove(s),
			new SIEWalkTo(s),
			new SILeLook(s),
		});
	}

	@Override
	public void init()
	{
		super.init();
		SILeAttack<BD, E, I, S, ?> sileattack = (SILeAttack<BD, E, I, S, ?>)this.s.ms.si_map.get(SILeAttack.ID);
		sileattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
//		sileattack.max_magic_point = 16;
		sileattack.minimum_distance = 8.0F;

		((SILeHeal<BD, E, I, S, ?>)this.s.ms.si_map.get(SILeHeal.ID)).heal_frame_int_array = HEAL_FRAME_INT_ARRAY;
	}
}
