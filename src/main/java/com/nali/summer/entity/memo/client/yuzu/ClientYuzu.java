package com.nali.summer.entity.memo.client.yuzu;

import com.nali.list.da.BothDaYuzu;
import com.nali.list.render.RenderYuzu;
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
public class ClientYuzu
<
	IE extends InvLe,
	R extends RenderYuzu<IE, E, I, MC, MB, MR, ?> & IRenderS<BothDaYuzu, R>,
	E extends EntityLe,
	I extends IMixE<BothDaYuzu, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaYuzu, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BothDaYuzu, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BothDaYuzu, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BothDaYuzu, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde;

	public ClientYuzu(I i, R r, SoundE sounde)
	{
		super(i, r);
		this.sounde = sounde;
	}

	public ClientYuzu(R r)
	{
		super(r);
	}

//	@Override
//	public void initFakeFrame()
//	{
//
//	}

	@Override
	public SoundE getSound()
	{
		return this.sounde;
	}
}
