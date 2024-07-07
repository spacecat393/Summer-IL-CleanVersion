package com.nali.summer.da.client;

import com.nali.da.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.ANIMATION_STEP;
import static com.nali.list.data.SummerData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class ClientDaResa implements IClientDaS
{
    public static IClientDaS ICLIENTDAS = new ClientDaResa();

    @Override
    public int AnimationID()
    {
        return ANIMATION_STEP + 6;
    }

    @Override
    public int StartPart()
    {
        return MODEL_S_STEP + 58;
    }

    @Override
    public int EndPart()
    {
        return MODEL_S_STEP + 69;
    }
}
