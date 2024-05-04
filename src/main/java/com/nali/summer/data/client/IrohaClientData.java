package com.nali.summer.data.client;

import com.nali.data.client.SkinningClientData;

public class IrohaClientData implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return 143;
    }

    @Override
    public int StartPart()
    {
        return 144;
    }

    @Override
    public int EndPart()
    {
        return 155;
    }
}
