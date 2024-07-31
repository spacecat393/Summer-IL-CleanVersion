package com.nali.summer.da.client;

import com.nali.da.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.*;

@SideOnly(Side.CLIENT)
public class ClientDaSSIzuna implements IClientDaS
{
    public static IClientDaS ICLIENTDAS = new ClientDaSSIzuna();

    @Override
    public int FrameID()
    {
        return FRAME_STEP + 5;
    }

    @Override
    public int StartPart()
    {
        return MODEL_STEP + 49;
    }

    @Override
    public int EndPart()
    {
        return MODEL_STEP + 58;
    }
}
