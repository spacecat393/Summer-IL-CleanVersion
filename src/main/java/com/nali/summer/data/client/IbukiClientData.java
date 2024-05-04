package com.nali.summer.data.client;

import com.nali.data.client.SkinningClientData;

public class IbukiClientData implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return 127;
    }

    @Override
    public int StartPart()
    {
        return 128;
    }

    @Override
    public int EndPart()
    {
        return 143;
    }
}
