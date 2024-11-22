package com.nali.summer.entity.memo.client.reisa;

import com.nali.list.da.BothDaReisa;
import com.nali.list.render.RenderReisa;
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
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientReisa
<
	IE extends InvLe,
	R extends RenderReisa<IE, E, I, MC, MB, MR, ?>,
	E extends EntityLivingBase,
	I extends IMixE<BothDaReisa, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaReisa, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BothDaReisa, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BothDaReisa, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BothDaReisa, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde = new SoundE();

	public ClientReisa(I i, R r)
	{
		super(i, r);
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
