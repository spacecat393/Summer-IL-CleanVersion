package com.nali.summer.entity.memo.client.arisu;

import com.nali.list.da.BothDaArisu;
import com.nali.list.render.RenderArisu;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.client.ClientLe;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.IClientS;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSle;
import com.nali.sound.SoundE;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientArisu
<
	BD extends BothDaArisu,
	R extends RenderArisu<E, I, MC, MB, MR, ?, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, R, E, I, MB, MR, ?>,
	MB extends MixBoxSle<BD, R, E, I, MC, MR, ?>,
	MR extends MixRenderSle<BD, R, E, I, MC, MB, ?>
> extends ClientLe<BD, R, E, I, MC, MB, MR> implements IClientESound, IClientS
{
	public static byte[] ACTION_STATE_BYTE_ARRAY = new byte[]
	{
		1,//Vital_Death*
		1,//Formation_Idle*
		1,//Attack_Start*
		1,//Move_Ing*
		1,//Move_End*
		1,//Cafe_Walk*
		1,//Callsign*
		1,//Cafe_Reaction*
		1,//Normal_Idle*
		1,//Cafe_Idle*
		1,//Attack_Ing*
		1,//Attack_Delay-Attack_End*
		1//Reload*
	};

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

	@Override
	public byte[] getActionStateByteArray()
	{
		return ACTION_STATE_BYTE_ARRAY;
	}
}
