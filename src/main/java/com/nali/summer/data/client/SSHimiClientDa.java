package com.nali.summer.data.client;

import com.nali.data.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.SummerData.ANIMATION_STEP;
import static com.nali.list.data.SummerData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class SSHimiClientDa implements IClientDaS
{
    @Override
    public int AnimationID()
    {
        return ANIMATION_STEP/* + 0*/;
    }

    @Override
    public int StartPart()
    {
        return MODEL_S_STEP/* + 0*/;
    }

    @Override
    public int EndPart()
    {
        return MODEL_S_STEP + 13;
    }
}
