package com.nali.list.render.s;

import com.nali.data.IBothDaSn;
import com.nali.data.client.ClientData;
import com.nali.data.client.IClientDaS;
import com.nali.render.EntitiesRenderMemory;
import com.nali.summer.data.client.E22LockerClientDa;
import com.nali.summer.render.skinning.SummerRenderS;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class E22LockerRender<BD extends IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends SummerRenderS<BD, RG, RS, RST, RC>
{
    public static ClientData CLIENTDATA = new E22LockerClientDa();

    public E22LockerRender(RST rst, RC rc, BD bd)
    {
        super(rst, rc, bd);
    }
}
