package com.nali.list.render.s;

import com.nali.data.IBothDaSn;
import com.nali.data.client.IClientDaS;
import com.nali.summer.da.both.BothDaE22Locker;
import com.nali.summer.da.client.ClientDaE22Locker;
import com.nali.summer.render.SummerRenderS;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.Nali.I;

@SideOnly(Side.CLIENT)
public class RenderE22Locker<BD extends IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends SummerRenderS<BD, RG, RS, RST, RC>
{
//    public static IClientDaS ICLIENTDAS = new E22LockerClientDa();
    public RenderE22Locker()
    {
        this((RST)I.clientloader.stores, (RC) ClientDaE22Locker.ICLIENTDAS, (BD) BothDaE22Locker.IBOTHDASN);
    }

    public RenderE22Locker(RST rst, RC rc, BD bd)
    {
        super(rst, rc, bd);
    }
}
