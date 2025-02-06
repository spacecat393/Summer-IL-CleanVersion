package com.nali.summer.render;

import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;
import com.nali.render.RenderS;
import com.nali.small.render.IRenderS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.SHADER_STEP;
import static com.nali.list.data.SummerData.TEXTURE_STEP;

@SideOnly(Side.CLIENT)
public class SummerRenderS
<
	BD extends IBothDaO & IBothDaS,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends RenderS<BD> implements IRenderS<BD, R>
{
	public SummerRenderS(BD bd)
	{
		super(bd);
	}

	@Override
	public int getTextureID()
	{
		return TEXTURE_STEP + super.getTextureID();
	}

	@Override
	public int getShaderID()
	{
		return SHADER_STEP + super.getShaderID();
	}

	@Override
	public R getR()
	{
		return (R)this;
	}
}
