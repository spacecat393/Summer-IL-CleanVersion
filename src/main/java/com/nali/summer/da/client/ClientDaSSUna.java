package com.nali.summer.da.client;

import com.nali.da.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.ANIMATION_STEP;
import static com.nali.list.data.SummerData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class ClientDaSSUna implements IClientDaS
{
    public static IClientDaS ICLIENTDAS = new ClientDaSSUna();

    @Override
    public int AnimationID()
    {
        return ANIMATION_STEP + 5;
    }

    @Override
    public int StartPart()
    {
        return MODEL_S_STEP + 49;
    }

    @Override
    public int EndPart()
    {
        return MODEL_S_STEP + 58;
    }
}
