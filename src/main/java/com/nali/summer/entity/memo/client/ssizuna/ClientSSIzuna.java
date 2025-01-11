package com.nali.summer.entity.memo.client.ssizuna;

import com.nali.list.da.BothDaSSIzuna;
import com.nali.list.render.RenderSSIzuna;
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
import com.nali.small.render.IRenderS;
import com.nali.sound.SoundE;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientSSIzuna
<
	IE extends InvLe,
	R extends RenderSSIzuna<IE, E, I, MC, MB, MR, ?> & IRenderS<BothDaSSIzuna, R>,
	E extends EntityLe,
	I extends IMixE<BothDaSSIzuna, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSSIzuna, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BothDaSSIzuna, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BothDaSSIzuna, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BothDaSSIzuna, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde;

	public ClientSSIzuna(I i, R r, SoundE sounde)
	{
		super(i, r);
		this.sounde = sounde;
	}

	public ClientSSIzuna(R r)
	{
		super(r);
	}

	@Override
	public SoundE getSound()
	{
		return this.sounde;
	}
}
