package com.nali.summer.entity.memo.server.yuzu;

import com.nali.list.entity.SummerE22Locker;
import com.nali.list.entity.si.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIEInv;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaYuzu;

public class MixSIYuzu
<
	IE extends InvLe,
	SD extends ISoundDaLe,
	BD extends BothDaYuzu,
	E extends EntityLeInv,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	S extends ServerLeInv<IE, SD, BD, E, I, ?>
> extends MixSIEInv<BD, E, I, S>
{
	public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
	{
		649,
		650,
		651
	};

	public MixSIYuzu(S s)
	{
		super(s);
	}

	@Override
	public void init()
	{
		super.init();
		((SILePlayWithSSe)this.s.ms.si_map.get(SILePlayWithSSe.ID)).e2_class = SummerE22Locker.class;

		SILeAttack<SD, BD, E, I, S, ?> sileattack = (SILeAttack<SD, BD, E, I, S, ?>)this.s.ms.si_map.get(SILeAttack.ID);
		sileattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
		sileattack.max_magic_point = 4;
		sileattack.minimum_distance = 10.0F;
	}
}
