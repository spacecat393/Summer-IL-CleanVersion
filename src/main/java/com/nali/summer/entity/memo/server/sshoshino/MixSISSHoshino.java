package com.nali.summer.entity.memo.server.sshoshino;

import com.nali.list.entity.si.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIEInv;
import com.nali.summer.da.both.BothDaSSHoshino;

public class MixSISSHoshino
<
	IE extends InvLe,
	BD extends BothDaSSHoshino,
	E extends EntityLeInv,
	I extends IMixE<BD, E>,
	S extends ServerLeInv<IE, BD, E, I, ?>
> extends MixSIEInv<BD, E, I, S>
{
	public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
	{
		734
	};

	public MixSISSHoshino(S s)
	{
		super(s);
	}

	@Override
	public void init()
	{
		super.init();
		SILeAttack<BD, E, I, S, ?> sileattack = (SILeAttack<BD, E, I, S, ?>)this.s.ms.si_map.get(SILeAttack.ID);
		sileattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
		sileattack.max_magic_point = 8;
		sileattack.minimum_distance = 32.0F;
	}
}
