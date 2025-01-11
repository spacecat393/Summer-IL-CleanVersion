package com.nali.summer.entity.memo.client.iroha;

import com.nali.list.da.BothDaIroha;
import com.nali.list.render.RenderIroha;
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
public class ClientIroha
<
	IE extends InvLe,
	R extends RenderIroha<IE, E, I, MC, MB, MR, ?> & IRenderS<BothDaIroha, R>,
	E extends EntityLe,
	I extends IMixE<BothDaIroha, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaIroha, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BothDaIroha, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BothDaIroha, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BothDaIroha, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde;

	public ClientIroha(I i, R r, SoundE sounde)
	{
		super(i, r);
		this.sounde = sounde;
	}

	public ClientIroha(R r)
	{
		super(r);
	}

	@Override
	public SoundE getSound()
	{
		return this.sounde;
	}
}
