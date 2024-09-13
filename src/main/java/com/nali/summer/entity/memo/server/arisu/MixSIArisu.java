package com.nali.summer.entity.memo.server.arisu;

import com.nali.list.entity.si.SIEFrame;
import com.nali.list.entity.si.SILeAttack;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.server.ServerLe;
import com.nali.small.entity.memo.server.si.MixSIEInv;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaArisu;

public class MixSIArisu<SD extends ISoundDaLe, BD extends BothDaArisu<SD>, E extends EntityLeInv, I extends IMixE<SD, BD, E>, S extends ServerLe<SD, BD, E, I, ?>> extends MixSIEInv<SD, BD, E, I, S>
{
	public static byte[] SI_BYTE_ARRAY =
	{
		AIEArea.ID,
		AIEOwner.ID,
		AIEInvOpenInv.ID,
		AILeEat.ID,

		AIEPat.ID,

		AIEInvLockInv.ID,
		AILeLockDMG.ID,
		AILeMineTo.ID,
//		AILeWalkTo.ID,
		AILeUseTo.ID,
		AIESit.ID,
		AILeSetLocation.ID,
		AILeFollow.ID,
		AILeRevive.ID,
		AILeCareOwner.ID,
		SILeAttack.ID,
		AILeInvManageItem.ID,
		AILeInvGetItem.ID,
		AILeRandomWalk.ID,
		AILeLookTo.ID,
		AILeRandomLook.ID,

		//frame
		SIEFrame.ID,

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

	public MixSIArisu(S s)
	{
		super(s);
	}

	@Override
	public void init()
	{
		super.init();
		SILeAttack<SD, BD, E, I, S, ?> sileattack = (SILeAttack<SD, BD, E, I, S, ?>)this.s.ms.si_map.get(SILeAttack.ID);
		sileattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
		sileattack.max_magic_point = 2;
		sileattack.minimum_distance = 48.0F;
	}
}
