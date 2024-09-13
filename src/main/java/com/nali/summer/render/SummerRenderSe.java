package com.nali.summer.render;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.RenderSe;
import com.nali.system.opengl.memo.client.MemoG;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.SHADER_STEP;
import static com.nali.list.data.SummerData.TEXTURE_STEP;

@SideOnly(Side.CLIENT)
public class SummerRenderSe<E extends Entity, I extends IMixE<SD, BD, E>, MC extends MixCIE<RC, ?, SD, BD, E, I, MB, MR, C>, MB extends MixBoxE<RC, ?, SD, BD, E, I, MC, MR, C>, MR extends MixRenderSe<RC, ?, SD, BD, E, I, MC, MB, C>, C extends ClientE<RC, ?, SD, BD, E, I, MC, MB, MR>, SD, BD extends IBothDaNe & IBothDaSn, RC extends IClientDaS> extends RenderSe<E, I, MC, MB, MR, C, SD, BD, RC>
{
	public SummerRenderSe(RC rc, BD bd)
	{
		super(rc, bd);
	}

	@Override
	public int getTextureID(MemoG rg)
	{
		return TEXTURE_STEP + super.getTextureID(rg);
	}

	@Override
	public int getShaderID(MemoG rg)
	{
		return SHADER_STEP + super.getShaderID(rg);
	}
}
