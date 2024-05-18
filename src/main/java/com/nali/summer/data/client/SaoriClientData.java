package com.nali.summer.data.client;

import com.nali.data.client.SkinningClientData;

import static com.nali.list.data.SummerData.MODEL_STEP;

public class SaoriClientData implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return MODEL_STEP + 117;
    }

    @Override
    public int StartPart()
    {
        return MODEL_STEP + 118;
    }

    @Override
    public int EndPart()
    {
        return MODEL_STEP + 127;
    }
}
