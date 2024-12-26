package com.nali.summer.entity.memo.client.sshifumi;

import com.nali.list.da.BothDaSSHifumi;
import com.nali.list.render.RenderSSHifumi;
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
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientSSHifumi
<
	IE extends InvLe,
	R extends RenderSSHifumi<IE, E, I, MC, MB, MR, ?>,
	E extends EntityLe,
	I extends IMixE<BothDaSSHifumi, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSSHifumi, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BothDaSSHifumi, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BothDaSSHifumi, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BothDaSSHifumi, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde;

	public ClientSSHifumi(I i, R r, SoundE sounde)
	{
		super(i, r);
		this.sounde = sounde;
	}

	public ClientSSHifumi(R r)
	{
		super(r);
	}

	@Override
	public SoundE getSound()
	{
		return this.sounde;
	}
}
