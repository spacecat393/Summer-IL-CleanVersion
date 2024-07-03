package com.nali.summer.render.s;

import com.nali.data.IBothDaSn;
import com.nali.data.client.IClientDaS;
import com.nali.render.RenderS;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.SHADER_S_STEP;
import static com.nali.list.data.SummerData.TEXTURE_STEP;

@SideOnly(Side.CLIENT)
public class SummerRenderS<BD extends IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends RenderS<BD, RG, RS, RST, RC>
{
    public SummerRenderS(RST rst, RC rc, BD bd)
    {
        super(rst, rc, bd);
    }

    @Override
    public int getTextureID(RG rg)
    {
        return TEXTURE_STEP + super.getTextureID(rg);
    }

    @Override
    public int getShaderID(RG rg)
    {
        return SHADER_S_STEP + super.getShaderID(rg);
    }
}
