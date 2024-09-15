package com.nali.summer.entity.memo.server.natsu;

import com.nali.list.entity.si.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIEInv;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaNatsu;

public class MixSINatsu
<
	IE extends InvLe,
	SD extends ISoundDaLe,
	BD extends BothDaNatsu,
	E extends EntityLeInv,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	S extends ServerLeInv<IE, SD, BD, E, I, ?>
> extends MixSIEInv<BD, E, I, S>
{
	public static byte[] SI_BYTE_ARRAY =
	{
		SIESound.ID,

		SIEArea.ID,
		SIEOwner.ID,
		SIEInvOpenInv.ID,
		SILeEat.ID,

		SIEPat.ID,

		SIEInvLockInv.ID,
		SILeLockDMG.ID,
		SILeMineTo.ID,
		SILeUseTo.ID,
		SIESit.ID,
		SILeSetLocation.ID,
		SILeFollow.ID,
		SILeRevive.ID,
		SILeHeal.ID,
		SILeCareOwner.ID,
		SILeAttack.ID,
		SILeInvManageItem.ID,
		SILeInvGetItem.ID,
		SILeRandomWalk.ID,
		SILeLookTo.ID,
		SILeRandomLook.ID,

		SIEFrame.ID,

		SILeFindMove.ID,
		SILeMove.ID,
		SILeWalkTo.ID,
		SIELook.ID,
		SILeJump.ID
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

	public MixSINatsu(S s)
	{
		super(s);
	}

	@Override
	public void init()
	{
		super.init();
		SILeAttack<SD, BD, E, I, S, ?> sileattack = (SILeAttack<SD, BD, E, I, S, ?>)this.s.ms.si_map.get(SILeAttack.ID);
		sileattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
//		sileattack.max_magic_point = 16;
		sileattack.minimum_distance = 8.0F;

		((SILeHeal<SD, BD, E, I, S, ?>)this.s.ms.si_map.get(SILeHeal.ID)).heal_frame_int_array = HEAL_FRAME_INT_ARRAY;
	}
}
