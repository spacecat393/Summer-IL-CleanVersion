package com.nali.summer.data.client;

import com.nali.data.client.SkinningClientData;

public class ResaClientData implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return 64;
    }

    @Override
    public int StartPart()
    {
        return 65;
    }

    @Override
    public int EndPart()
    {
        return 76;
    }
}
