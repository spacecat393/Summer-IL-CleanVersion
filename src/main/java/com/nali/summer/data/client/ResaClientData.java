package com.nali.summer.data.client;

import com.nali.data.client.SkinningClientData;

import static com.nali.list.data.SummerData.MODEL_STEP;

public class ResaClientData implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return MODEL_STEP + 64;
    }

    @Override
    public int StartPart()
    {
        return MODEL_STEP + 65;
    }

    @Override
    public int EndPart()
    {
        return MODEL_STEP + 76;
    }
}
