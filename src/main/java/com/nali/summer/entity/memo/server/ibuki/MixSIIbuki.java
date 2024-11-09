package com.nali.summer.entity.memo.server.ibuki;

import com.nali.list.entity.SummerIroha;
import com.nali.list.entity.si.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIEInv;
import com.nali.summer.da.both.BothDaIbuki;

public class MixSIIbuki
<
	IE extends InvLe,
	BD extends BothDaIbuki,
	E extends EntityLeInv,
	I extends IMixE<BD, E>,
	S extends ServerLeInv<IE, BD, E, I, ?>
> extends MixSIEInv<BD, E, I, S>
{
	public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
	{
		491,
		494,
		496
	};

	public SILePlayWithSSle sileplaywithssle;

	public MixSIIbuki(S s)
	{
		super(s);
	}

	@Override
	public void init()
	{
		super.init();
		this.sileplaywithssle = ((SILePlayWithSSle)this.si_map.get(SILePlayWithSSle.ID));
		this.sileplaywithssle.e2_class = SummerIroha.class;
//		((SILePlayWithSSle)this.s.ms.si_map.get(SILePlayWithSSle.ID)).e2_class = SummerIroha.class;

		SILeAttack<BD, E, I, S, ?> sileattack = (SILeAttack<BD, E, I, S, ?>)this.s.ms.si_map.get(SILeAttack.ID);
		sileattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
		sileattack.max_magic_point = 32;
		sileattack.minimum_distance = 17.0F;
	}
}
