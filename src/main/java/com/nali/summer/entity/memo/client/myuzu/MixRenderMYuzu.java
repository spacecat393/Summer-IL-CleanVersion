package com.nali.summer.entity.memo.client.myuzu;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;
import com.nali.render.RenderS;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixRenderMYuzu
<
	IE extends InvLe,
	BD extends IBothDaE & IBothDaO & IBothDaS,
	R extends RenderS<BD>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, R, E, I, MB, ?, C>,
	MB extends MixBoxSleInv<BD, R, E, I, MC, ?, C>,
	C extends ClientLeInv<IE, BD, R, E, I, MC, MB, ?>
> extends MixRenderSleInv<IE, BD, R, E, I, MC, MB, C>
{
	public MixRenderMYuzu(C c)
	{
		super(c);
		this.shadow_opaque = 0.5F;
		this.shadow_size = 0.25F;
	}
}
