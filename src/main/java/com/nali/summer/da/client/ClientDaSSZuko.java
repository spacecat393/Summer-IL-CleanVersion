package com.nali.summer.da.client;

import com.nali.da.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.*;

@SideOnly(Side.CLIENT)
public class ClientDaSSZuko implements IClientDaS
{
    public static IClientDaS ICLIENTDAS = new ClientDaSSZuko();

    @Override
    public int FrameID()
    {
        return FRAME_STEP + 4;
    }

    @Override
    public int StartPart()
    {
        return MODEL_STEP + 37;
    }

    @Override
    public int EndPart()
    {
        return MODEL_STEP + 49;
    }
}
