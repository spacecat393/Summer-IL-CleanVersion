package com.nali.summer.render;

import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;
import com.nali.render.RenderS;
import com.nali.system.opengl.memo.client.MemoG;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.*;

@SideOnly(Side.CLIENT)
public class SummerRenderS
<
	BD extends IBothDaO & IBothDaS
> extends RenderS<BD>
{
	public SummerRenderS(BD bd)
	{
		super(bd);
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
