package com.nali.summer.entity.memo.client.sshoshino;

import com.nali.list.da.BothDaSSHoshino;
import com.nali.list.render.RenderSSHoshino;
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
public class ClientSSHoshino
<
	IE extends InvLe,
	R extends RenderSSHoshino<IE, E, I, MC, MB, MR, ?> & IRenderS<BothDaSSHoshino, R>,
	E extends EntityLe,
	I extends IMixE<BothDaSSHoshino, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSSHoshino, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BothDaSSHoshino, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BothDaSSHoshino, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BothDaSSHoshino, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde;

	public ClientSSHoshino(I i, R r, SoundE sounde)
	{
		super(i, r);
		this.sounde = sounde;
	}

	public ClientSSHoshino(R r)
	{
		super(r);
	}

	@Override
	public SoundE getSound()
	{
		return this.sounde;
	}
}
