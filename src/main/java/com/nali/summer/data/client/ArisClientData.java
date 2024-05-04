package com.nali.summer.data.client;

import com.nali.data.client.SkinningClientData;

public class ArisClientData implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return 27;
    }

    @Override
    public int StartPart()
    {
        return 28;
    }

    @Override
    public int EndPart()
    {
        return 37;
    }
}
