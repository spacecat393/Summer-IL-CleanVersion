package com.nali.summer.entity.memo.client.arisu;

import com.nali.list.da.BothDaArisu;
import com.nali.list.render.RenderArisu;
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
public class ClientArisu
<
	IE extends InvLe,
	BD extends BothDaArisu,
	R extends RenderArisu<IE, E, I, MC, MB, MR, ?, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BD, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BD, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BD, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde;

	public ClientArisu(I i, R r, SoundE sounde)
	{
		super(i, r);
		this.sounde = sounde;
	}

	public ClientArisu(R r)
	{
		super(r);
	}
//	@Override
//	public void initFakeFrame()
//	{
////		int max_bones = this.r.rst.memoanimation_list.get(this.r.rc.FrameID()).bones;
////
////		float[] f = new float[]
////		{
////			-1, 0, 0, 0,
////			0, -1, 0, 0,
////			0, 0, -1, 0,
////			0, 0, 0, 1
////		};
////		System.arraycopy(f, 0, this.r.skinning_float_array, 0, 16);
////		for (int i = 0; i < max_bones; ++i)
////		{
////			System.arraycopy(M4x4.IDENTITY, 0, this.r.skinning_float_array, i * 16, 16);
////		}
////		this.r.initSkinning();
////		this.r.setSkinning();
////		this.mr.updateSkinning();
////		super.initFakeFrame();
//	}

	@Override
	public SoundE getSound()
	{
		return this.sounde;
	}
}
