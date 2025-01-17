package com.nali.summer.entity.memo.server.arisu;

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

public class MixSIArisu
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
		436
	};

	public MixSIArisu(S s)
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
		sileattack.max_magic_point = 2;
		sileattack.minimum_distance = 48.0F;

		SIESound<BD, E, I, S, ?> siesound = (SIESound<BD, E, I, S, ?>)this.s.ms.si_map.get(SIESound.ID);
		siesound.state |= 1;
	}
}
