package com.nali.summer.entity.memo.server.ssshizuko;

import com.nali.list.entity.si.*;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIEInv;
import com.nali.sound.ISoundDaLe;
import com.nali.summer.da.both.BothDaSSShizuko;

public class MixSISSShizuko
<
	IE extends InvLe,
	SD extends ISoundDaLe,
	BD extends BothDaSSShizuko<SD>,
	E extends EntityLeInv,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	S extends ServerLeInv<IE, SD, BD, E, I, ?>
> extends MixSIEInv<BD, E, I, S>
{
	public static byte[] SI_BYTE_ARRAY =
	{
		SIEInvLockInv.ID,
		SILeLockDMG.ID,
		SILeMineTo.ID,
		SILeWalkTo.ID,
		SILeUseTo.ID,
		SIESit.ID,
		SILeSetLocation.ID,
		SILeFollow.ID,
		SILeRevive.ID,
		SILeProtect.ID,
//		SILeCareOwner.ID,
//		SILeAttack.ID,
		SILeInvManageItem.ID,
		SILeInvGetItem.ID,
		SILeRandomWalk.ID,
		SILeLookTo.ID,
		SILeRandomLook.ID
	};

	public MixSISSShizuko(S s)
	{
		super(s);
	}

//	@Override
//	public void init()
//	{
//		super.init();
//	}
}
