package com.nali.summer.entity.memo.server.myuzu;

import com.nali.da.IBothDaE;
import com.nali.list.entity.si.*;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.server.ServerLe;
import com.nali.small.entity.memo.server.si.MixSIELock;
import com.nali.small.entity.memo.server.si.SI;
import com.nali.small.entity.memo.server.si.SILeInv;
import com.nali.small.entity.memo.server.si.SILeLook;
import com.nali.small.entity.memo.server.si.path.SILeFindMove;
import com.nali.small.entity.memo.server.si.path.SILeMineTo;

public class MixSIMYuzu
<
	BD extends IBothDaE,
	E extends EntityLe,
	I extends IMixE<BD, E>,
	S extends ServerLe<BD, E, I, ?>
> extends MixSIELock<BD, E, I, S>
{
	public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
	{
		622
	};

	public MixSIMYuzu(S s)
	{
		super(s, new SI[]
		{
			new SIESound(s),

			new SIEArea(s),
			new SIEOwner(s),
			new SILeEat(s),

			new SIEPat(s),

			new SIELock(s),
			new SILeLockDMG(s),
			new SILeMineTo(s),
			new SIEUseTo(s),
			new SIESit(s),
			new SIELocation(s),
			new SIEFollow(s),
			new SIERevive(s),
			new SIECareOwner(s),
			new SILeAttack(s),
			new SIEManageItem(s),
			new SILeInv(s),
			new SIERandomWalk(s),
			new SIELookTo(s),
			new SIERandomLook(s),

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
//		sileattack.max_magic_point = 4;
		sileattack.minimum_distance = 10.0F;
	}
}
