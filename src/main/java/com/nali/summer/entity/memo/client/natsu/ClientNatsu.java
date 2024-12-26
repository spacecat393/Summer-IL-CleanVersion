package com.nali.summer.entity.memo.client.natsu;

import com.nali.list.da.BothDaNatsu;
import com.nali.list.render.RenderNatsu;
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
public class ClientNatsu
<
	IE extends InvLe,
	R extends RenderNatsu<IE, E, I, MC, MB, MR, ?>,
	E extends EntityLe,
	I extends IMixE<BothDaNatsu, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaNatsu, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BothDaNatsu, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BothDaNatsu, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BothDaNatsu, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde;

	public ClientNatsu(I i, R r, SoundE sounde)
	{
		super(i, r);
		this.sounde = sounde;
	}

	public ClientNatsu(R r)
	{
		super(r);
	}

	@Override
	public SoundE getSound()
	{
		return this.sounde;
	}
}
