package com.nali.summer.entity.memo.client.yuzu;

import com.nali.list.da.BothDaYuzu;
import com.nali.list.render.RenderYuzu;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.client.ClientLe;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSle;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.TEXTURE_STEP;
import static com.nali.system.ClientLoader.G_LIST;

@SideOnly(Side.CLIENT)
public class MixCIYuzu
<
	BD extends BothDaYuzu,
	R extends RenderYuzu<E, I, ?, MB, MR, C, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BD, R, E, I, ?, MR, C>,
	MR extends MixRenderSle<BD, R, E, I, ?, MB, C>,
	C extends ClientLe<BD, R, E, I, ?, MB, MR>
> extends MixCIE<BD, R, E, I, MB, MR, C>
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

		short key = r.key_short_array[0];

		float scale = r.scale;
		if (key > 195 && key < 222)
		{
			r.texture_map.put(G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8).ebo, 66 + TEXTURE_STEP);
		}
		else if ((key > 221 && key < 250) || (key > 354 && key < 429))
		{
			r.texture_map.put(G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8).ebo, 67 + TEXTURE_STEP);
		}
		else if (key > 249 && key < 266)
		{
			r.texture_map.put(G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8).ebo, 68 + TEXTURE_STEP);
		}
		else if (key > 301 && key < 355)
		{
			r.texture_map.put(G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8).ebo, 69 + TEXTURE_STEP);
		}
		else
		{
			r.texture_map.put(G_LIST.get(BothDaYuzu.IDA.O_StartPart() + 8).ebo, 9 + TEXTURE_STEP);
		}

		E e = i.getE();
		if (key > 716 && key < 768)
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
