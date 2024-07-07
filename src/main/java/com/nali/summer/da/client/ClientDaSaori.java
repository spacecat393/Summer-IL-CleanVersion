package com.nali.summer.da.client;

import com.nali.da.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.ANIMATION_STEP;
import static com.nali.list.data.SummerData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class ClientDaSaori implements IClientDaS
{
    public static IClientDaS ICLIENTDAS = new ClientDaSaori();

    @Override
    public int AnimationID()
    {
        return ANIMATION_STEP + 11;
    }

    @Override
    public int StartPart()
    {
        return MODEL_S_STEP + 106;
    }

    @Override
    public int EndPart()
    {
        return MODEL_S_STEP + 115;
    }
}
