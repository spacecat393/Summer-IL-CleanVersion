package com.nali.summer.data.client;

import com.nali.data.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.*;

@SideOnly(Side.CLIENT)
public class IrohaClientDa implements IClientDaS
{
    @Override
    public int AnimationID()
    {
        return ANIMATION_STEP + 13;
    }

    @Override
    public int StartPart()
    {
        return MODEL_S_STEP + 130;
    }

    @Override
    public int EndPart()
    {
        return MODEL_S_STEP + 141;
    }
}
