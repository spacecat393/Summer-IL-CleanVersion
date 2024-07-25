package com.nali.summer.da.client;

import com.nali.da.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.*;

@SideOnly(Side.CLIENT)
public class ClientDaSSHino implements IClientDaS
{
    public static IClientDaS ICLIENTDAS = new ClientDaSSHino();

    @Override
    public int FrameID()
    {
        return FRAME_STEP + 7;
    }

    @Override
    public int StartPart()
    {
        return MODEL_STEP + 69;
    }

    @Override
    public int EndPart()
    {
        return MODEL_STEP + 81;
    }
}
