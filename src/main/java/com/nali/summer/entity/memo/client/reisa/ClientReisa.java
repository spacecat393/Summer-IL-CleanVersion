package com.nali.summer.entity.memo.client.reisa;

import com.nali.list.da.BothDaReisa;
import com.nali.list.render.RenderReisa;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.SoundE;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientReisa
<
	IE extends InvLe,
	BD extends BothDaReisa,
	R extends RenderReisa<IE, E, I, MC, MB, MR, ?, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BD, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BD, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BD, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde;

	public ClientReisa(I i, R r, SoundE sounde)
	{
		super(i, r);
		this.sounde = sounde;
	}

	public ClientReisa(R r)
	{
		super(r);
	}

	@Override
	public SoundE getSound()
	{
		return this.sounde;
	}
}
