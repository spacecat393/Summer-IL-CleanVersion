package com.nali.summer.entity.memo.client.yuzu;

import com.nali.list.da.BothDaYuzu;
import com.nali.list.render.RenderYuzu;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.TEXTURE_STEP;
import static com.nali.system.ClientLoader.G_LIST;

@SideOnly(Side.CLIENT)
public class MixCIYuzu
<
	IE extends InvLe,
	R extends RenderYuzu<IE, E, I, ?, MB, MR, C>,
	E extends EntityLivingBase,
	I extends IMixE<BothDaYuzu, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaYuzu, R, E, I, ?, MR, C>,
	MR extends MixRenderYuzu<IE, BothDaYuzu, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaYuzu, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaYuzu, R, E, I, MB, MR, C>
{
	public MixCIYuzu(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		R r = this.c.r;
		I i = this.c.i;

		int frame = r.frame_int_array[0];

		float scale = r.scale;
		if (frame > 195 && frame < 222)
		{
			r.texture_map.put(G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8).ebo, 66 + TEXTURE_STEP);
		}
		else if ((frame > 221 && frame < 250) || (frame > 354 && frame < 429))
		{
			r.texture_map.put(G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8).ebo, 67 + TEXTURE_STEP);
		}
		else if (frame > 249 && frame < 266)
		{
			r.texture_map.put(G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8).ebo, 68 + TEXTURE_STEP);
		}
		else if (frame > 301 && frame < 355)
		{
			r.texture_map.put(G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8).ebo, 69 + TEXTURE_STEP);
		}
		else
		{
			r.texture_map.put(G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8).ebo, 9 + TEXTURE_STEP);
		}

		E e = i.getE();
		if (frame > 716 && frame < 768)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			e.width = BothDaYuzu.IDA.E_Width() * scale;
			e.height = BothDaYuzu.IDA.E_Height() * scale;
		}
	}
}
