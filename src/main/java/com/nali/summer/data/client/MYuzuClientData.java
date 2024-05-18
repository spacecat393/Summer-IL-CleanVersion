package com.nali.summer.data.client;

import com.nali.data.client.SkinningClientData;

import static com.nali.list.data.SummerData.MODEL_STEP;

public class MYuzuClientData implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return MODEL_STEP + 89;
    }

    @Override
    public int StartPart()
    {
        return MODEL_STEP + 90;
    }

    @Override
    public int EndPart()
    {
        return MODEL_STEP + 99;
    }
}
