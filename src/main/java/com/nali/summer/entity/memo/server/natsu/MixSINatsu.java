package com.nali.summer.entity.memo.server.natsu;

import com.nali.da.IBothDaE;
import com.nali.list.entity.si.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIEInv;
import com.nali.list.da.BothDaNatsu;

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

	public MixSINatsu(S s)
	{
		super(s);
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
