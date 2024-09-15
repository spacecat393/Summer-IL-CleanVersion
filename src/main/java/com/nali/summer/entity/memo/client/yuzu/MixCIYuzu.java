package com.nali.summer.entity.memo.client.yuzu;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderYuzu;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.sound.ISoundDaLe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.TEXTURE_STEP;
import static com.nali.system.ClientLoader.G_LIST;

@SideOnly(Side.CLIENT)
public class MixCIYuzu
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderYuzu<IE, E, I, ?, MB, MR, C, SD, BD, RC>,
	SD extends ISoundDaLe,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	MB extends MixBoxSleInv<RC, R, SD, BD, E, I, ?, MR, C>,
	MR extends MixRenderYuzu<IE, RC, R, SD, BD, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, RC, R, SD, BD, E, I, ?, MB, MR> & IClientERsInv
> extends MixCIE<RC, R, BD, E, I, MB, MR, C>
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
		RC rc = r.rc;
//		RST rst = this.r.rst;
		if (frame > 195 && frame < 222)
		{
//			skinningrender.texture_index_int_array[8] = 66;
//			skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[rc.StartPart() + 8].ebo, 66);
//			skinningrender.texture_map.put(((OpenGLObjectMemory)skinningrender.dataloader.object_array[rc.StartPart() + 8]).ebo, 66);
			r.texture_map.put(G_LIST.get(rc.StartPart() + 8).ebo, 66 + TEXTURE_STEP);
		}
		else if ((frame > 221 && frame < 250) || (frame > 354 && frame < 429))
		{
//			skinningrender.texture_index_int_array[8] = 67;
//			skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[rc.StartPart() + 8].ebo, 67);
			r.texture_map.put(G_LIST.get(rc.StartPart() + 8).ebo, 67 + TEXTURE_STEP);
		}
		else if (frame > 249 && frame < 266)
		{
//			skinningrender.texture_index_int_array[8] = 68;
//			skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[rc.StartPart() + 8].ebo, 68);
			r.texture_map.put(G_LIST.get(rc.StartPart() + 8).ebo, 68 + TEXTURE_STEP);
		}
		else if (frame > 301 && frame < 355)
		{
//			skinningrender.texture_index_int_array[8] = 69;
//			skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[rc.StartPart() + 8].ebo, 69);
			r.texture_map.put(G_LIST.get(rc.StartPart() + 8).ebo, 69 + TEXTURE_STEP);
		}
		else
		{
//			skinningrender.texture_index_int_array[8] = 9;
//			skinningrender.texture_map.put(skinningrender.dataloader.openglobjectmemory_array[rc.StartPart() + 8].ebo, 9);
			r.texture_map.put(G_LIST.get(rc.StartPart() + 8).ebo, 9 + TEXTURE_STEP);
		}

		E e = i.getE();
		if (frame > 716 && frame < 768)
		{
			e.width = 1.5F * scale;
			e.height = 0.2F * scale;
		}
		else
		{
			BD bd = i.getBD();
			e.width = bd.Width() * scale;
			e.height = bd.Height() * scale;
		}
	}
}
