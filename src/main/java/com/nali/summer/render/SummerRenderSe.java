package com.nali.summer.render;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.IClientS;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.RenderSe;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.SHADER_S_STEP;
import static com.nali.list.data.SummerData.TEXTURE_STEP;

@SideOnly(Side.CLIENT)
public class SummerRenderSe<E extends Entity, I extends IMixE<SD, BD, E>, MB extends MixBoxE<RG, RS, RC, RST, ?, SD, BD, E, I, MR, C>, MR extends MixRenderSe<RG, RS, RC, RST, ?, SD, BD, E, I, MB, C>, C extends ClientE<RG, RS, RC, RST, ?, SD, BD, E, I, MB, MR> & IClientS<RG, RS, RC, RST, ?, SD, BD, E, I, MR>, SD, BD extends IBothDaNe & IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends RenderSe<E, I, MB, MR, C, SD, BD, RG, RS, RST, RC>
{
    public SummerRenderSe(RST rst, RC rc, BD bd)
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
